package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksObserverTest {

    @Test
    public void shouldPrintTheSuccessfulCheckoutMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        libraryBooksObserver.notifySuccessfulBookCheckout();

        verify(consoleView).printOnConsole("Thank you! Enjoy the book\n\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulCheckoutMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        libraryBooksObserver.notifyUnsuccessfulCheckout();

        verify(consoleView).printOnConsole("That book is not available\n\n");
    }

    @Test
    public void shouldPrintTheSuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        libraryBooksObserver.notifySuccessfulReturn();

        verify(consoleView).printOnConsole("Thank you for returning the book\n\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryBooksObserver libraryBooksObserver = new LibraryBooksObserver(consoleView);
        libraryBooksObserver.notifyUnsuccessfulReturn();

        verify(consoleView).printOnConsole("That is not a valid book to return\n\n");
    }
}