package com.lanssmaker.server;

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

        while (true) {
            try {
                new EchoClientHandler(serverSocket.accept()).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

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
//            ClientList.getInstance().handlerList.add(this);
//
//            String clientIP = clientSocket.getInetAddress().toString();
//            createDirForClient(clientIP);
//            System.out.println(getPaintedIp() + " connected");

        }

//        private void createDirForClient(String clientIP) {
//            DirectoryCreator directoryCreator = new DirectoryCreator();
//            directoryCreator.prepareDirs(clientIP);
//        }

        public void sendInstruction(int instruction) {
            out.println(instruction);
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

//        public String getPaintedIp() {
//            String paintedIp = Colors.GREEN + clientSocket.getInetAddress() + Colors.RESET;
//            paintedIp = paintedIp.replace("/", "");
//            return paintedIp;
//        }

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

