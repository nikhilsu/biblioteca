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
        ConsoleView consoleView = mock(ConsoleView.class);
        consoleView.printOnConsole("Hello World!");

        verify(consoleView, times(1)).printOnConsole("Hello World!");
    }

    @Test
    public void shouldReturnTheUserInputString() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("hello world\n".getBytes());

        ConsoleView consoleView = new ConsoleView(new Scanner(inputStream), new PrintStream(System.out));

        assertEquals("hello world", consoleView.inputFromUser());

    }

    @Test
    public void shouldPrintTheSuccessfulCheckoutMessageOntoTheConsole() {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);

        consoleView.notifySuccessfulBookCheckout();

        verify(printStream).print("Thank you! Enjoy the book\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulCheckoutMessageOntoTheConsole() {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);

        consoleView.notifyUnsuccessfulCheckout();

        verify(printStream).print("That book is not available\n");
    }

    @Test
    public void shouldPrintTheSuccessfulReturnMessageOntoTheConsole() {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);

        consoleView.notifySuccessfulReturn();

        verify(printStream).print("Thank you for returning the book\n");
    }

    @Test
    public void shouldPrintTheUnsuccessfulReturnMessageOntoTheConsole() {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = mock(PrintStream.class);
        ConsoleView consoleView = new ConsoleView(scanner, printStream);

        consoleView.notifyUnsuccessfulReturn();

        verify(printStream).print("That is not a valid book to return\n");
    }
}