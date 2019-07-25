package com.lanssmaker.clientEventsManager;


import com.lanssmaker.clientEventsManager.fileManager.FileManager;
import com.lanssmaker.clientEventsManager.screenshooter.ScreenShotter;
import com.lanssmaker.connector.client.Client;

public class ClientsEventsManager {
    private static Client currentSelectedClient;
    private ScreenShotter screenShotter = new ScreenShotter();
    private FileManager fileManager = new FileManager();

    public ClientsEventsManager() {
    }

    public void makeSS() {
        screenShotter.makeSS(currentSelectedClient);
    }

    public static Client getCurrentSelectedClient() {
        return currentSelectedClient;
    }

    public static void setCurrentSelectedClient(Client currentSelectedClient) {
        ClientsEventsManager.currentSelectedClient = currentSelectedClient;
    }
}
