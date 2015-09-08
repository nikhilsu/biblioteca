package com.thoughtworks.librarysys;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaApplicationTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        Library library = new Library(listOfBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(inputStream);
        bibliotecaApplication.run();
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Quit\n";

        assertTrue(outputStream.toString().contains(testString));
    }

    @Test
    public void shouldDisplayTheWelcomeMessageAndTheMenuAndAskForTheUserInputWhichWhenIsOneTheAListOfBooksArePrinted() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        Library library = new Library(listOfBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        bibliotecaApplication.run();
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Quit\n" +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012);

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldDisplayTheWelcomeMessageAndTheMenuAndAskForTheUserInputWhichWhenIsInvalidTheStringSelectAValidChoiceIsPrinted() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        Library library = new Library(listOfBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("7\n".getBytes());
        System.setIn(inputStream);
        bibliotecaApplication.run();
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Quit\n" +
                "Select a valid option!\n";

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldCheckoutABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheCheckoutMenuItem() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        Library library = new Library(listOfBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\r\n Kite Runner\r\n".getBytes());
        System.setIn(inputStream);
        bibliotecaApplication.run();
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Quit\n" +
                "Done\n";

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldExitTheApplicationWhenTheUserSelectsTheExitMenuItem() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        Library library = new Library(listOfBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(inputStream);

        exit.expectSystemExit();
        bibliotecaApplication.run();
        System.setIn(System.in);
    }
}