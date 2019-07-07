package com.lanssmaker.server;

import com.lanssmaker.client.Client;
import javafx.collections.ObservableList;

public class ClientHandler {
    private ObservableList<Client> clientList;

    public ClientHandler(ObservableList<Client> songList) {
        this.clientList = songList;
    }

    public ObservableList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ObservableList<Client> clientList) {
        this.clientList = clientList;
    }
}
