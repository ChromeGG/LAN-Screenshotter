package com.lanssmaker.server;

import com.lanssmaker.connector.ThreadsManager;

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
        while (!close) {
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
                //jesli sie odlaczy i sprawdza .ready() to zwraca false, ale nie rzuca wyjatku
                //wiec nie dodaje do threadsToRemove
                if (clientThread.getIn().ready()) {
                    clientThread.getIn().readLine();
                    clientThread.counter = 0;
                    System.out.println("Odczyt");
                } else {
                    clientThread.counter++;
                }


            } catch (IOException e) {
//                e.printStackTrace();
                threadsToRemove.add(clientThread);
            }

            if (clientThread.counter >= 3){
                threadsToRemove.add(clientThread);
            }
        }

        if (threadsToRemove.size() != 0) {
            ThreadsManager.removeDeathThreads(threadsToRemove);
        }

    }
}
