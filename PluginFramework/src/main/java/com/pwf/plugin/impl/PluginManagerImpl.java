package com.pwf.plugin.impl;

import com.pwf.plugin.ErrorEventListener;
import com.pwf.plugin.Plugin;
import com.pwf.plugin.PluginManager;
import com.pwf.plugin.PluginRepository;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Policy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PluginManagerImpl implements PluginManager
{
    private static final Logger logger = LoggerFactory.getLogger(PluginManager.class);
    private static final String PLUGIN_DIR_NAME = "plugins";
    private PluginRepository pluginRepository = null;
    private Policy policy = new PluginPolicy();
    private Collection<ErrorEventListener> errorListeners = new HashSet<ErrorEventListener>();

    public PluginManagerImpl()
    {
        this.setSecurityPolicy(policy);
        System.setSecurityManager(new SecurityManager());
    }

    public PluginManagerImpl(PluginRepository pluginRepository)
    {
        this.setPluginRepository(pluginRepository);
    }

    public final void setPluginRepository(PluginRepository pluginRepository)
    {
        this.pluginRepository = pluginRepository;
    }

    public void addPlugin(Plugin plugin)
    {
        this.pluginRepository.addPlugin(plugin);
    }

    public void loadAllPlugins()
    {
        List<URL> urls = PluginUtils.getJarFilesonClasspathUrl(PLUGIN_DIR_NAME);
        URL[] urlArray = urls.toArray(new URL[0]);
        URLClassLoader urlClassLoader = new URLClassLoader(urlArray);
        ServiceLoader<Plugin> loadedServices = ServiceLoader.load(Plugin.class, urlClassLoader);

        for (Iterator<Plugin> it = loadedServices.iterator(); it.hasNext();)
        {
            Plugin plugin = it.next();
            this.addPlugin(plugin);
        }
        //load all plugins
        for (Plugin plugin : this.getPlugins())
        {
            this.loadPlugin(plugin);
        }
    }

    public void removePlugin(Plugin plugin)
    {
        this.pluginRepository.removePlugin(plugin);
        plugin.onDeactivated();
    }

    public <P extends Plugin> Collection<P> getPlugins()
    {
        Collection<P> plugins = this.pluginRepository.getPlugins();

        return plugins;
    }

    public <P extends Plugin> P getPlugin(Class<P> plugin)
    {
        return this.pluginRepository.getPlugin(plugin);
    }

    public void activateAll()
    {
        for (Plugin plugin : this.getPlugins())
        {
            plugin.onActivated();
        }
    }

    public void deactivateAll()
    {
        for (Plugin plugin : this.getPlugins())
        {
            plugin.onDeactivated();
        }
    }

    public void activate(Plugin plugin)
    {
        this.pluginRepository.getPlugin(plugin).onActivated();
    }

    public void deactivate(Plugin plugin)
    {
        this.pluginRepository.getPlugin(plugin).onDeactivated();
    }

    public final void setSecurityPolicy(Policy policy)
    {
        Policy.setPolicy(policy);
    }

    public void addErrorHandler(ErrorEventListener event)
    {
        this.errorListeners.add(event);
    }

    public void removeErrorHandler(ErrorEventListener event)
    {
        this.errorListeners.remove(event);
    }

    public void reportError(Plugin plugin, Throwable exception)
    {
        for (ErrorEventListener errorEventListener : errorListeners)
        {
            errorEventListener.onErrorOccurred(plugin, exception);
        }
    }

    public <T extends Plugin> T clonePlugin(Class<T> pluginClass)
    {
        T newInstance = null;
        try
        {
            newInstance = pluginClass.newInstance();
        }
        catch (InstantiationException ex)
        {
            this.reportError(newInstance, ex);
        }
        catch (IllegalAccessException ex)
        {
            this.reportError(newInstance, ex);
        }
        finally
        {
            this.loadPlugin(newInstance);
            return newInstance;
        }
    }

    public void loadAndActivatePlugin(Plugin plugin)
    {
        this.addPlugin(plugin);
        this.loadPlugin(plugin);
        this.activate(plugin);
    }

    protected void loadPlugin(Plugin plugin)
    {
        try
        {
            plugin.onLoaded(this);
        }
        catch (Exception e)
        {
            this.reportError(plugin, e);
        }
    }

    public <P extends Plugin> Collection<P> getPlugins(Class<P> klass)
    {
        return this.pluginRepository.getPlugins(klass);
    }
}
