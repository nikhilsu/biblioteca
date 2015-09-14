package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldCheckoutABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheCheckoutMenuItem() {
        WelcomeUser welcomeUser = mock(WelcomeUser.class);
        when(welcomeUser.toString()).thenReturn("Welcome to The Biblioteca\n");
        Library library = mock(Library.class);
        Book book = new Book("Kite Runner", "Author", 0);
        when(library.checkOut(book)).thenReturn(true);
        MainMenuItem mainMenuItem = mock(MainMenuItem.class);
        when(mainMenuItem.performOperation()).thenReturn("1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n");
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("2").thenReturn("Kite Runner");
        Controller controller = new Controller(welcomeUser, mainMenuItem, library, consoleView);
        controller.run();

        verify(consoleView).printOnConsole("Welcome to The Biblioteca\n");
        verify(consoleView).printOnConsole("1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. Quit\n");
        verify(consoleView).printOnConsole("Thank you! Enjoy the book\n");
    }
}