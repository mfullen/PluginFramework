package com.pwf.plugin;

/**
 * Plugin interface where the magic happens sf
 */
public interface Plugin
{
    void initialize(PluginManagerLite pluginManager);

    void start();

    void stop();

    PluginInformation getPluginInformation();
}
