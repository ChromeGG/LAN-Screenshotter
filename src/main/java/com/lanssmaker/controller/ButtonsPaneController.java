package com.lanssmaker.controller;

import com.lanssmaker.clientEventsManager.ClientsEventsManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonsPaneController {

    @FXML
    private Button dirsButton;

    @FXML
    private Button screenButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button optionsButton;

    private ClientsEventsManager clientsEventsManager = new ClientsEventsManager();

    @FXML
    private void initialize() {
        configureEventsToButtons();
    }

    private void configureEventsToButtons() {
        screenButton.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getClickCount() == 1) {
                clientsEventsManager.makeSS();
            }
        });
    }

    public Button getDirsButton() {
        return dirsButton;
    }

    public Button getScreenButton() {
        return screenButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Button getOptionsButton() {
        return optionsButton;
    }
}
