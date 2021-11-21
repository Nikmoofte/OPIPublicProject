package com.project.roulette;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RoulleteController {
    int Account = 100, Sector, bet, Angle, wins = 1, looses = 1;
    boolean SectorChoice, EvenOddChoice, RangeChoice, ColorChoice, Even, Odd, FirstRange, SecondRange, Red, Black;
    String accountStr;
    final static double sectorAngle = 360 / 37d;
    final static int amountSectors = 37;
    final String[] ARRAY = {"zero", "32 Red", "15 Black", "19 Red", "4 Black", "21 Red", "2 Black", "25 Red", "17 Black", "34 Red", "6 Black", "27 Red", "13 Black", "36 Red", "11 Black", "30 Red", "8 Black", "23 Red", "10 Black", "5 Red", "24 Black", "16 Red", "33 Black", "1 Red", "20 Black", "14 Red", "13 Black", "9 Red", "22 Black", "18 Red", "29 Black", "7 Red", "28 Black", "12 Red", "35 Black", "3 Red", "26 Black"};
    final int[] ARRAYINT = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 13, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
    @FXML
    private ImageView RouletteImg;

    @FXML
    private Button ColorBt;

    @FXML
    private Button RangeBt;

    @FXML
    private Button EvenOddBt;

    @FXML
    private Button SectorBt;

    @FXML
    private Button SpinBt;

    @FXML
    private Button ConfirmBt;

    @FXML
    private TextField InputSectorTxtField;

    @FXML
    private TextField BetTxtField;

    @FXML
    private Label AccountLb;

    @FXML
    private Button EvenBt;

    @FXML
    private Button OddBt;

    @FXML
    private Button FirstRangeBt;

    @FXML
    private Button SecondRangeBt;

    @FXML
    private Button RedBt;

    @FXML
    private Button BlackBt;

    @FXML
    private Label ResultLbl;

    @FXML
    private Label WinLooseLb;

    private int getValidBet() throws Exception {
        int num = Integer.parseInt(BetTxtField.getText());
        if  (num > this.Account) {
            throw new Exception();
        }
        if (num <= 0) {
            throw new Exception();
        }

        if ((num < 5) || (num > 10)) {
            throw new Exception();
        }
        return num;
    }

    private void sectorBtAction() {
        try {
            bet = this.getValidBet();
            SectorChoice = true;
            SectorBt.setDisable(true);
            EvenOddBt.setDisable(true);
            RangeBt.setDisable(true);
            ColorBt.setDisable(true);
            BetTxtField.setDisable(true);
            InputSectorTxtField.setDisable(false);
            ConfirmBt.setDisable(false);


        } catch (Exception e) {
            BetTxtField.setText("Enter integer number from 5 to 10");
        }
    }

    private void sectorEvenOddAction() {
        try {
            bet = this.getValidBet();
            EvenOddChoice = true;
            SectorBt.setDisable(true);
            RangeBt.setDisable(true);
            ColorBt.setDisable(true);
            BetTxtField.setDisable(true);
            EvenOddBt.setDisable(true);
            EvenBt.setDisable(false);
            OddBt.setDisable(false);

            EvenBt.setOnAction(event -> {
                Even = true;
                EvenBt.setDisable(true);
                OddBt.setDisable(true);
                SpinBt.setVisible(true);


            });
            OddBt.setOnAction(event -> {
                Odd = true;
                EvenBt.setDisable(true);
                OddBt.setDisable(true);
                SpinBt.setVisible(true);


            });

        } catch (Exception e) {
            BetTxtField.setText("Enter integer number from 5 to 10");
        }
    }

    private void sectorRangeAction() {
        try {
            bet = this.getValidBet();
            RangeChoice = true;
            SectorBt.setDisable(true);
            RangeBt.setDisable(true);
            ColorBt.setDisable(true);
            BetTxtField.setDisable(true);
            EvenOddBt.setDisable(true);
            FirstRangeBt.setDisable(false);
            SecondRangeBt.setDisable(false);

            FirstRangeBt.setOnAction(event -> {
                FirstRange = true;
                FirstRangeBt.setDisable(true);
                SecondRangeBt.setDisable(true);
                SpinBt.setVisible(true);

            });
            SecondRangeBt.setOnAction(event -> {
                SecondRange = true;
                FirstRangeBt.setDisable(true);
                SecondRangeBt.setDisable(true);
                SpinBt.setVisible(true);


            });
        } catch (Exception e) {
            BetTxtField.setText("Enter integer number from 5 to 10");
        }
    }

    private void sectorColorAction() {
        try {
            bet = this.getValidBet();
            ColorChoice = true;
            SectorBt.setDisable(true);
            RangeBt.setDisable(true);
            ColorBt.setDisable(true);
            BetTxtField.setDisable(true);
            EvenOddBt.setDisable(true);
            RedBt.setDisable(false);
            BlackBt.setDisable(false);
            RedBt.setOnAction(event -> {
                Red = true;
                RedBt.setDisable(true);
                BlackBt.setDisable(true);
                SpinBt.setVisible(true);


            });
            BlackBt.setOnAction(event -> {
                Black = true;
                RedBt.setDisable(true);
                BlackBt.setDisable(true);
                SpinBt.setVisible(true);


            });
        } catch (Exception e) {
            BetTxtField.setText("Enter integer number from 5 to 10");
        }
    }

    private void playRotate(int p) {
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(RouletteImg);
        rotate.setDuration(Duration.millis(3500));
        rotate.setByAngle(p * RoulleteController.sectorAngle);
        rotate.play();
    }

    private void win() {
        WinLooseLb.setDisable(false);
        looses = 1;
        switch (wins) {
            case (1) -> WinLooseLb.setText("You won!");
            case (2) -> WinLooseLb.setText("So lucky!");
            case (3) -> {
                WinLooseLb.setText("INCREDIBLE!!!!!!!");
                wins--;
            }
        }
        wins++;
    }

    private void loose() {
        WinLooseLb.setDisable(false);
        wins = 1;
        switch (looses) {
            case (1) -> WinLooseLb.setText("You loosed!");
            case (2) -> WinLooseLb.setText("So unlucky!:(");
            case (3) -> {
                WinLooseLb.setText("FUCK!!!!!");
                looses--;
            }
        }
        looses++;
    }


    @FXML
    void initialize() {
        this.accountStr = Integer.toString(this.Account);
        AccountLb.setText(accountStr);
        SectorBt.setOnAction(Event -> this.sectorBtAction());
        EvenOddBt.setOnAction(Event -> this.sectorEvenOddAction());
        RangeBt.setOnAction(Event -> this.sectorRangeAction());
        ColorBt.setOnAction(Event -> this.sectorColorAction());
        ConfirmBt.setOnAction(Event -> {
            try {
                Sector = Integer.parseInt(InputSectorTxtField.getText());
                if ((Sector >= 1) & (Sector <= 36)) {
                    ConfirmBt.setDisable(true);
                    InputSectorTxtField.setDisable(true);
                    SpinBt.setVisible(true);
                } else {
                    InputSectorTxtField.setText("Input integer number from 1 to 36");
                }
            } catch (Exception e) {
                InputSectorTxtField.setText("Input integer number from 1 to 36");
            }


        });
        SpinBt.setOnAction(Event -> {
            int p = (int) (Math.random() * 72) + 60;
            this.playRotate(p);


            Angle = (Angle + p) % amountSectors;
            if ((ARRAYINT[Angle]) != 0) {
                if (SectorChoice) {
                    if (Sector == ARRAYINT[37 - Angle]) {
                        Account = Account + bet * 36;
                        this.win();
                    } else {
                        Account = Account - bet;
                        this.loose();
                    }
                }


                if (EvenOddChoice) {
                    if (Even) {
                        if (ARRAYINT[37 - Angle] % 2 == 0) {
                            Account = Account + bet;
                            this.win();
                        } else {
                            Account = Account - bet;
                            this.loose();
                        }
                    }
                    if (Odd) {
                        if (ARRAYINT[37 - Angle] % 2 != 0) {
                            Account = Account + bet;
                            this.win();
                        } else {
                            Account = Account - bet;
                            this.loose();
                        }
                    }


                }
                if (RangeChoice) {
                    if (FirstRange) {
                        if ((ARRAYINT[37 - Angle] >= 1) & (ARRAYINT[37 - Angle] <= 18)) {
                            Account = Account + bet;
                            this.win();
                        } else {
                            Account = Account - bet;
                            this.loose();
                        }
                    }
                    if (SecondRange) {
                        if ((ARRAYINT[37 - Angle] >= 19) & (ARRAYINT[37 - Angle] <= 36)) {
                            Account = Account + bet;
                            this.win();
                        } else {
                            Account = Account - bet;
                            this.loose();
                        }
                    }
                }


                if (ColorChoice) {
                    if (Red) {
                        if ((37 - Angle) % 2 == 0) {
                            Account = Account - bet;
                            this.loose();
                        } else {
                            Account = Account + bet;
                            this.win();
                        }
                    }
                    if (Black) {
                        if ((37 - Angle) % 2 != 0) {
                            Account = Account - bet;
                            this.loose();
                        } else {
                            Account = Account + bet;
                            this.win();
                        }
                    }
                }
            } else {
                Account = Account - bet;
                this.loose();
            }
            ResultLbl.setVisible(true);
            if (ARRAYINT[Angle] != 0) {
                ResultLbl.setText(ARRAY[37 - Angle]);
            } else {
                ResultLbl.setText(ARRAY[Angle]);
            }
            SpinBt.setVisible(false);
            BetTxtField.setDisable(false);
            SectorBt.setDisable(false);
            EvenOddBt.setDisable(false);
            RangeBt.setDisable(false);
            ColorBt.setDisable(false);
            InputSectorTxtField.setText("Input your sector");
            BetTxtField.setText("");
            accountStr = Integer.toString(Account);
            AccountLb.setText(accountStr);
            SectorChoice = false;
            EvenOddChoice = false;
            RangeChoice = false;
            ColorChoice = false;
            Even = false;
            Odd = false;
            FirstRange = false;
            SecondRange = false;
            Red = false;
            Black = false;
        });

    }


}
