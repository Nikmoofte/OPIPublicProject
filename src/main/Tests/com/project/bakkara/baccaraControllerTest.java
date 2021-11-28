package com.project.bakkara;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class baccaraControllerTest {
    @Test
    public void testPlay_Success(){
        baccaraController underTest = new baccaraController();
        underTest.Play();
        assertEquals("Win", underTest.StateMessage.getText());
    }

    @Test
    public void testPass_Success(){
        baccaraController underTest = new baccaraController();
        underTest.i_opponentscore = 5;
        underTest.i_playerscore = 5;
        underTest.Pass();
        assertEquals(6, underTest.i_opponentscore);
    }

    @Test
    public void testAnotherOne_Success(){
        baccaraController underTest = new baccaraController();
        underTest.i_playerscore = 5;
        underTest.i_opponentscore = 5;
        underTest.AnotherOne();
        assertEquals(6, underTest.i_playerscore);
    }

    @Test
    public void testBet_Success(){
        baccaraController underTest = new baccaraController();
        underTest.BetButton.setText("Bet");
        underTest.BetButton.setOnAction(event -> {
            underTest.BetButton.setText("Bet");
            underTest.BetButton.setOnAction(null);
        });
        underTest.BetButton.setOnAction(event -> {
            underTest.BetButton.setText("Bet");
            underTest.BetButton.setOnAction(null);
        });
        assertEquals("Bet", underTest.BetButton.getText());
    }
}