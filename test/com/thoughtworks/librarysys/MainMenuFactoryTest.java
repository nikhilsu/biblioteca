package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainMenuFactoryTest {

    @Test
    public void shouldCreateAMenuItemHavingAValidListForTheRegisteredUserWhenTheUserPassedToItIsRegistered() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
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

        User user = mock(User.class);
        when(user.getRole()).thenReturn("Registered");

        assertEquals(mainMenu, mainMenuFactory.manufacture(user));
    }

    @Test
    public void shouldCreateAMenuItemHavingAvalidListForTheGuestUserWhenTheUserPassedToItIsGuest() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. List Movies");
        listOfMenuItems.add("3. Checkout Movie");
        listOfMenuItems.add("4. Login");
        listOfMenuItems.add("5. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);
        MainMenuFactory mainMenuFactory = new MainMenuFactory(consoleView);

        User user = mock(User.class);
        when(user.getRole()).thenReturn("Guest");

        assertEquals(mainMenu, mainMenuFactory.manufacture(user));
    }

    @Test
    public void shouldCreateAMenuItemHavingAvalidListForTheLibrarianWhenTheUserPassedToItIsLibrarian() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. List Movies");
        listOfMenuItems.add("3. Checkout Movie");
        listOfMenuItems.add("4. CheckOut Book");
        listOfMenuItems.add("5. Return Book");
        listOfMenuItems.add("6. User Details");
        listOfMenuItems.add("7. CheckedOut Book Details");
        listOfMenuItems.add("8. Logout");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);
        MainMenuFactory mainMenuFactory = new MainMenuFactory(consoleView);

        User user = mock(User.class);
        when(user.getRole()).thenReturn("Librarian");

        assertEquals(mainMenu, mainMenuFactory.manufacture(user));
    }
}