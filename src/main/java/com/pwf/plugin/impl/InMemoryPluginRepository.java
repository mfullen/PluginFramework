package com.pwf.plugin.impl;

import com.pwf.plugin.Plugin;
import com.pwf.plugin.PluginRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

class InMemoryPluginRepository implements PluginRepository
{
    private Collection<Plugin> plugins = new HashSet<Plugin>();

    public Collection<Plugin> getPlugins()
    {
        Collection<Plugin> unmodifiableCollection = Collections.unmodifiableCollection(plugins);
        return unmodifiableCollection;
    }

    public <P extends Plugin> P getPlugin(Class<P> pluginClass)
    {
        for (Plugin plugin : plugins)
        {
            if (plugin.getClass().equals(pluginClass) || pluginClass.isAssignableFrom(plugin.getClass()))
            {
                return (P) plugin;
            }
        }
        return null;
    }

    public <P extends Plugin> P getPlugin(Plugin plugin)
    {
        return getPlugin((Class<P>) plugin.getClass());
    }

    public void addPlugin(Plugin plugin)
    {
        this.plugins.add(plugin);
    }

    public void removePlugin(Plugin plugin)
    {
        this.plugins.remove(plugin);
    }
}
