package com.lanssmaker.clientEventsManager.screenshooter;

import com.lanssmaker.clientEventsManager.fileManager.FileManager;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;


public class ScreenShotter {
    private Client client;

    public static void receiveScreenFromControlThread(String input, String inetAddress) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);

        String fileName = FileManager.createDateFileName();
        try {
            FileUtils.writeByteArrayToFile(new File("local/screenshots/" + inetAddress + "/" + fileName + ".jpg"), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.screenshotTaken(inetAddress);
    }

    public void makeSS(Client currentSelectedClient) {
        this.client = currentSelectedClient;
        sendSignal();
        receiveScreen();
    }

    public void receiveScreen() {
        String encodedString = null;

        try {
            if (client.getIn().ready()) {
                encodedString = client.getIn().readLine();
            }
        } catch (IOException e) {
            Logger.screenshotError(client.getIp());
        }

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String fileName = FileManager.createDateFileName();
            saveScreenshot(client.getIp(), fileName, decodedBytes);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Illegal base64 character 2e");
        }


    }

    private void saveScreenshot(String clientIP, String fileName, byte[] decodedBytes) {
        try {
            FileUtils.writeByteArrayToFile(new File("local/screenshots/" + clientIP + "/" + fileName + ".jpg"), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendSignal() {
        client.getOut().println("1");
    }

}
