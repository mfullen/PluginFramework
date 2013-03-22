package com.pwf.plugin.impl;

import com.pwf.plugin.Plugin;
import com.pwf.plugin.PluginRepository;
import java.util.ArrayList;
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
        Collection<P> foundPlugins = getPlugins(pluginClass);
        if (foundPlugins.isEmpty())
        {
            return null;
        }

        return foundPlugins.iterator().next();
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

    public <P extends Plugin> Collection<P> getPlugins(Class<P> pluginClass)
    {
        Collection<P> foundPlugins = new ArrayList<P>();
        for (Plugin plugin : plugins)
        {
            if (plugin.getClass().equals(pluginClass) || pluginClass.isAssignableFrom(plugin.getClass()))
            {
                foundPlugins.add((P) plugin);
            }
        }
        return foundPlugins;
    }
}
