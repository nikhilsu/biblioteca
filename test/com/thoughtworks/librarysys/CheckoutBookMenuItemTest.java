package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutBookMenuItemTest {

    @Test
    public void shouldCheckoutABookFromTheListOfBooksInTheLibraryByInputtingTheNameOfTheBook() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(library, consoleView);

        assertEquals("Thank you! Enjoy the book\n", checkoutBookMenuItem.performOperation());
    }

    @Test
    public void shouldNotCheckOutABookFromTheLibraryIfItIsNotABookFromTheLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        Book bookOne = new Book("Gone Girl", "Gillian Flynn", 2014);
        Book bookTwo = new Book("Kite Runner", "Khaled Hossieni", 2003);
        Book bookThree = new Book("Inferno", "Dan Brown", 2012);
        listOfBooks.add(bookOne);
        listOfBooks.add(bookTwo);
        listOfBooks.add(bookThree);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Library library = new Library(listOfBooks, listOfCheckedOutBooks);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(library, consoleView);
        
        assertEquals("That book is not available\n", checkoutBookMenuItem.performOperation());
    }
}