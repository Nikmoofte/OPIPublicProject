package com.project.Main;

import java.io.IOException;

import java.util.Objects;


import com.project.roulette.RoulleteController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController {

    public Label BacWins, BacLose, BacDraws, BacTotalIncome;
    public Button signOutButton;


    public static int[] Stats = new int [SingInController.SizeOfAccountInfo - 2];

    @FXML
    private Button plRoulette;

    @FXML
    private Button plBaccara;

    @FXML
    private Button plBlackjack;

    @FXML
    void initialize()
    {

    }

    @FXML
    void BackToSingIn() throws IOException {
        signOutButton.getScene().getWindow().hide();
        StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(StartUp.class.getResource("SingIn.fxml"))), 700, 400);
    }


    @FXML
    void OpenRoullete() throws IOException {
        plRoulette.getScene().getWindow().hide();
        StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(RoulleteController.class.getResource("RoulleteWindow.fxml"))), 700, 400);

    }
    @FXML
    void OpenBaccara() throws IOException {
        plBaccara.getScene().getWindow().hide();
        StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(com.project.bakkara.baccaraController.class.getResource("baccaraWindow.fxml"))),900, 600);

    }

}
