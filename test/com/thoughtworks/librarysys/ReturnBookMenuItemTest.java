package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnBookMenuItemTest {

    @Test
    public void shouldReturnABookFromTheUserToTheLibraryByTheInputNameOfTheBook() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book book = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(book);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Inferno");
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);

        assertEquals("Thank you for returning the book\n", returnBookMenuItem.performOperation());
    }

    @Test
    public void shouldNotReturnABookToTheLibraryThatDoesNotBelongToIt() {

        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Book book = new Book("Inferno", "Dan Brown", 2012);
        listOfCheckedOutBooks.add(book);
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);

        assertEquals("That is not a valid book to return\n", returnBookMenuItem.performOperation());
    }
}