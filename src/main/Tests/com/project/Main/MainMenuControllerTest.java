package com.project.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainMenuControllerTest {

    private MainMenuController mainMenuControllerUnderTest;

    @BeforeEach
    void setUp() {
        mainMenuControllerUnderTest = new MainMenuController();
    }

    @Test
    void testInitialize() {
        // Setup

        // Run the test
        mainMenuControllerUnderTest.initialize();

        // Verify the results
    }

    @Test
    void testBackToSingIn() throws Exception {
        // Setup

        // Run the test
        mainMenuControllerUnderTest.BackToSingIn();

        // Verify the results
    }

    @Test
    void testBackToSingIn_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> mainMenuControllerUnderTest.BackToSingIn());
    }

    @Test
    void testOpenRoulette() throws Exception {
        // Setup

        // Run the test
        mainMenuControllerUnderTest.OpenRoulette();

        // Verify the results
    }

    @Test
    void testOpenRoulette_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> mainMenuControllerUnderTest.OpenRoulette());
    }

    @Test
    void testOpenBaccara() throws Exception {
        // Setup

        // Run the test
        mainMenuControllerUnderTest.OpenBaccara();

        // Verify the results
    }

    @Test
    void testOpenBaccara_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> mainMenuControllerUnderTest.OpenBaccara());
    }

    @Test
    void testStatsUpdate() throws Exception {
        // Setup

        // Run the test
        MainMenuController.StatsUpdate();

        // Verify the results
    }

    @Test
    void testStatsUpdate_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, MainMenuController::StatsUpdate);
    }

    @Test
    void testIntToString() {
        assertEquals("result", MainMenuController.IntToString(0));
    }

    @Test
    void testStringToInt() {
        assertEquals(0, MainMenuController.StringToInt("str"));
    }
}
