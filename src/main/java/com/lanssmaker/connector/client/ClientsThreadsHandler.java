package com.lanssmaker.connector.client;

import com.lanssmaker.connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientsThreadsHandler {
    private static ClientsThreadsHandler INSTANCE;
    private Connector connector;
    private volatile ObservableList<Client> clientObservableList = FXCollections.observableArrayList();

    private ClientsThreadsHandler() {
    }

    public static ClientsThreadsHandler getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientsThreadsHandler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientsThreadsHandler();

                }
            }
        }
        return INSTANCE;
    }

    public void setConnectorFromEmptyList() {
        this.connector = new Connector(clientObservableList);
    }

    public void add(Client client) {
        connector.connectNewClient(client);
    }

    public synchronized ObservableList<Client> getClientObservableList() {
        return clientObservableList;
    }
}
