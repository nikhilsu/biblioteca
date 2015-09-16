package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTest {

    @Test
    public void shouldDisplayTheMainMenuWhenToStringIsCalled() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);

        String testString = "----------Menu----------\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "Enter your choice : ";

        assertEquals(testString, mainMenu.toString());
    }

    @Test
    public void shouldDisplayTheMainMenuWhenPerformOperationIsCalled() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);

        String testString = "----------Menu----------\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "Enter your choice : ";

        mainMenu.performOperation();

        verify(consoleView).printOnConsole(testString);
    }

    @Test
    public void shouldBeEqualToItself() {
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenu = new MainMenu(listOfMenuItems, consoleView);

        assertEquals(mainMenu, mainMenu);
    }

    @Test
    public void shouldNotBeEqualToAnotherMenuWithDifferentMenuItems() {
        ArrayList<String> listOfMenuItemsOne = new ArrayList<>();
        listOfMenuItemsOne.add("1. List Books");
        listOfMenuItemsOne.add("2. Checkout Book");
        listOfMenuItemsOne.add("3. Return Book");
        listOfMenuItemsOne.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenuOne = new MainMenu(listOfMenuItemsOne, consoleView);
        ArrayList<String> listOfMenuItemsTwo = new ArrayList<>();
        listOfMenuItemsTwo.add("1. List Books");
        listOfMenuItemsTwo.add("2. List Movies");
        listOfMenuItemsTwo.add("3. Checkout Movie");
        listOfMenuItemsTwo.add("4. CheckOut Book");
        listOfMenuItemsTwo.add("5. Return Book");
        listOfMenuItemsTwo.add("6. User Details");
        listOfMenuItemsTwo.add("7. Logout");
        MainMenu mainMenuTwo = new MainMenu(listOfMenuItemsTwo, consoleView);

        assertNotEquals(mainMenuOne, mainMenuTwo);
    }

    @Test
    public void shouldNotBeEqualToSomethingThatIsNotAMainMenu() {
        ArrayList<String> listOfMenuItemsOne = new ArrayList<>();
        listOfMenuItemsOne.add("1. List Books");
        listOfMenuItemsOne.add("2. Checkout Book");
        listOfMenuItemsOne.add("3. Return Book");
        listOfMenuItemsOne.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MainMenu mainMenuOne = new MainMenu(listOfMenuItemsOne, consoleView);

        assertNotEquals(mainMenuOne, "Main Menu");
    }
}