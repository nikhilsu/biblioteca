package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListBooksMenuItemTest {

    @Test
    public void shouldReturnTheListOfAllTheBooksInTheLibrary() {
        Library library = mock(Library.class);
        when(library.listBooks()).thenReturn(String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n");
        ConsoleView consoleView = mock(ConsoleView.class);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(library, consoleView);

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";
        listBooksMenuItem.performOperation();

        verify(consoleView).printOnConsole(testString);
    }

    @Test
    public void shouldReturnTheListOfAllTheBooksInTheLibraryWhenToStringMethodIsInvoked() {
        Library library = mock(Library.class);
        when(library.listBooks()).thenReturn(String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n");
        ConsoleView consoleView = mock(ConsoleView.class);
        ListBooksMenuItem listBooksMenuItem = new ListBooksMenuItem(library, consoleView);

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-30s%-30s%-20s\n", "Name Of The Book", "Author", "Year Of Publication") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-30s%-30s%-20s\n", "Gone Girl", "Gillian Flynn", 2014) +
                String.format("%-30s%-30s%-20s\n", "Kite Runner", "Khaled Hossieni", 2003) +
                String.format("%-30s%-30s%-20s\n", "Inferno", "Dan Brown", 2012) + "\n";

        assertEquals(testString, listBooksMenuItem.toString());
    }

}