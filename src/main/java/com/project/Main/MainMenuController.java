package com.project.Main;

import java.io.IOException;

import java.util.Objects;


import com.project.roulette.RoulleteController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController {

    public Button signOutButton;


    public static int[] Stats = new int[SingInController.SizeOfAccountInfo - 2];

    @FXML
    private Button plRoulette;

    @FXML
    private Button plBaccara;

    @FXML
    private Button plBlackjack;

    @FXML
    private Label BlackWins;

    @FXML
    private Label BlackLooses;

    @FXML
    private Label BlackDraws;

    @FXML
    private Label BlackTotalIncome;

    @FXML
    private Label BacWins;

    @FXML
    private Label BacLooses;

    @FXML
    private Label BacDraws;

    @FXML
    private Label BacTotalIncome;

    @FXML
    private Label RouletteWins;

    @FXML
    private Label RouletteLooses;

    @FXML
    private Label RouletteTotalIncome;

    @FXML
    private Label nameLabel;

    @FXML
    private Label Money;

    @FXML
    void initialize() {
        BlackWins.setText(IntToString(Stats[1]));
        BlackLooses.setText(IntToString(Stats[2]));
        BlackDraws.setText(IntToString(Stats[3]));
        BlackTotalIncome.setText(IntToString(Stats[4]));
        BacWins.setText(IntToString(Stats[5]));
        BacLooses.setText(IntToString(Stats[6]));
        BacDraws.setText(IntToString(Stats[7]));
        BacTotalIncome.setText(IntToString(Stats[8]));
        RouletteWins.setText(IntToString(Stats[9]));
        RouletteLooses.setText(IntToString(Stats[10]));
        RouletteTotalIncome.setText(IntToString(Stats[11]));
        nameLabel.setText(SingInController.Name + " !");
        Money.setText(IntToString(Stats[0]));
    }

    @FXML
    private String IntToString(int stat) {
        String statStr = Integer.toString(stat);
        return statStr;
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
        StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(com.project.bakkara.baccaraController.class.getResource("baccaraWindow.fxml"))), 900, 600);

    }

}
