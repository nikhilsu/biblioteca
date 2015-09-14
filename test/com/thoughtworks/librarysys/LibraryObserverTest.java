package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryObserverTest {

    @Test
    public void shouldPrintTheSuccessfulCheckoutMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifySuccessfulBookCheckout();

        verify(consoleView).printOnConsole("Thank you! Enjoy the book\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulCheckoutMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifyUnsuccessfulCheckout();

        verify(consoleView).printOnConsole("That book is not available\n");
    }

    @Test
    public void shouldPrintTheSuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifySuccessfulReturn();

        verify(consoleView).printOnConsole("Thank you for returning the book\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifyUnsuccessfulReturn();

        verify(consoleView).printOnConsole("That is not a valid book to return\n");
    }
}