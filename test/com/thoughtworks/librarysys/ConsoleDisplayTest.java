package com.thoughtworks.librarysys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(message);

        consoleDisplay.displayOnScreen();

        assertEquals("Welcome\n", outputStream.toString());
    }
}
