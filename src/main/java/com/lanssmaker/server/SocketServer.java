package com.lanssmaker.server;

import com.lanssmaker.connector.ThreadsManager;
import com.lanssmaker.main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {
    private ServerSocket serverSocket;

    @Override
    public void run() {
        System.out.println("SERVER RUNNING");
        prepareServer();
        startServer();
    }

    private void prepareServer() {
        ControlServer controlServer = new ControlServer();
        controlServer.start();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(2345);

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (Main.IS_RUNNING) {
            try {
                new EchoClientHandler(serverSocket.accept()).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }


    public class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        public int counter = 0;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ThreadsManager.addNewThread(this);
        }

        public void close() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Socket getClientSocket() {
            return clientSocket;
        }

        public void setClientSocket(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public PrintWriter getOut() {
            return out;
        }

        public void setOut(PrintWriter out) {
            this.out = out;
        }

        public BufferedReader getIn() {
            return in;
        }

        public void setIn(BufferedReader in) {
            this.in = in;
        }


    }
}

