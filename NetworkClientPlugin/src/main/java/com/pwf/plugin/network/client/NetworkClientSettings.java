package com.pwf.plugin.network.client;

public interface NetworkClientSettings
{
    int getPort();

    boolean isSSL();

    String getIpAddress();
}
