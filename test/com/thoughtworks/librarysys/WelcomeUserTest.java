package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeUserTest {

    @Test
    public void shouldPrintAWelcomeMessageToGreetTheUser() {
        WelcomeUser welcomeUser = new WelcomeUser();

        assertEquals("Welcome", welcomeUser.toString());
    }
}