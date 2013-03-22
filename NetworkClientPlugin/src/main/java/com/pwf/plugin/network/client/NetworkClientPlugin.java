package com.pwf.plugin.network.client;

import com.pwf.plugin.Plugin;

/**
 *
 */
public interface NetworkClientPlugin<Message> extends Plugin,
                                                      NetworkEventManager<Message>
{
    void connect(NetworkClientSettings networkClientSettings);

    void disconnect();

    void onHandleMessageReceived(Message message);

    void sendMessage(Message message);

    boolean isConnected();

    void setMessageType(Message message);
}
