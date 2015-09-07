package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainMenuItemTest {

    @Test
    public void shouldDisplayTheMainMenu() {
        ArrayList<String> listOfItems = new ArrayList<String>();
        listOfItems.add("1. List books");
        listOfItems.add("2. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfItems);

        String testString = "1. List books\n" +
                "2. Quit\n";

        assertEquals(testString, mainMenuItem.toString());
    }
}