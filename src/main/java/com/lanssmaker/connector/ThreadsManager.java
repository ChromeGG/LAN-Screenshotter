package com.lanssmaker.connector;

import com.lanssmaker.connector.client.Client;
import com.lanssmaker.server.SocketServer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreadsManager {
    private static Set<SocketServer.EchoClientHandler> threads = new HashSet<>();

    public ThreadsManager() {
    }

    public static Set<SocketServer.EchoClientHandler> getThreads() {
        return threads;
    }

    public static void setThreads(Set<SocketServer.EchoClientHandler> threads) {
        ThreadsManager.threads = threads;
    }

    public static void addNewThread(SocketServer.EchoClientHandler clientThread) {
        threads.add(clientThread);
        Client clientFromThread = Connector.parseThreadToClient(clientThread);
        Connector.addClient(clientFromThread);
    }

    public static void removeDeathThreads(Set<SocketServer.EchoClientHandler> threadsToRemove) {
        threads.removeAll(threadsToRemove);

        List<Client> clientsToRemove = new ArrayList<>();

        for (SocketServer.EchoClientHandler deathThread : threadsToRemove) {
            Client client = Connector.parseThreadToClient(deathThread);
            clientsToRemove.add(client);
        }

        Connector.removeClients(clientsToRemove);
    }
}
