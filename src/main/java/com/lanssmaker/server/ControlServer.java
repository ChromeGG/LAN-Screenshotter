package com.lanssmaker.server;

import com.lanssmaker.clientEventsManager.screenshooter.ScreenShotter;
import com.lanssmaker.connector.ThreadsManager;
import com.lanssmaker.connector.client.Client;
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
                Thread.sleep(2000);
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
                    String input = clientThread.getIn().readLine();
                    if (input.length() <= 100) {
                        System.out.println("Odczyt z " + input);
                    } else {
                        System.out.println("Recive a SS in Control Thread");
                        ScreenShotter.receiveScreenFromControlThread(input, Client.createIP(clientThread.getClientSocket()));
                    }
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