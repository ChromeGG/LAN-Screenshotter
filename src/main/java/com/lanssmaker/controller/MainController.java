package com.lanssmaker.controller;

import com.lanssmaker.connector.Connector;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.connector.client.ClientsThreadsHandler;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.logger.log.Log;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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
//        ObservableList<Client> clients = connectionPaneController.getConnectedClientsTable().getItems();
        TableView<Client> clientsTable = connectionPaneController.getConnectedClientsTable();
        clientsTable.setItems(ClientsThreadsHandler.getInstance().getClientObservableList());


        connector = new Connector(ClientsThreadsHandler.getInstance().getClientObservableList());
    }

    private void createLogger() {
        ObservableList<Log> logsList = logPaneController.getLogTable().getItems();
        logger = new Logger(logsList);
        logger.addTestLog();
    }

}
