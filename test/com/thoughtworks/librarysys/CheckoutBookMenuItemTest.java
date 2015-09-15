package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookMenuItemTest {

    @Test
    public void shouldCheckoutABookFromTheListOfBooksInTheLibraryByInputtingTheNameOfTheBook() {
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        Books books = mock(Books.class);
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(books, consoleView);
        Book bookToCheckout = new Book("Gone Girl", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(books).checkOut(bookToCheckout);
    }

    @Test
    public void shouldNotCheckOutABookFromTheLibraryIfItIsNotABookFromTheLibrary() {
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        Books books = mock(Books.class);
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(books, consoleView);
        Book bookToCheckout = new Book("Head First Java", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(books).checkOut(bookToCheckout);
    }
}