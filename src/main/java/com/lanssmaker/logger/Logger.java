package com.lanssmaker.logger;


import com.lanssmaker.logger.log.LOG_CATEGORIES;
import com.lanssmaker.logger.log.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logger {
    private static ObservableList<Log> logsList = FXCollections.emptyObservableList();

    public Logger() {
    }

    public static void screenshotMaked(String inetAddress) {
        logsList.add(new Log("Screenshot on " + inetAddress + " maked!", LOG_CATEGORIES.INFO));
    }

    public static void clientDataRemoved(String ip) {
        logsList.add(new Log("Screenshots from " + ip + " removed", LOG_CATEGORIES.INFO));
    }

    public static void welcomeLog() {
        logsList.add(new Log("Welcome in LAN Screenshotter by Adam Tkaczyk. Have fun!", LOG_CATEGORIES.INFO));
    }

    public static void newClientJoin(String clientIP) {
        String logMessage = "Client " + clientIP + " connected to server";
        logsList.add(new Log(logMessage, LOG_CATEGORIES.USER_CONNECTED));
    }

    public static void screenshotError(String ip) {
        String logMessage = "Something goes wrong with screenshot on " + ip;
        logsList.add(new Log(logMessage, LOG_CATEGORIES.ERROR));
    }

    public static void clientDisconnected(String clientIP) {
        String logMessage = clientIP + " disconnected from server";
        logsList.add(new Log(logMessage, LOG_CATEGORIES.USER_DISCONNECTED));
    }

    public synchronized static ObservableList<Log> getLogsList() {
        return logsList;
    }

    public static void setLogsList(ObservableList<Log> logsList) {
        Logger.logsList = logsList;
    }
}
