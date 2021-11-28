package com.project.bakkara.Card;

/**
 *  Represent Card
 */
public class Card {
    private final int suit;
    private final int rank;

    /**
     * Stores all possible suits of cards
     */
    private static final String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    /**
     * Stores all possible ranks of cards
     */
    private static final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    /**
     * Constructor Of cards
     * @param suit
     * @param rank
     */
    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return Rank
     */
    public int GetRank() {
        return rank;
    }

    /**
     * @return Suit
     */
    public int GetSuit() {
        return suit;
    }

    /**
     * @return String Rank + " " + Suit
     */
    public String GetCard() {
        return ranks[rank] + " of " + suits[suit];
    }
}