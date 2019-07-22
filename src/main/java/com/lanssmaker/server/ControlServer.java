package com.lanssmaker.server;

import com.lanssmaker.connector.ThreadsManager;
import com.lanssmaker.main.Main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ControlServer extends Thread {

    @Override
    public void run() {
        startControl();
    }

    private void startControl() {
        boolean close = false;
        while (Main.IS_RUNNING) {
            try {
                Thread.sleep(3000);
                checkConnections();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkConnections() {
        Set<SocketServer.EchoClientHandler> threads = ThreadsManager.getThreads();
        Set<SocketServer.EchoClientHandler> threadsToRemove = new HashSet<>();


        System.out.println("Sprawdzam");

        for (SocketServer.EchoClientHandler clientThread : threads) {
            clientThread.getOut().println("2");
            try {
                if (clientThread.getIn().ready()) {
                    System.out.println("Odczyt z " + clientThread.getIn().readLine());
                    clientThread.counter = 0;
                } else {
                    clientThread.counter++;
                }
            } catch (IOException e) {
                threadsToRemove.add(clientThread);
            }

            if (clientThread.counter >= 3) {
                threadsToRemove.add(clientThread);
            }
        }
        if (threadsToRemove.size() != 0) {
            ThreadsManager.removeDeathThreads(threadsToRemove);
        }
    }
}
