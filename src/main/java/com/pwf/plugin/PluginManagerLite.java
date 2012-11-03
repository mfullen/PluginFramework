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
}
