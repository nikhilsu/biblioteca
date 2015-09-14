package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class InputParserTest {

    @Test
    public void shouldReturnAnObjectOfTypeListBooksWhenTheUsersChoiceOfMenuItemIsOne() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        InputParser inputParser = new InputParser(libraryBooks, consoleView);

        String userChoice = "1";

        assertEquals(new ListBooksMenuItem(libraryBooks, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutBookMenuItemWhenTheUsersChoiceOfMenuItemIsTwo() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        InputParser inputParser = new InputParser(libraryBooks, consoleView);

        String userChoice = "2";

        assertEquals(new CheckoutBookMenuItem(libraryBooks, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeQuitMenuItemWhenTheUsersChoiceOfMenuItemIsFour() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        InputParser inputParser = new InputParser(libraryBooks, consoleView);

        String userChoice = "4";

        assertEquals(new QuitMenuItem().getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeInvalidMenuChoiceWhenTheUsersChoiceOfMenuItemIsInvalid() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        InputParser inputParser = new InputParser(libraryBooks, consoleView);

        String userChoice = "0";

        assertEquals(new InvalidMenuItem("Select a valid option!", consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeReturnBookMenuItemWhenTheUsersChoiceOfMenuItemIsThree() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        InputParser inputParser = new InputParser(libraryBooks, consoleView);

        String userChoice = "3";

        assertEquals(new ReturnBookMenuItem(libraryBooks, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }
}