package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MainMenuFactoryTest {

    @Test
    public void shouldCreateAMenuItemHavingAvalidListForTheRegisteredUserWhenTheUserPassedToItIsRegistered() {
        ArrayList<String> listOfMenuItems = new ArrayList<String>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. List Movies");
        listOfMenuItems.add("3. Checkout Movie");
        listOfMenuItems.add("4. CheckOut Book");
        listOfMenuItems.add("5. Return Book");
        listOfMenuItems.add("6. User Details");
        listOfMenuItems.add("7. Logout");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);
        MainMenuFactory mainMenuFactory = new MainMenuFactory(consoleView);

        User user = new User("111-1111", "password1", "Registered");

        assertEquals(mainMenu, mainMenuFactory.manufacture(user));
    }
}