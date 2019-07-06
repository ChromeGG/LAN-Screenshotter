package com.lanssmaker.controller;

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

    public void initialize() {
        createLogger();

    }

    private void createLogger() {
        ObservableList<Log> logsList = logPaneController.getLogTable().getItems();
        logger = new Logger(logsList);
        logger.addTestLog();
    }

}
