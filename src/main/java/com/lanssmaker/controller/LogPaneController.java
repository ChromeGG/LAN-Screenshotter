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


    public TableView<Log> getLogTable() {
        return logTable;
    }


    public void initialize() {
        configureLogTableColumns();
    }

    private void configureLogTableColumns() {
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("logContent"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

}
