package com.thoughtworks.librarysys;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class QuitMenuItemTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheApplicationWhenThePerformOperationMethodIsCalled() {
        QuitMenuItem quitMenuItem = new QuitMenuItem();

        exit.expectSystemExit();
        quitMenuItem.performOperation();
    }
}