package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainMenuItemTest {

    @Test
    public void shouldDisplayTheMainMenu() {
        ArrayList<String> listOfMenuItems = new ArrayList<String>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n";

        assertEquals(testString, mainMenuItem.toString());
    }
}