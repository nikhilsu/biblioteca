package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookMenuItemTest {

    @Test
    public void shouldCheckoutABookFromTheListOfBooksInTheLibraryByInputtingTheNameOfTheBook() {
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        LibraryBooks libraryBooks = mock(LibraryBooks.class);
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(libraryBooks, consoleView);
        Book bookToCheckout = new Book("Gone Girl", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(libraryBooks).checkOut(bookToCheckout);
    }

    @Test
    public void shouldNotCheckOutABookFromTheLibraryIfItIsNotABookFromTheLibrary() {
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        LibraryBooks libraryBooks = mock(LibraryBooks.class);
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(libraryBooks, consoleView);
        Book bookToCheckout = new Book("Head First Java", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(libraryBooks).checkOut(bookToCheckout);
    }
}