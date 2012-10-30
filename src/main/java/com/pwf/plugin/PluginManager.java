package com.pwf.plugin;

import java.security.Policy;

/**
 *
 */
public interface PluginManager extends PluginManagerLite
{
    void load(Plugin plugin);

    void loadAllPlugins();

    void unload(Plugin plugin);

    void startAll();

    void stopAll();

    void start(Plugin plugin);

    void stop(Plugin plugin);

    void setSecurityPolicy(Policy policy);
}
