package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldReturnTheNamesOfAllTheBooksInTheList() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);

        String testString = String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012);

        assertEquals(testString, library.toString());
    }

    @Test
    public void shouldNotIncludeABookInItsListOnceItIsCheckedOut() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);

        library.checkOut(bookTwo);

        verify(consoleView).notifySuccessfulBookCheckout();
    }

    @Test
    public void cannotCheckoutABookThatIsNotPresentInTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);

        Book notALibraryBook = new Book("Head First java", "Bert Bates", 2003);
        library.checkOut(notALibraryBook);

        verify(consoleView).notifyUnsuccessfulCheckout();
    }

    @Test
    public void shouldReturnACheckedOutBookToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);

        Book libraryBook = new Book("Inferno", "Author", 0);
        library.toReturn(libraryBook);

        verify(consoleView).notifySuccessfulReturn();
    }

    @Test
    public void shouldNotReturnABookThatDoesNotBelongToTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);

        Book libraryBook = new Book("Head First Java", "Author", 0);
        library.toReturn(libraryBook);

        verify(consoleView).notifyUnsuccessfulReturn();
    }

    @Test
    public void shouldContainTheBookWhichWasReturnedInTheListOfAvailableBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book borrowedBook = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(borrowedBook);
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);
        Book libraryBook = new Book("Inferno", "Author", 0);

        library.toReturn(libraryBook);
        String testString = String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012);

        assertEquals(testString, library.toString());
    }
}