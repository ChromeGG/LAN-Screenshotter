package com.lanssmaker.controller;

import com.lanssmaker.connector.Connector;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.logger.log.Log;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ListChangeListener.Change;
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
    private ListProperty<Client> clientsProperty;

    public void initialize() {
        createLogger();
        createConnector();
    }

    private void createConnector() {
        Connector.configureYourself();
        connectionPaneController.getConnectedClientsTable().setItems(Connector.getClients());
        clientsProperty = new SimpleListProperty<>();
//        clientsProperty.set(Connector.getClients());
        clientsProperty.set(Connector.getClients());
        connectionPaneController.getConnectedClientsTable().itemsProperty().bindBidirectional(clientsProperty);
        clientsProperty.addListener(this::onChanged);
    }

    private void onChanged(Change change) {
        while (change.next()) {
            if (change.wasReplaced()) {
                System.out.println("Coś zostało usunięte");
            }
        }
    }

    private void createLogger() {
//        logPaneController.getLogTable().setItems(Logger.getLogsList());
        ObservableList<Log> logsList = logPaneController.getLogTable().getItems();
        Logger.setLogsList(logsList);
        Logger.addTestLog();
    }

}
