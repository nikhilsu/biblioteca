package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

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
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Inferno");
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(libraryBooks, consoleView);

        returnBookMenuItem.performOperation();

        verify(libraryBooksObserver).notifySuccessfulReturn();
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
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        LibraryBooksObserver libraryBooksObserver = mock(LibraryBooksObserver.class);
        LibraryBooks libraryBooks = new LibraryBooks(listOfBooks, listOfCheckedOutBooks, libraryBooksObserver);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(libraryBooks, consoleView);

        returnBookMenuItem.performOperation();

        verify(libraryBooksObserver).notifyUnsuccessfulReturn();
    }
}