package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutMenuItemTest {

    @Test
    public void shouldChangeTheUserToGuestOnLogout() {
        User user = new User("111-1111", "password1", "Registered");
        ConsoleView consoleView = mock(ConsoleView.class);
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem(user, consoleView);

        logoutMenuItem.performOperation();
        User loggedOutUser = new User("Not a member", "Not Known", "Guest");

        assertEquals(loggedOutUser, logoutMenuItem.getUser());
        verify(consoleView).printOnConsole("Successfully Logged Out!\n\n");
    }
}