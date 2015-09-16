package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LogoutMenuItemTest {

    @Test
    public void shouldChangeTheUserToGuestOnLogout() {
        LogoutMenuItem logoutMenuItem = new LogoutMenuItem();

        logoutMenuItem.performOperation();
        User user = new User("Not a member", "Not known", "Guest");

        assertEquals(user, logoutMenuItem.getUser());
    }

}