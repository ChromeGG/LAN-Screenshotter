package com.lanssmaker.clientEventsManager.fileManager;

import com.lanssmaker.connector.client.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
    public static String createDateFileName() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateString = dateFormat.format(date);
        dateString = dateString.replaceAll("/", "-");
        dateString = dateString.replaceAll(":", ";");
        return dateString;
    }

    public void showDir(Client currentSelectedClient) {

    }
}
