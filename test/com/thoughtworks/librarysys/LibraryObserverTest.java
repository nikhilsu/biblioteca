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

        verify(consoleView).printOnConsole("Thank you! Enjoy the book\n\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulCheckoutMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifyUnsuccessfulBookCheckout();

        verify(consoleView).printOnConsole("That book is not available\n\n");
    }

    @Test
    public void shouldPrintTheSuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifySuccessfulBookReturn();

        verify(consoleView).printOnConsole("Thank you for returning the book\n\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulReturnMessageOntoTheConsole() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifyUnsuccessfulBookReturn();

        verify(consoleView).printOnConsole("That is not a valid book to return\n\n");
    }

    @Test
    public void shouldPrintTheSuccessfulCheckoutMessageOntoTheConsoleWhenMovieIsCheckedOut() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifySuccessfulMovieCheckout();

        verify(consoleView).printOnConsole("Thank you! Enjoy the Movie\n\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulCheckoutMessageOntoTheConsoleWhenMovieIsCheckedOut() {
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryObserver libraryObserver = new LibraryObserver(consoleView);
        libraryObserver.notifyUnsuccessfulMovieCheckout();

        verify(consoleView).printOnConsole("That book is not available\n\n");
    }
}