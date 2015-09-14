package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidMenuItemTest {

    @Test
    public void shouldReturnTheStringSelectValidChoiceWhenPerformOperationMethodIsCalled() {
        ConsoleView consoleView = mock(ConsoleView.class);
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem("Select a valid option!", consoleView);

        invalidMenuItem.performOperation();

        verify(consoleView).printOnConsole("Select a valid option!\n");

    }

    @Test
    public void shouldReturnTheStringSelectAValidChoiceWhenToStringMethodIsCalled() {
        ConsoleView consoleView = mock(ConsoleView.class);
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem("Select a valid option!", consoleView);

        assertEquals("Select a valid option!\n", invalidMenuItem.toString());
    }
}