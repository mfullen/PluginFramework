package com.pwf.plugin;

/**
 * Plugin interface where the magic happens
 */
public interface Plugin
{
    void initialize(PluginManagerLite pluginManager);

    void start();

    void stop();

    PluginInformation getPluginInformation();
}
