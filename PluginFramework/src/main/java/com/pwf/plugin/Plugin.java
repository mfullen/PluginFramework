package com.pwf.plugin;

/**
 * Plugin interface where the magic happens.
 */
public interface Plugin
{
    /**
     * The plugin has been loaded by the following manager
     *
     * @param pluginManager the manager which loaded the corresponding plugin
     */
    void onLoaded(PluginManagerLite pluginManager);

    /**
     * The plugin has been activated and is ready to perform operations
     */
    void onActivated();

    /**
     * The plugin has been deactivated and is no longer ready to perform
     * operations
     */
    void onDeactivated();

    /**
     * Get the PluginInformation for this Plugin
     *
     * @return PluginInformation
     */
    PluginInformation getPluginInformation();
}
