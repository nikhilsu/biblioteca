package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckoutMovieMenuItemTest {

    @Test
    public void shouldCheckoutAMovieFromTheListOfMoviesInTheLibraryByInputtingTheNameOfTheMovie() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem(library, consoleView);
        Movie movieToCheckout = new Movie("Gone Girl", 0, "Not needed", 0);
        checkoutMovieMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Movie to checkout: ");
        verify(library).checkOut(movieToCheckout);
    }

    @Test
    public void shouldNotCheckOutAMovieFromTheLibraryIfItIsNotAMovieFromTheLibrary() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Some Movie");
        CheckoutMovieMenuItem checkoutMovieMenuItem = new CheckoutMovieMenuItem(library, consoleView);
        Movie movieToCheckout = new Movie("Some Movie", 0, "Not needed", 0);
        checkoutMovieMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Movie to checkout: ");
        verify(library).checkOut(movieToCheckout);
    }
}