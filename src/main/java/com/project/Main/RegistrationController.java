package com.project.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField reg_login;

    @FXML
    private PasswordField reg_password1;

    @FXML
    private Button signUpButtonReg;

    @FXML
    private TextField reg_secret;

    @FXML
    private PasswordField reg_password2;

    @FXML
    private CheckBox reg_confirm;

    @FXML
    private Button goBackButton;

    @FXML
    void initialize() {
        goBackButton.setOnAction(actionEvent -> {
            goBackButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 700, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Welcome to MRM Casino");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
        signUpButtonReg.setOnAction(actionEvent -> {
            System.out.println("Zig Heil!");
        });
    }
}

