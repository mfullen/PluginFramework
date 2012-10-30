package com.pwf.plugin.impl;

import com.pwf.plugin.Plugin;
import com.pwf.plugin.PluginManager;
import com.pwf.plugin.PluginRepository;
import java.security.Policy;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PluginManagerImpl implements PluginManager
{
    private static final Logger logger = LoggerFactory.getLogger(PluginManager.class);
    private PluginRepository pluginRepository = null;
    private Policy policy = new PluginPolicy();

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

    public void load(Plugin plugin)
    {
        this.pluginRepository.addPlugin(plugin);
        plugin.initialize(this);
    }

    public void loadAllPlugins()
    {
        ServiceLoader<Plugin> loadedServices = ServiceLoader.load(Plugin.class);

        for (Iterator<Plugin> it = loadedServices.iterator(); it.hasNext();)
        {
            Plugin plugin = it.next();
            this.load(plugin);
        }
    }

    public void unload(Plugin plugin)
    {
        this.pluginRepository.removePlugin(plugin);
        plugin.stop();
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

    public void startAll()
    {
        for (Plugin plugin : this.getPlugins())
        {
            plugin.start();
        }
    }

    public void stopAll()
    {
        for (Plugin plugin : this.getPlugins())
        {
            plugin.stop();
        }
    }

    public void start(Plugin plugin)
    {
        this.pluginRepository.getPlugin(plugin).start();
    }

    public void stop(Plugin plugin)
    {
        this.pluginRepository.getPlugin(plugin).stop();
    }

    public final void setSecurityPolicy(Policy policy)
    {
        Policy.setPolicy(policy);
    }
}
