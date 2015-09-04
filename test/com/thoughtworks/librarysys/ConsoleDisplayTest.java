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
        ArrayList<String> message = new ArrayList<String>();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(message);
        message.add("Welcome");

        consoleDisplay.displayOnScreen();

        assertEquals("Welcome\n", outputStream.toString());
    }
}
