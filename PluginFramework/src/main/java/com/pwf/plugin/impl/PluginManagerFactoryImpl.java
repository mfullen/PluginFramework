package com.pwf.plugin.impl;

import com.pwf.plugin.PluginManager;
import com.pwf.plugin.PluginRepository;

public class PluginManagerFactoryImpl
{
    public PluginManager createPluginManager()
    {
        PluginRepository repository = new InMemoryPluginRepository();
        PluginManager manager = new PluginManagerImpl(repository);
        return manager;
    }
}
