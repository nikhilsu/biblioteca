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
        ArrayList<String> listOfBookDetail = new ArrayList<String>();
        listOfBookDetail.add("Harry Potter\tJ.K Rowling\t1997");
        listOfBookDetail.add("The Monk Who Sold His Ferrari\tRohit Sharma\t1997");
        listOfBookDetail.add("Inferno\tDan Brown\t2012");
        listOfBookDetail.add("Kite Runner\tKhaled Hosseini\t2003");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Welcome", listOfBookDetail);

        consoleDisplay.displayOnScreen();

        String testString = "Welcome\nName of the Book\tAuthor\tYear Of Publication\n" +
                "Harry Potter\tJ.K Rowling\t1997\nThe Monk Who Sold His Ferrari\tRohit Sharma\t1997\n" +
                "Inferno\tDan Brown\t2012\nKite Runner\tKhaled Hosseini\t2003\n";
        assertEquals(testString, outputStream.toString());
    }
}
