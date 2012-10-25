package com.pwf.plugin;

import com.pwf.plugin.impl.PluginManagerFactoryImpl;

public final class PluginManagerFactory
{
    private static final PluginManagerFactoryImpl factoryImpl = new PluginManagerFactoryImpl();

    private PluginManagerFactory()
    {
    }

    public static PluginManager createPluginManager()
    {
        return factoryImpl.createPluginManager();
    }
}
