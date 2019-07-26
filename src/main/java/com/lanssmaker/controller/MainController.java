package com.lanssmaker.controller;

import com.lanssmaker.clientEventsManager.ClientsEventsManager;
import com.lanssmaker.connector.Connector;
import com.lanssmaker.connector.client.Client;
import com.lanssmaker.logger.Logger;
import com.lanssmaker.logger.log.Log;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private LogPaneController logPaneController;

    @FXML
    private ConnectionPaneController connectionPaneController;

    @FXML
    private ButtonsPaneController buttonsPaneController;

    private ListProperty<Client> clientsProperty;

    private ClientsEventsManager clientsEventsManager = new ClientsEventsManager();

    @FXML
    private void initialize() {
        createLogger();
        createConnector();
        configureConnectionPaneClick();
        configureButtons();
    }


    private void configureConnectionPaneClick() {
        TableView<Client> connectionTable = connectionPaneController.getConnectedClientsTable();

        connectionTable.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                TablePosition tablePosition = connectionTable.getSelectionModel().getSelectedCells().get(0);
                int row = tablePosition.getRow();
                Client client = connectionTable.getItems().get(row);
                ClientsEventsManager.setCurrentSelectedClient(client);
            } catch (IndexOutOfBoundsException e) {
                //ignore
            }
        });
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
        Logger.welcomeLog();
        Logger.addTestLog();
    }

    private void configureButtons() {
        TableView<Client> connectionTable = connectionPaneController.getConnectedClientsTable();

        buttonsPaneController.getScreenButton().disableProperty().bind(Bindings.isEmpty(connectionTable.getSelectionModel().getSelectedItems()));
        buttonsPaneController.getDirsButton().disableProperty().bind(Bindings.isEmpty(connectionTable.getSelectionModel().getSelectedItems()));
        buttonsPaneController.getClearButton().disableProperty().bind(Bindings.isEmpty(connectionTable.getSelectionModel().getSelectedItems()));
    }

}
