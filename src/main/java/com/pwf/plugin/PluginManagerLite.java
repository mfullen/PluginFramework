package com.pwf.plugin;

import java.util.Collection;

public interface PluginManagerLite
{
    <P extends Plugin> Collection<P> getPlugins();

    <P extends Plugin> P getPlugin(Class<P> plugin);
}
