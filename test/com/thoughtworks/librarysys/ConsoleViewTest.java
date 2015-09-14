package com.thoughtworks.librarysys;

import org.junit.Test;

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
}