package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ReturnBookMainMenuTest {

    @Test
    public void shouldReturnABookFromTheUserToTheLibraryByTheInputNameOfTheBook() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Gone Girl");
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);
        Book bookToReturn = new Book("Gone Girl", "Not needed", 0);
        returnBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to Return: ");
        verify(library).toReturn(bookToReturn);
    }

    @Test
    public void shouldNotReturnABookToTheLibraryThatDoesNotBelongToIt() {

        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("Head First Java");
        ReturnBookMenuItem returnBookMenuItem = new ReturnBookMenuItem(library, consoleView);
        Book bookToReturn = new Book("Head First Java", "Not needed", 0);
        returnBookMenuItem.performOperation();

        verify(consoleView).printOnConsole("Enter The Book to Return: ");
        verify(library).toReturn(bookToReturn);
    }
}