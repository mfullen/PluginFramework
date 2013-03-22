package com.pwf.plugin.network.client;

/**
 *
 * @author mfullen
 */
public interface NetworkEventListener<M>
{
    void onClientConnected();

    void onClientDisconnected();

    void onMessageReceived(M message);

    void onMessageSent(M message);
}
