package com.lanssmaker.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.net.URL;

public class AboutPaneController {

    @FXML
    private Button manualButton;

    @FXML
    private Button bugButton;

    @FXML
    private Button sourceButton;


    @FXML
    private void initialize() {
        configureBugButton();
        configureSourceButton();
        configureManualButton();
    }

    private void configureManualButton() {
        manualButton.setOnAction(event -> openWebpage("https://github.com/ChromeGG/LAN-Screenshotter/wiki"));
    }

    private void configureSourceButton() {
        sourceButton.setOnAction(event -> openWebpage("https://github.com/ChromeGG/LAN-Screenshotter"));
    }

    private void configureBugButton() {
        bugButton.setOnAction(event -> openWebpage("https://github.com/ChromeGG/LAN-Screenshotter/issues"));
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

