package com.lanssmaker.clientEventsManager;


import com.lanssmaker.clientEventsManager.fileManager.FileManager;
import com.lanssmaker.clientEventsManager.screenshooter.ScreenShotter;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import org.apache.commons.io.FileUtils;

import java.io.File;

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

    public void removeData() {
        File folder = new File("local/screenshots/" + getCurrentSelectedClient().getIp());
        File[] fList = folder.listFiles();

        if (fList != null) {
            for (File f : fList) {
                if (f.getName().endsWith(".jpg")) {
                    FileUtils.deleteQuietly(f);
                }
            }
        }

        Logger.clientDataRemoved(getCurrentSelectedClient().getIp());

    }
}
