package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DetailsOfCheckedOutBooksMenuItemTest {

    @Test
    public void shouldDisplayTheDetailsOfWhoCheckedOutWhichBooks() {
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = mock(Library.class);
        DetailsOfCheckedOutBooksMenuItem detailsOfCheckedOutBooksMenuItem = new DetailsOfCheckedOutBooksMenuItem(library, consoleView);
    }

}