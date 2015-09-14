package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MenuItemTest {

    @Test
    public void shouldDisplayTheMainMenu() {
        ArrayList<String> listOfMenuItems = new ArrayList<String>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        ConsoleView consoleView = mock(ConsoleView.class);
        MenuItem menuItem = new MenuItem(listOfMenuItems, consoleView);

        String testString = "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n";

        assertEquals(testString, menuItem.toString());
    }
}