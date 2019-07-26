package com.lanssmaker.controller;

import com.lanssmaker.logger.log.LOG_CATEGORIES;
import com.lanssmaker.logger.log.Log;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogPaneController {

    @FXML
    private TableView<Log> logTable;

    @FXML
    private TableColumn<Log, String> timeColumn;

    @FXML
    private TableColumn<Log, String> contentColumn;

    @FXML
    private TableColumn<Log, LOG_CATEGORIES> categoryColumn;

    @FXML
    private void initialize() {
        configureLogTableColumns();
    }

    private void configureLogTableColumns() {
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("logContent"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    public TableView<Log> getLogTable() {
        return logTable;
    }

}
