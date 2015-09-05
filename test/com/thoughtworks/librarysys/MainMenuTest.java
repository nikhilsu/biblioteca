package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void shouldDisplayTheMainMenu() {
        ArrayList<String> listOfItems = new ArrayList<String>();
        listOfItems.add("1. List books");
        MainMenu mainMenu = new MainMenu(listOfItems);

        String testString = "1. List books\n";

        assertEquals(testString, mainMenu.toString());
    }
}