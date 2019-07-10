package com.lanssmaker.connector;

import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import javafx.collections.ObservableList;

public class Connector {
    private ObservableList<Client> clientsList;
    private Logger logger;

    public Connector(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
//        this.logger
    }

    public void connectNewClient(Client client) {
        clientsList.add(client);
//        logger.newClientJoin(client.getIp());
    }

    public ObservableList<Client> getClientsList() {
        return clientsList;
    }
}
