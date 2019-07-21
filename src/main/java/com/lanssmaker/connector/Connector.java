package com.lanssmaker.connector;

import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.server.SocketServer;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

@Data
@AllArgsConstructor
public class Connector {

    private ObservableList<Client> clients;

    private Connector instance;

    public Connector() {
    }

    public static Client parseThreadToClient(SocketServer.EchoClientHandler clientThread) {
        Socket socket = clientThread.getClientSocket();
        PrintWriter out = clientThread.getOut();
        BufferedReader in = clientThread.getIn();
        return new Client(socket, out, in);
    }

    public void addClient(Client client) {
        clients.add(client);
        Logger.newClientJoin(client.getIp());
    }


    public synchronized ObservableList<Client> getClients() {
        return clients;
    }

    public void setClients(ObservableList<Client> clients) {
        this.clients = clients;
    }

    public void removeClients(List<Client> clientsToRemove) {
        clients.removeAll(clientsToRemove);
        for (Client clientToRemove : clientsToRemove) {
            Logger.clientDisconnected(clientToRemove.getIp());
        }
    }
}
