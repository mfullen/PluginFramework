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
     * This method adds to the plugin manager, loads and activates the plugin.
     * This method only needs to be called when you want to register a plugin
     * that wasn't loaded from the class path
     *
     * @param plugin
     */
    void loadAndActivatePlugin(Plugin plugin);

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
}
