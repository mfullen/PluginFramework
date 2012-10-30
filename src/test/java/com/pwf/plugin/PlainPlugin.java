package com.pwf.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mfullen
 */
public class PlainPlugin implements Plugin
{
    private static final Logger logger = LoggerFactory.getLogger(DataService.class);

    public void initialize(PluginManagerLite pluginManager)
    {
    }

    public void start()
    {
        logger.debug("PlainPlugin Started");
    }

    public void stop()
    {
        logger.debug("PlainPlugin Stopped");
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
                return "PlainPlugin Test Plugin";
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
                return "com.pwf.plainplugin";
            }
        };
    }
}
