package com.lanssmaker.connector;

import com.lanssmaker.clientEventsManager.fileManager.FileManager;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.server.SocketServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Connector {

    private volatile static ObservableList<Client> clients;

    public Connector() {
    }


    public static Client parseThreadToClient(SocketServer.EchoClientHandler clientThread) {
        Socket socket = clientThread.getClientSocket();
        PrintWriter out = clientThread.getOut();
        BufferedReader in = clientThread.getIn();
        return new Client(socket, out, in);
    }

    public static void addClient(Client client) {
        clients.add(client);
        FileManager.createClientFolder(client.getIp());
        Logger.newClientJoin(client.getIp());
    }


    public static synchronized ObservableList<Client> getClients() {
        return clients;
    }

    public static void setClients(ObservableList<Client> clients) {
        Connector.clients = clients;
    }

    public static void removeClients(List<Client> clientsToRemove) {
        clients.removeAll(clientsToRemove);
        for (Client clientToRemove : clientsToRemove) {
            Logger.clientDisconnected(clientToRemove.getIp());
        }
    }

    public static void configureYourself() {
        clients = FXCollections.observableArrayList();
    }

}
