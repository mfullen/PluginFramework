package com.pwf.plugin.network.client;

import java.util.Collection;

/**
 *
 * @author mfullen
 */
public interface NetworkEventManager<M>
{
    void addNetworkEventListener(NetworkEventListener<M> listener);

    void removeNetworkEventListener(NetworkEventListener<M> listener);

    Collection<NetworkEventListener<M>> getListeners();
}
