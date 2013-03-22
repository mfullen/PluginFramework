package com.pwf.plugin;

/**
 * Handle errors gracefully by alerting the listeners
 *
 * @author mfullen
 */
public interface ErrorHandler
{
    /**
     * Add an ErrorEventListener
     *
     * @param listener
     */
    void addErrorHandler(ErrorEventListener listener);

    /**
     * Remove an ErrorEventListener
     *
     * @param listener
     */
    void removeErrorHandler(ErrorEventListener listener);

    /**
     * Report an Error the listeners
     *
     * @param plugin the plugin which caused the error
     * @param exception the exception thrown
     */
    void reportError(Plugin plugin, Throwable exception);
}
