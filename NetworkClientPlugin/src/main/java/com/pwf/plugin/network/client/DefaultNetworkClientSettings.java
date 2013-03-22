package com.pwf.plugin.network.client;

/**
 *
 * @author mfullen
 */
public class DefaultNetworkClientSettings implements NetworkClientSettings
{
    private int port;
    private boolean SSL;
    private String ipAddress;

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setSSL(boolean SSL)
    {
        this.SSL = SSL;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public int getPort()
    {
        return port;
    }

    public boolean isSSL()
    {
        return SSL;
    }

    @Override
    public String toString()
    {
        return String.format("Ip: %s Port: %d ssl:%b", this.getIpAddress(), this.getPort(), this.isSSL());
    }
}
