package com.project.bakkara;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.project.bakkara.Card.Card;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.security.SecureRandom;


public class baccaraController
{
    private static final SecureRandom rand = new SecureRandom();
    public ImageView PlayerFirstCard;
    public ImageView PlayerSecondCard;
    public ImageView PlayerThirdCard;
    public ImageView OpponentFirstCard;
    public ImageView OpponentSecondCard;
    public ImageView OpponentThirdCard;
    Image BackCardImage;
    public Text PlayerScore;
    public Text OpponentScore;
    public Text StateMessage;

    public Button PlayButton;
    public Button PassButton;
    public Button AOneButton;


    private int
            i_playerscore,
            i_opponentscore;

    void LastDefine()
    {
        if (i_opponentscore > i_playerscore)
            DeclareOppWin();
        else if(i_opponentscore == i_playerscore)
            DeclareDraw();
        else
            DeclarePlWin();
    }
    void DeclareDraw()
    {
        ResetButtons();
        StateMessage.setText("Draw");
    }
    void DeclarePlWin()
    {
        ResetButtons();
        StateMessage.setText("Win");
    }
    void DeclareOppWin()
    {
        ResetButtons();
        StateMessage.setText("Lose");
    }
    void ResetButtons()
    {
        AOneButton.setVisible(false);
        PassButton.setVisible(false);
        PlayButton.setVisible(true);
    }
    void Clear()
    {
        BackCardImage = new Image("Back.png");
        PlayerFirstCard.setImage(BackCardImage);
        PlayerSecondCard.setImage(BackCardImage);
        PlayerThirdCard.setImage(BackCardImage);
        OpponentFirstCard.setImage(BackCardImage);
        OpponentSecondCard.setImage(BackCardImage);
        OpponentThirdCard.setImage(BackCardImage);
        StateMessage.setText("");
    }
    Card GenerateCard()
    {
        return new Card(rand.nextInt(4), rand.nextInt(13));
    }
    void ScoreUpdate()
    {
        PlayerScore.setText(/*"Player Score :" + */"" + i_playerscore);
        OpponentScore.setText(/*"Opponent Score :" + */"" + i_opponentscore);

    }
    @FXML
    protected void Play()
    {
        Clear();
        PlayButton.setVisible(false);
        Card
                PlayerCard1     = GenerateCard(),
                PlayerCard2     = GenerateCard(),
                OpponentCard1   = GenerateCard(),
                OpponentCard2   = GenerateCard();
        //StateMessage.setText(PlayerCard1.GetCard() + ".png");

        PlayerFirstCard.setImage(new Image(PlayerCard1.GetCard() + ".png"));
        PlayerSecondCard.setImage(new Image( PlayerCard2.GetCard() + ".png"));
        OpponentFirstCard.setImage(new Image(OpponentCard1.GetCard() + ".png"));
        OpponentSecondCard.setImage(new Image(OpponentCard2.GetCard() + ".png"));



        i_playerscore = (((PlayerCard1.GetRank() > 8)? 0 : (PlayerCard1.GetRank() + 1)) + ((PlayerCard2.GetRank() > 8)? 0 : (PlayerCard2.GetRank() + 1))) % 10;
        i_opponentscore = (((OpponentCard1.GetRank() > 8)? 0 : (OpponentCard1.GetRank() + 1)) + ((OpponentCard2.GetRank() > 8)? 0 : (OpponentCard2.GetRank() + 1))) % 10;

        ScoreUpdate();

        if (i_opponentscore >= 8)
            LastDefine();
        else if(i_playerscore >= 8)
            DeclarePlWin();
        else
        {
            AOneButton.setVisible(true);
            PassButton.setVisible(true);
        }
    }


    public void Pass()
    {
        if (i_playerscore >= i_opponentscore && i_opponentscore < 7)
        {
            Card OpponentCard3 = GenerateCard();
            OpponentThirdCard.setImage(new Image(OpponentCard3.GetCard() + ".png"));
            i_opponentscore += ((OpponentCard3.GetRank() > 8) ? 0 : (OpponentCard3.GetRank() + 1));
            i_opponentscore %= 10;
            ScoreUpdate();
        }
        LastDefine();
        AOneButton.setVisible(false);
        PassButton.setVisible(false);
    }

    public void AnotherOne()
    {
        Card PlayerCard3 = GenerateCard();
        PlayerThirdCard.setImage(new Image(PlayerCard3.GetCard() + ".png"));
        i_playerscore += ((PlayerCard3.GetRank() > 8) ? 0 : (PlayerCard3.GetRank() + 1));
        i_playerscore %= 10;
        ScoreUpdate();
        Pass();
    }
}