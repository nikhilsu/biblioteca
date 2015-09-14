package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeUserTest {

    @Test
    public void shouldPrintAWelcomeMessageToGreetTheUser() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome");

        assertEquals("Welcome\n", welcomeUser.toString());
    }
}