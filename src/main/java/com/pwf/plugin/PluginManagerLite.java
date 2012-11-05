package com.pwf.plugin;

import java.util.Collection;

/**
 * Minimal version of PluginManager
 *
 * @author mfullen
 */
public interface PluginManagerLite extends ErrorHandler
{
    /**
     * Get all the registered plugins
     *
     * @param <P>
     * @return
     */
    <P extends Plugin> Collection<P> getPlugins();

    /**
     * Get a specific registered Plugin
     *
     * @param <P>
     * @param plugin
     * @return
     */
    <P extends Plugin> P getPlugin(Class<P> plugin);

    /**
     * Creates a copy of a Given plugin type. This method does not register the
     * cloned plugin to the manager
     *
     * @param <T> class type
     * @param pluginClass the class
     * @return
     */
    <T extends Plugin> T clonePlugin(Class<T> pluginClass);
}
