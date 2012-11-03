package com.pwf.plugin;

import java.security.Policy;

/**
 * PluginManager manages plugins. It is responsible for keeping track of the
 * plugins, activating and deactivating.
 */
public interface PluginManager extends PluginManagerLite
{
    /**
     * Register the plugin to the manager
     *
     * @param plugin the plugin to add
     */
    void addPlugin(Plugin plugin);

    /**
     * This method looks for Plugins on the class path and loads them into the
     * manager. If loading external jars this method must be called
     */
    void loadAllPlugins();

    /**
     * Remove a plugin from the manager
     *
     * @param plugin
     */
    void removePlugin(Plugin plugin);

    /**
     * Activates all registered plugins
     */
    void activateAll();

    /**
     * Deactivates all registered Plugins
     */
    void deactivateAll();

    /**
     * Activate a specific plugin
     *
     * @param plugin
     */
    void activate(Plugin plugin);

    /**
     * Deactivate a specific plugin
     *
     * @param plugin
     */
    void deactivate(Plugin plugin);

    void setSecurityPolicy(Policy policy);

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
