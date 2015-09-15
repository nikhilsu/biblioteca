package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainMenuTest {

    @Test
    public void shouldDisplayTheMainMenuWhenToStringIsCalled() {
        ArrayList<String> listOfMenuItems = new ArrayList<String>();
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
        ArrayList<String> listOfMenuItems = new ArrayList<String>();
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
}