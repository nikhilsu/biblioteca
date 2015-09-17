package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserDetailMenuItemTest {

    @Test
    public void shouldPrintTheDetailsOfTheCurrentUserLoggedIn() {
        ConsoleView consoleView = mock(ConsoleView.class);
        User user = mock(User.class);
        when(user.toString()).thenReturn(String.format("%s\t%s\t%s\t%s", "111-1111", "John", "abc@mail.com", "12345678"));
        UserDetailMenuItem userDetailMenuItem = new UserDetailMenuItem(user, consoleView);

        String testString = "Name : John\nE-mail : abc@mail.com\nPhone No. : 12345678\n\n";
        userDetailMenuItem.performOperation();

        verify(consoleView).printOnConsole(testString);
    }
}