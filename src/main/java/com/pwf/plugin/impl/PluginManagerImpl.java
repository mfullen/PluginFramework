package com.pwf.plugin.impl;

import com.pwf.plugin.Plugin;
import com.pwf.plugin.PluginConfiguration;
import com.pwf.plugin.PluginManager;
import com.pwf.plugin.PluginRepository;
import java.security.Policy;
import java.util.Collection;

class PluginManagerImpl implements PluginManager
{
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

    public void load(Plugin plugin, PluginConfiguration config)
    {
        this.load(plugin);
    }

    public void unload(Plugin plugin)
    {
        this.pluginRepository.removePlugin(plugin);
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