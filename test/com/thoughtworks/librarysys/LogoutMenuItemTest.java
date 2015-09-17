package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutMenuItemTest {

    @Test
    public void shouldChangeTheUserToGuestOnLogout() {
        User user = new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Registered");
        ConsoleView consoleView = mock(ConsoleView.class);
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem(user, consoleView);

        logoutMenuItem.performOperation();
        User loggedOutUser = new User("Temp", "mailAddress", "00000000", "Not a member", "Not known", "Guest");

        assertEquals(loggedOutUser, logoutMenuItem.getUser());
        verify(consoleView).printOnConsole("Successfully Logged Out!\n\n");
    }
}