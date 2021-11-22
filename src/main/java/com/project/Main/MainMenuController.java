package com.project.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController {

    public Label BacWins;
    public Label BacLose;
    public Label BacDraws;
    public Label BacTotalIncome;
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button plRoulette;

    @FXML
    private Button plBaccara;

    @FXML
    private Button plBlackjack;
    @FXML
    void OpenRoullete() throws IOException {
        plRoulette.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(com.project.roulette.RoulleteController.class.getResource("RoulleteWindow.fxml")));
        Scene scene = new Scene(root, 700, 400);
        Stage stage = new Stage();
        stage.setTitle("Roullete");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void OpenBaccara() throws IOException {
        plBaccara.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(com.project.bakkara.baccaraController.class.getResource("baccaraWindow.fxml")));
        Scene scene = new Scene(root, 900, 600);
        Stage stage = new Stage();
        stage.setTitle("Baccara");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
