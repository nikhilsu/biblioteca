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
}