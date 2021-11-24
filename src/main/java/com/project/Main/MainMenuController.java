package com.project.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Objects;


import com.project.bakkara.baccaraController;
import com.project.roulette.RoulleteController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
    private static String lineCreate()
    {
        String line = "" + Stats[0];
        for(int i = 1; i < SingInController.SizeOfAccountInfo - 2; i++)
            line += " " + Stats[i];
        return line;
    }

    public static void StatsUpdate() throws IOException
    {
        String line = lineCreate();
        FileReader readfile = new FileReader("Accounts.txt");
        BufferedReader reader = new BufferedReader(readfile);
        String readed = "", password = "";

        int counter = 0;
        {
            String temp;
            while ((temp = reader.readLine()) != null)
            {
                counter++;
                if (counter != SingInController.lineCount)
                    readed += temp + "\n";
                else
                    password = temp.split(" ")[1];
            }

        }

        readfile.close();
        reader.close();


        FileWriter file = new FileWriter("Accounts.txt");
        file.write(readed);
        file.append(SingInController.Name + " " + password + " " + line);
        file.close();
    }

    @FXML
    void initialize()
    {
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

    public static String IntToString(int stat) {
        return Integer.toString(stat);
    }
    public static int StringToInt (String str) {return Integer.parseInt(str);}

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
    void OpenBaccara() throws IOException
    {

        plBaccara.getScene().getWindow().hide();
        Parent Window = FXMLLoader.load(Objects.requireNonNull(baccaraController.class.getResource("baccaraWindow.fxml")));
        StartUp.CreateNewWindow(Window, 900, 600);

    }

}
