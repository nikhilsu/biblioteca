package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleViewTest {

    @Test
    public void shouldDisplayAStringPassedToItOnTheConsole() {
        PrintStream printStream = mock(PrintStream.class);
        Scanner scanner = new Scanner(System.in);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);
        consoleView.printOnConsole("Hello World!");

        verify(printStream, times(1)).print("Hello World!");
    }

    @Test
    public void shouldReturnTheUserInputString() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("hello world\n".getBytes());

        ConsoleView consoleView = new ConsoleView(new Scanner(inputStream), new PrintStream(System.out));

        assertEquals("hello world", consoleView.inputFromUser());

    }
}