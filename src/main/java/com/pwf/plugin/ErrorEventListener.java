package com.pwf.plugin;

/**
 * Listener for error events. Used by a manager to report when an error occurs
 * in a plugin to its listeners
 *
 * @author mfullen
 */
public interface ErrorEventListener
{
    /**
     * An Error has occurred
     *
     * @param plugin the plugin which caused the error
     * @param exception the exception that was thrown.
     */
    void onErrorOccurred(Plugin plugin, Throwable exception);
}
