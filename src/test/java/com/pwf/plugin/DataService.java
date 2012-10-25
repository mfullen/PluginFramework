package com.pwf.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface DataPlugin extends Plugin
{
    String getData();
}

public class DataService implements DataPlugin
{
    private static final Logger logger = LoggerFactory.getLogger(DataService.class);
    private String data = null;

    public String getData()
    {
        return data;
    }

    public void initialize(PluginManagerLite pluginManager)
    {
        this.data = "My Data";
    }

    public void start()
    {
        logger.debug("Data Plugin Started");
    }

    public void stop()
    {
        logger.debug("Data Plugin Stopped");
    }

    @Override
    public String toString()
    {
        PluginInformation pluginInformation = this.getPluginInformation();
        return String.format("%s (%s) %s © %s", pluginInformation.getName(), pluginInformation.getIdentifier(), pluginInformation.getVersion(),
                pluginInformation.getProvider());
    }

    public PluginInformation getPluginInformation()
    {
        return new PluginInformation()
        {
            public String getName()
            {
                return "DataService Test Plugin";
            }

            public String getVersion()
            {
                return "1.0.0";
            }

            public String getProvider()
            {
                return "PWF Technology LLC";
            }

            public String getIdentifier()
            {
                return "com.pwf.dataservice";
            }
        };
    }
}
