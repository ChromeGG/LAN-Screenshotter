package com.lanssmaker.connector;

import com.lanssmaker.client.Client;
import javafx.collections.ObservableList;

public class Connector {
    private ObservableList<Client> clientsList;
//    private Logger logger;

    public Connector(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public void connectNewClient(){

    }
}
