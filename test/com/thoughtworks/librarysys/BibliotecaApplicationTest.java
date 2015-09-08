package com.thoughtworks.librarysys;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication.run(consoleInput);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n";

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
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);

        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication.run(consoleInput);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
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
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("7\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication.run(consoleInput);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
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
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Kite Runner\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput c = mock(ConsoleInput.class);
        when(c.inputFromUser()).thenReturn("2");
        bibliotecaApplication.run(c);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "Thank you! Enjoy the book\n";

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldNotCheckoutABookWhichIsNotAvailableInTheLibraryAndShouldIntimateTheUserAboutTheSame() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Head First Java\r\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput consoleInput = mock(ConsoleInput.class);
        when(consoleInput.inputFromUser()).thenReturn("2");
        bibliotecaApplication.run(consoleInput);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "That book is not available\n";

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldReturnABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheReturnMenuMenuItem() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Gone Girl", "Gillian Flynn", 2014);
        listOfCheckedOutBooks.add(borrowedBook);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Gone Girl\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput c = mock(ConsoleInput.class);
        when(c.inputFromUser()).thenReturn("3");
        bibliotecaApplication.run(c);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "Thank you for returning the book\n";

        assertEquals(testString, outputStream.toString());
    }

    @Test
    public void shouldNotReturnABookThatDoesNotBelongToTheLibraryWhenTheUserSelectsTheReturnMenuMenuItem() {
        WelcomeUser welcomeUser = new WelcomeUser("Welcome to The Biblioteca");
        Book bookOne = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookTwo = new Book("Inferno", "Dan Brown", 2012);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Gone Girl", "Gillian Flynn", 2014);
        listOfCheckedOutBooks.add(borrowedBook);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Head First Java\n".getBytes());
        System.setIn(inputStream);
        ConsoleInput c = mock(ConsoleInput.class);
        when(c.inputFromUser()).thenReturn("3");
        bibliotecaApplication.run(c);
        System.setIn(System.in);

        String testString = "Welcome to The Biblioteca\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n" +
                "That is not a valid book to return\n";

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
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ArrayList<String> listOfMenuItems = new ArrayList<>();
        listOfMenuItems.add("1. List Books");
        listOfMenuItems.add("2. Checkout Book");
        listOfMenuItems.add("3. Return Book");
        listOfMenuItems.add("4. Quit");
        MainMenuItem mainMenuItem = new MainMenuItem(listOfMenuItems);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(welcomeUser, mainMenuItem, library);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(inputStream);

        exit.expectSystemExit();
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        bibliotecaApplication.run(consoleInput);
        System.setIn(System.in);
    }
}