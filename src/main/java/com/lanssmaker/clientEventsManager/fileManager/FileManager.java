package com.lanssmaker.clientEventsManager.fileManager;

import java.io.File;
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

    public static void createClientFolder(String ip) {
        try {
            String strManyDirectories = "local/screenshots/" + ip;
            boolean success = (new File(strManyDirectories)).mkdirs();
            if (success) {
                System.out.println("Directories: " + strManyDirectories + " created");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
