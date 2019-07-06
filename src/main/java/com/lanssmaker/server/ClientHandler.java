package com.lanssmaker.server;

import com.lanssmaker.client.Client;
import javafx.collections.ObservableList;

public class ClientHandler {
    private ObservableList<Client> songList;

    public ClientHandler(ObservableList<Client> songList) {
        this.songList = songList;
    }

    public ObservableList<Client> getSongList() {
        return songList;
    }

    public void setSongList(ObservableList<Client> songList) {
        this.songList = songList;
    }
}
