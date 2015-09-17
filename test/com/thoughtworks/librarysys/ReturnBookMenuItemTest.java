package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ReturnBookMenuItemTest {

    @Test
    public void shouldReturnABookFromTheUserToTheLibraryByTheInputNameOfTheBook() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        User user = mock(User.class);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView, user);
        Book bookToReturn = new Book("Gone Girl", "Not needed", 0);
        returnBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to Return: ");
        verify(library).toReturn(bookToReturn, user);
    }

    @Test
    public void shouldNotReturnABookToTheLibraryThatDoesNotBelongToIt() {

        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        User user = mock(User.class);
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView, user);
        Book bookToReturn = new Book("Head First Java", "Not needed", 0);
        returnBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to Return: ");
        verify(library).toReturn(bookToReturn, user);
    }
}