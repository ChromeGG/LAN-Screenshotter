package com.lanssmaker.controller;

import com.lanssmaker.connector.Connector;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.logger.log.Log;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private LogPaneController logPaneController;

    @FXML
    private ConnectionPaneController connectionPaneController;

    @FXML
    private ButtonsPaneController buttonsPaneController;

    private Logger logger;
    private Connector connector;

    public void initialize() {
        createLogger();
        createConnector();
    }

    private void createConnector() {
//        connectionPaneController.getConnectedClientsTable().setItems(Connector.getClients());
        ObservableList<Client> items = connectionPaneController.getConnectedClientsTable().getItems();
        Connector.setClients(items);
//        ListProperty<Client> clientListProperty = Connector.configureLists(items);
//        connectionPaneController.getConnectedClientsTable().itemsProperty().bindBidirectional(clientListProperty);
    }

    private void createLogger() {
//        logPaneController.getLogTable().setItems(Logger.getLogsList());
        ObservableList<Log> logsList = logPaneController.getLogTable().getItems();
        Logger.setLogsList(logsList);
        Logger.addTestLog();
    }

}
