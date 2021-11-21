package com.project.bakkara.Card;

public class Card {
    private int suit, rank;

    private static String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    private static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int GetRank() {
        return rank;
    }

    public int GetSuit() {
        return suit;
    }

    public String GetCard() {
        return ranks[rank] + " of " + suits[suit];
    }
}