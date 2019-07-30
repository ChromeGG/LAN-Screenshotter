package com.lanssmaker.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AboutPaneController {

    @FXML
    private Button manualButton;

    @FXML
    private Button bugButton;

    @FXML
    private Button sourceButton;

    @FXML
    private Button gitButton;

    @FXML
    private Button emailButton;


    @FXML
    private void initialize() {
        configureBugButton();
        configureSourceButton();
        configureManualButton();
        configureGitButton();
        configureEmailButton();
    }

    private void configureEmailButton() {
        emailButton.setOnAction(event -> {
            Desktop desktop;
            if (Desktop.isDesktopSupported()
                    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
                URI mailto = null;
                try {
                    mailto = new URI("mailto:john@example.com?subject=Hello%20World");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                try {
                    desktop.mail(mailto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
            }
        });
    }

    private void configureGitButton() {
        gitButton.setOnAction(event -> openWebpage("https://github.com/ChromeGG/"));
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

