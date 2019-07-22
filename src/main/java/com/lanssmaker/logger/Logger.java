package com.lanssmaker.logger;


import com.lanssmaker.logger.log.LOG_CATEGORIES;
import com.lanssmaker.logger.log.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logger {
    private static ObservableList<Log> logsList = FXCollections.emptyObservableList();

    public Logger() {
    }

    public static void addTestLog() {
        logsList.add(new Log("Papor zdeh", LOG_CATEGORIES.INFO));
        logsList.add(new Log("Zaasdor zdeh", LOG_CATEGORIES.ERROR));
        logsList.add(new Log("Papai born", LOG_CATEGORIES.USER_CONNECTED));
        logsList.add(new Log("Papai rip", LOG_CATEGORIES.USER_DISCONNECTED));
    }

    public void correctServerStart() {
        logsList.add(new Log("Server started correctly", LOG_CATEGORIES.INFO));
    }

    public void incorrectServerStart() {
        logsList.add(new Log("Something goes wrong with server start", LOG_CATEGORIES.ERROR));
    }

    public static void newClientJoin(String clientIP) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("New client ");
        logMessage.append(clientIP);
        logMessage.append(" connected to server");
        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_CONNECTED));
    }

    public void clientJoin(String clientIP) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(clientIP);
        logMessage.append(" connected to server");
        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_CONNECTED));
    }

    public static void clientDisconnected(String clientIP) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(clientIP);
        logMessage.append(" disconnected from server");
        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_DISCONNECTED));
    }

    public synchronized static ObservableList<Log> getLogsList() {
        return logsList;
    }

    public static void setLogsList(ObservableList<Log> logsList) {
        Logger.logsList = logsList;
    }
}

//public class Logger {
//    private ObservableList<Log> logsList;
//
//    public Logger(ObservableList<Log> logsList) {
//        this.logsList = logsList;
//    }
//
//    public void addTestLog() {
//        logsList.add(new Log("Papor zdeh", LOG_CATEGORIES.INFO));
//        logsList.add(new Log("Zaasdor zdeh", LOG_CATEGORIES.ERROR));
//        logsList.add(new Log("Papai born", LOG_CATEGORIES.USER_CONNECTED));
//        logsList.add(new Log("Papai rip", LOG_CATEGORIES.USER_DISCONNECTED));
//    }
//
//    public void correctServerStart() {
//        logsList.add(new Log("Server started correctly", LOG_CATEGORIES.INFO));
//    }
//
//    public void incorrectServerStart() {
//        logsList.add(new Log("Something goes wrong with server start", LOG_CATEGORIES.ERROR));
//    }
//
//    public void newClientJoin(String clientIP) {
//        StringBuilder logMessage = new StringBuilder();
//        logMessage.append("New client ");
//        logMessage.append(clientIP);
//        logMessage.append(" connected to server");
//        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_CONNECTED));
//    }
//
//    public void clientJoin(String clientIP) {
//        StringBuilder logMessage = new StringBuilder();
//        logMessage.append(clientIP);
//        logMessage.append(" connected to server");
//        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_CONNECTED));
//    }
//
//    public void clientDisconnected(String clientIP) {
//        StringBuilder logMessage = new StringBuilder();
//        logMessage.append(clientIP);
//        logMessage.append(" disconnected from server");
//        logsList.add(new Log(logMessage.toString(), LOG_CATEGORIES.USER_DISCONNECTED));
//    }
//
//    public ObservableList<Log> getLogsList() {
//        return logsList;
//    }
//}

