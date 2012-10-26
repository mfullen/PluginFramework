package com.pwf.plugin;

/**
 *
 */
public interface PluginInformation
{
    static String DEFAULT_PROVIDER = "PWF Technology LLC";

    String getName();

    String getVersion();

    String getProvider();

    String getIdentifier();
}
