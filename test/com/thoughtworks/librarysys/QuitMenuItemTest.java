package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuitMenuItemTest {

    @Test
    public void shouldReturnTheStringExitingApplicationWhenTheToStringMethodIsCalled() {
        QuitMenuItem quitMenuItem = new QuitMenuItem();

        assertEquals("Exiting Application", quitMenuItem.toString());
    }
}