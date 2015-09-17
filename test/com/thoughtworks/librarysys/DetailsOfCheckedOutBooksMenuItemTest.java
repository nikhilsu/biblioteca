package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailsOfCheckedOutBooksMenuItemTest {

    @Test
    public void shouldDisplayTheDetailsOfWhoCheckedOutWhichBooks() {
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = mock(Library.class);
        when(library.listBookCheckoutDetails()).thenReturn("List of details of checked out books");
        DetailsOfCheckedOutBooksMenuItem detailsOfCheckedOutBooksMenuItem = new DetailsOfCheckedOutBooksMenuItem(library, consoleView);

        detailsOfCheckedOutBooksMenuItem.performOperation();

        verify(library).listBookCheckoutDetails();
        verify(consoleView).printOnConsole("List of details of checked out books");
    }

}