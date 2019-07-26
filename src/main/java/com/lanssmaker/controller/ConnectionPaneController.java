package com.lanssmaker.controller;

import com.lanssmaker.connector.client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConnectionPaneController {

    @FXML
    private TableView<Client> connectedClientsTable;

    @FXML
    private TableColumn<Client, String> clientIPColumn;

    @FXML
    private void initialize() {
        configureTable();
        configureClientsColumns();
    }

    private void configureTable() {
        connectedClientsTable.getSelectionModel().setCellSelectionEnabled(true);
    }

    private void configureClientsColumns() {
        clientIPColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));
    }

    public TableView<Client> getConnectedClientsTable() {
        return connectedClientsTable;
    }
}
