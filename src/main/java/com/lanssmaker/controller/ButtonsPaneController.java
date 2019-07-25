package com.lanssmaker.controller;

import com.lanssmaker.clientEventsManager.ClientsEventsManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;

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
        configureScreenButton();
        configureDirsButton();
    }

    private void configureDirsButton() {

        dirsButton.setOnAction(event -> {
//            FileChooser fc = new FileChooser();
//            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg", "*.jpg"));
//            File file = new File("local/screenshots/" + ClientsEventsManager.getCurrentSelectedClient().getIp());
//            fc.setInitialDirectory(file);
//            File file1 = fc.showOpenDialog(new Stage());
//            try {
//                Desktop.getDesktop().open(file1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            String dirName = "local/screenshots/";
            dirName += ClientsEventsManager.getCurrentSelectedClient().getIp();
            File file = new File(dirName);
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void configureScreenButton() {
        screenButton.setOnAction(event -> clientsEventsManager.makeSS());


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
