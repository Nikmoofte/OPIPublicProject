package com.project.bakkara.Card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    private Card cardUnderTest;

    @BeforeEach
    void setUp() {
        cardUnderTest = new Card(0, 0);
    }

    @Test
    void testGetRank() {
        assertEquals(0, cardUnderTest.GetRank());
    }

    @Test
    void testGetSuit() {
        assertEquals(0, cardUnderTest.GetSuit());
    }

    @Test
    void testGetCard() {
        assertEquals( "Ace of hearts", cardUnderTest.GetCard());
    }
}
