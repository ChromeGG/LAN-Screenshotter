package com.lanssmaker.controller;

import com.lanssmaker.connector.Connector;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.logger.log.Log;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private LogPaneController logPaneController;

    @FXML
    private ConnectionPaneController connectionPaneController;

    @FXML
    private ButtonsPaneController buttonsPaneController;

    private ListProperty<Client> clientsProperty;

    public void initialize() {
        createLogger();
        createConnector();
    }

    private void createConnector() {
        Connector.configureYourself();
        connectionPaneController.getConnectedClientsTable().setItems(Connector.getClients());
        clientsProperty = new SimpleListProperty<>();
        clientsProperty.set(Connector.getClients());
        connectionPaneController.getConnectedClientsTable().itemsProperty().bindBidirectional(clientsProperty);
    }

    private void createLogger() {
        ObservableList<Log> logsList = logPaneController.getLogTable().getItems();
        Logger.setLogsList(logsList);
        Logger.addTestLog();
    }

}
