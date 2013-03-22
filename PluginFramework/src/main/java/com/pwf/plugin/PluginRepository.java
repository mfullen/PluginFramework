package com.pwf.plugin;

import java.util.Collection;

/**
 *
 */
public interface PluginRepository
{
    <P extends Plugin> Collection<P> getPlugins();

    <P extends Plugin> Collection<P> getPlugins(Class<P> pluginClass);

    <P extends Plugin> P getPlugin(Class<P> pluginClass);

    <P extends Plugin> P getPlugin(Plugin plugin);

    void addPlugin(Plugin plugin);

    void removePlugin(Plugin plugin);
}
