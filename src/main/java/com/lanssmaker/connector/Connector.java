package com.lanssmaker.connector;

import com.lanssmaker.connector.client.Client;
import javafx.collections.ObservableList;

public class Connector {
    private ObservableList<Client> clientsList;
//    private Logger logger;

    public Connector(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public void connectNewClient(Client client) {
        clientsList.add(client);
    }

    public ObservableList<Client> getClientsList() {
        return clientsList;
    }
}
