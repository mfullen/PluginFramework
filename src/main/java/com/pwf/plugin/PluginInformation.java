package com.pwf.plugin;

/**
 * Information about the plugin
 */
public interface PluginInformation
{
    /**
     * Default Plugin Provider
     */
    static String DEFAULT_PROVIDER = "PWF Technology LLC";

    /**
     * Get the name of the plugin
     *
     * @return
     */
    String getName();

    /**
     * Get the version of the plugin
     *
     * @return
     */
    String getVersion();

    /**
     * Get the Company/Provider who created this Plugin
     *
     * @return
     */
    String getProvider();

    /**
     * The unique identifier of the plugin. Usually the class name
     *
     * @return
     */
    String getIdentifier();
}
