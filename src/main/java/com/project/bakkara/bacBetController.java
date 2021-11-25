package com.project.bakkara;


import com.project.Main.MainMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class bacBetController {

    public TextField BetField;
    public Button BackBetButton;
    public MenuItem SelfBet;
    public MenuItem OppBet;
    public MenuItem DrawBet;
    public javafx.scene.control.MenuButton MenuButton;
    public Label IOErrorMessage;

    public void Betting()
    {
        if ((!MenuButton.getText().equals("Choose bet") || !MenuButton.getText().equals("You must choose!")) )
            if (MainMenuController.StringToInt(BetField.getText()) > 0)
                if (MainMenuController.Stats[0] >= MainMenuController.StringToInt(BetField.getText()))
                {
                    baccaraController.val = MainMenuController.StringToInt(BetField.getText());
                    IOErrorMessage.setTextFill(Color.BLACK);
                    IOErrorMessage.setText("The bet is made");
                }
                else {
                    IOErrorMessage.setTextFill(Color.RED);
                    IOErrorMessage.setText("Not enough money!");
                }
            else {
                IOErrorMessage.setTextFill(Color.RED);
                IOErrorMessage.setText("Invalid numeric input!");
            }
        else {
            IOErrorMessage.setTextFill(Color.RED);
            IOErrorMessage.setText("You must choose bet!");
        }

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
        IOErrorMessage.setTextFill(Color.BLACK);
        if (baccaraController.val != 0)
            IOErrorMessage.setText("Yor bet is " + baccaraController.val);
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
