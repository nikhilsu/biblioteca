package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutBookMainMenuTest {

    @Test
    public void shouldCheckoutABookFromTheListOfBooksInTheLibraryByInputtingTheNameOfTheBook() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(library, consoleView);
        Book bookToCheckout = new Book("Gone Girl", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(library).checkOut(bookToCheckout);
    }

    @Test
    public void shouldNotCheckOutABookFromTheLibraryIfItIsNotABookFromTheLibrary() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        CheckoutBookMenuItem checkoutBookMenuItem = new CheckoutBookMenuItem(library, consoleView);
        Book bookToCheckout = new Book("Head First Java", "Not needed", 0);
        checkoutBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to checkout: ");
        verify(library).checkOut(bookToCheckout);
    }
}