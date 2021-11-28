package com.project.Main;


import java.io.*;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


/**
 * Control the registration window
 */
public class RegistrationController {

    public Label IOErrorMessage;
    @FXML
    private TextField reg_login;

    @FXML
    private PasswordField reg_password1;

    @FXML
    private PasswordField reg_password2;


    @FXML
    private Button goBackButton;


    /**
     * Opens SingIn window
     */
    @FXML
    public void BackToSingIn()
    {
        goBackButton.getScene().getWindow().hide();
        try {
            StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(SingInController.class.getResource("SingIn.fxml"))), 700, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checking whether the login is free
     * @param accounts all accounts
     * @return whether the login is free
     */
     private boolean ValidityCheck(String accounts)
     {
         for(String s : accounts.split("\n"))
             if(s.split(" ")[0].equals(reg_login.getText()))
                 return false;
         return true;
     }

    /**
     * reading and saving all accounts,
     * then checking whether the login is free
     * and adding new one.
     * @throws IOException
     */
     @FXML
     public void Registrate() throws IOException {

         if (!(reg_password1.getText() ==  null || reg_password1.getText().equals("")
                 || reg_password2.getText() == null || reg_password2.getText().equals("")
                 || reg_login.getText() == null || reg_login.getText().equals("")))
         {
             if (reg_password1.getText().equals(reg_password2.getText()))
             {
                 FileReader readfile = new FileReader("Accounts.txt");
                 BufferedReader reader = new BufferedReader(readfile);
                 String readed = reader.readLine();
                 {
                     String temp;
                     while ((temp = reader.readLine()) != null)
                     {
                         readed += "\n" + temp;
                     }

                 }
                 readfile.close();
                 reader.close();

                 if (!ValidityCheck(readed))
                 {
                     IOErrorMessage.setTextFill(Color.RED);
                     IOErrorMessage.setText("Such login is already exist!");
                     return;
                 }
                 FileWriter file = new FileWriter("Accounts.txt");
                 file.write(readed);
                 file.append("\n").append(reg_login.getText()).append(" ").append(reg_password1.getText()).append(" 1000");
                 for(int i = 3; i < SingInController.SizeOfAccountInfo; i++)
                     file.append(" 0");
                 file.close();
                 IOErrorMessage.setTextFill(Color.BLACK);
                 IOErrorMessage.setText("Registration Completed");

             } else {
                 IOErrorMessage.setTextFill(Color.RED);
                 IOErrorMessage.setText("Passwords do not match!");
             }
         }
         else {
             IOErrorMessage.setTextFill(Color.RED);
             IOErrorMessage.setText("Not all fields are filled in!");
         }
     }


}

