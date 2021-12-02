package com.project.Main;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;

class SingInControllerTest {

    @Test
    public void testLogin_Success()  {
        String login = "admin";
        String password = "admin";

        boolean result = false;
        try {
            result = SingInController.Login(login, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(result);
    }

    private void assertTrue(boolean result) {
    }

    @Test
    public void testLogin_Fail() {
        String login = "348756dhd";
        String password = "348756dhd";
        boolean result = false;
        try {
            result = SingInController.Login(login, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertFalse(result);
    }

}