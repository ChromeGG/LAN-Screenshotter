package com.lanssmaker.connector.client;

import com.lanssmaker.connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientsThreadsMenager {
    private static ClientsThreadsMenager INSTANCE;
    private Connector connector;
    private volatile ObservableList<Client> clientObservableList = FXCollections.observableArrayList(); // TU POWINEIN BYC WSTRZYKNIETY  ConnectioPane

    private ClientsThreadsMenager() {
    }

    public static ClientsThreadsMenager getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientsThreadsMenager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientsThreadsMenager();

                }
            }
        }
        return INSTANCE;
    }

    public void setConnectorFromEmptyList(){
        this.connector = new Connector(this.clientObservableList);
    }

    public void add(Client client){
        connector.connectNewClient(client);
    }

    public synchronized ObservableList<Client> getClientObservableList() {
        return clientObservableList;
    }
}
