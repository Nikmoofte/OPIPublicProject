package com.project.bakkara;

import com.project.Main.MainMenuController;
import com.project.Main.StartUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import com.project.bakkara.Card.Card;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Objects;


/**
 * Controls baccara window
 */
public class baccaraController
{
    private static final SecureRandom rand = new SecureRandom();
    public ImageView PlayerFirstCard;
    public ImageView PlayerSecondCard;
    public ImageView PlayerThirdCard;
    public ImageView OpponentFirstCard;
    public ImageView OpponentSecondCard;
    public ImageView OpponentThirdCard;
    public Button BetButton;
    public Button BackButton;
    public static Text BetVal;
    public Text Money;
    Image BackCardImage;
    public Text PlayerScore;
    public Text OpponentScore;
    public Text StateMessage;

    public Button PlayButton;
    public Button PassButton;
    public Button AOneButton;
    static int val = 0;

    private int
            i_playerscore,
            i_opponentscore;

    /**
     * setting the initial values
     */
    @FXML
    void initialize()
    {
        val = 0;
        Money.setText("" + MainMenuController.Stats[0]);
    }

    /**
     * Last check of player's and opponent's scores
     */
    void LastDefine()
    {
        if (i_opponentscore > i_playerscore)
            DeclareOppWin();
        else if(i_opponentscore == i_playerscore)
            DeclareDraw();
        else
            DeclarePlWin();
    }
    enum state
    {
        Win, Lose, Draw
    }
    public static state BetState;

    /**
     * Changing statistics
     * @param State Current state of game(Win/Lose/Draw)
     */
    void Ending(state State)
    {
        int Income;
        if (BetState.equals(state.Draw))
            Income = 9 * val;
        else
            Income = val;
        if(!State.equals(BetState))
            Income = -val;

        MainMenuController.Stats[0] += Income;
        Money.setText("" + MainMenuController.Stats[0]);
        MainMenuController.Stats[5 + State.ordinal()]++;
        MainMenuController.Stats[8] += Income;
        try {
            MainMenuController.StatsUpdate();
        } catch (IOException e) {
            System.out.println("Status update Error!");
        }
    }

    /**
     * Declares Draw and calling Ending func with Draw state
     */
    void DeclareDraw()
    {
        ResetButtons();
        StateMessage.setText("Draw");
        Ending(state.Draw);
    }

    /**
     * Declares player win and calling Ending func with Win state
     */
    void DeclarePlWin()
    {
        ResetButtons();
        StateMessage.setText("Win");
        Ending(state.Win);
    }

    /**
     * Declares Opponent's win and calling Ending func with Lose state
     */
    void DeclareOppWin()
    {
        ResetButtons();
        StateMessage.setText("Lose");
        Ending(state.Lose);
    }

    /**
     * Reset buttons to initial states
     */
    void ResetButtons()
    {
        AOneButton.setVisible(false);
        PassButton.setVisible(false);
        PlayButton.setVisible(true);
        BetButton.setVisible(true);
    }

    /**
     * Resets cards and text to initial states
     */
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

    /**
     * Generates new card
     * @return new card
     */
    Card GenerateCard()
    {
        return new Card(rand.nextInt(4), rand.nextInt(13));
    }

    /**
     * Updating score in window
     */
    void ScoreUpdate()
    {
        PlayerScore.setText(/*"Player Score :" + */"" + i_playerscore);
        OpponentScore.setText(/*"Opponent Score :" + */"" + i_opponentscore);

    }

    /**
     * Play button func:
     * Generating 4 cards
     * Calculating scores
     * And deciding what to do next
     */
    @FXML
    protected void Play()
    {
        Clear();
        PlayButton.setVisible(false);
        BetButton.setVisible(false);
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

    /**
     * Opens Main menu
     * @throws IOException
     */
    public void ToMineMenu() throws IOException
    {
        BackButton.getScene().getWindow().hide();
        StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("main-menu.fxml"))), 700, 500);
    }

    /**
     * Activating opponents "AI" and calling Last define
     */
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

    /**
     * Adding Another card to player and updating scores
     * Calling Pass func
     */
    public void AnotherOne() {
        Card PlayerCard3 = GenerateCard();
        PlayerThirdCard.setImage(new Image(PlayerCard3.GetCard() + ".png"));
        i_playerscore += ((PlayerCard3.GetRank() > 8) ? 0 : (PlayerCard3.GetRank() + 1));
        i_playerscore %= 10;
        ScoreUpdate();
        Pass();
    }



    public void OpenBetWindow() throws IOException
    {


        //StartUp.CreateNewWindow(FXMLLoader.load(Objects.requireNonNull(com.project.bakkara.baccaraController.class.getResource("betWindow.fxml"))), 400, 200);
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(bacBetController.class.getResource("betWindow.fxml"))), 400, 200);
        Stage BetStage = new Stage();
        BetStage.setScene(scene);
        BetStage.setResizable(false);
        BetStage.setTitle(StartUp.ProgramName);
        BetStage.initOwner(PlayButton.getScene().getWindow());
        BetStage.initModality(Modality.WINDOW_MODAL);
        BetStage.show();
    }
}