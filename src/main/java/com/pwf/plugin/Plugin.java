package com.pwf.plugin;

/**
 *
 */
public interface Plugin
{
    void initialize(PluginManagerLite pluginManager);

    void start();

    void stop();

    PluginInformation getPluginInformation();
}
