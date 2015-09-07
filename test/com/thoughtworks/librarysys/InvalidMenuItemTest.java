package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidMenuItemTest {

    @Test
    public void shouldReturnTheStringSelectValidChoiceWhenPerformOperationMethodIsCalled() {
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem();

        assertEquals("Select a valid option!\n", invalidMenuItem.performOperation());
    }
}