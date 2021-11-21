package com.project.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Registration.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 700, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Registration");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        });
        signInButton.setOnAction(actionEvent -> {
            String login = null;
            String password = null;
            login = login_field.getText();
            password = password_field.getText();

            if(!(Objects.equals(login,"admin") && Objects.equals(password,"admin"))){
                signUpButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("main-menu.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 700, 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }



            /*signUpButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("main-menu.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 700, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Main menu");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();*/


        });

    }
}
