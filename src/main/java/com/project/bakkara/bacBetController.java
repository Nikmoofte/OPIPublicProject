package com.project.bakkara;


import com.project.Main.MainMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

public class bacBetController {

    public TextField BetField;
    public Button BackBetButton;
    public MenuItem SelfBet;
    public MenuItem OppBet;
    public MenuItem DrawBet;
    public javafx.scene.control.MenuButton MenuButton;

    public void Betting()
    {
        if ((!MenuButton.getText().equals("Choose bet") || !MenuButton.getText().equals("You must choose!"))
                && MainMenuController.StringToInt(BetField.getText()) > 0)
            baccaraController.val = MainMenuController.StringToInt(BetField.getText());
        else
            MenuButton.setText("You must choose!");

    }
    public void CloseBetWindow() throws IOException
    {
        BackBetButton.getScene().getWindow().hide();


    }
    @FXML
    void initialize()
    {
        BetField.setText("");
        MenuButton.setText("Choose bet");
        SelfBet.setOnAction(actionEvent -> {
            MenuButton.setText(SelfBet.getText());
            baccaraController.BetState = baccaraController.state.Win;
        });
        OppBet.setOnAction(actionEvent -> {
            MenuButton.setText(OppBet.getText());
            baccaraController.BetState = baccaraController.state.Lose;
        });
        DrawBet.setOnAction(actionEvent -> {
            MenuButton.setText(DrawBet.getText());
            baccaraController.BetState = baccaraController.state.Draw;
        });

    }
}
