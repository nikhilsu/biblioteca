package com.thoughtworks.librarysys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BibliotecaApplicationTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUp() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayTheWelcomeMessageAndAListOfMenuOptionsToTheUserOnStartUp() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        MainMenu mainMenu = new MainMenu(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenu);
        bibliotecaApplication.run();

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n";

        assertEquals(testString, outputStream.toString());
    }
}