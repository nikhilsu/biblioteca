package com.thoughtworks.librarysys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsoleDisplayTest {
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStream() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayAStringThatIsPassedToTheConsoleDisplay() {
        String message = "Welcome";
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(message, new ArrayList<String>());

        consoleDisplay.displayOnScreen();

        assertEquals("Welcome\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayAListOfBooksAlongWithTheWelcomeMessage() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("Harry Potter");
        books.add("The Monk Who Sold His Ferrari");
        books.add("Inferno");
        books.add("Kite Runner");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Welcome", books);

        consoleDisplay.displayOnScreen();

        assertEquals("Welcome\nHarry Potter\nThe Monk Who Sold His Ferrari\nInferno\nKite Runner\n", outputStream.toString());
    }
}
