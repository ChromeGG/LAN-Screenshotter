package com.lanssmaker.connector.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;

    public Client(Socket socket, PrintWriter out, BufferedReader in) {
        this.socket = socket;
        this.out = out;
        this.in = in;
        this.ip = createIP(socket);
    }

    public static String createIP(Socket socket) {
        StringBuilder ip = new StringBuilder(socket.getInetAddress().toString());
        ip.deleteCharAt(0);
        return ip.toString();
    }

    public Socket getSocket() {
        return socket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(socket, client.socket) &&
                Objects.equals(out, client.out) &&
                Objects.equals(in, client.in) &&
                Objects.equals(ip, client.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, out, in, ip);
    }
}
