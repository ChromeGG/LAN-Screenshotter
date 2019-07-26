package com.lanssmaker.controller;

import com.lanssmaker.clientEventsManager.ClientsEventsManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

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
        configureClearButton();
        configureOptionsButton();
    }

    private void configureOptionsButton() {
        optionsButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/fxml/aboutPane.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setTitle("LAN Screenshotter - about");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void configureClearButton() {
        clearButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Are you sure to remove all screenshot for " + ClientsEventsManager.getCurrentSelectedClient().getIp() + "?",
                    ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                System.out.println("YES Option");
                clientsEventsManager.removeData();
            } else {
                //do nothing
            }
        });
    }

    private void configureDirsButton() {
        dirsButton.setOnAction(event -> {
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
