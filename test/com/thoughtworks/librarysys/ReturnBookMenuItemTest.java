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
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);

        returnBookMenuItem.performOperation();

        verify(consoleView).notifySuccessfulReturn();
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
        Library library = new Library(listOfBooks, listOfCheckedOutBooks, consoleView);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);

        returnBookMenuItem.performOperation();

        verify(consoleView).notifyUnsuccessfulReturn();
    }
}