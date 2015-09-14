package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

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
        ConsoleView consoleView = mock(ConsoleView.class);

        when(consoleView.inputFromUser()).thenReturn("Hello World");
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
}