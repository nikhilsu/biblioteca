package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldCheckoutABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheCheckoutMenuItem() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn("Guest");
        MainMenuFactory mainMenuFactory = mock(MainMenuFactory.class);
        MainMenu mainMenu = mock(MainMenu.class);
        when(mainMenuFactory.manufacture(user)).thenReturn(mainMenu);
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        InputParser inputParser = mock(InputParser.class);
        when(inputParser.parse("1")).thenReturn(listBooksMenuItem);
        InputParserFactory inputParserFactory = mock(InputParserFactory.class);
        when(inputParserFactory.manufacture(user)).thenReturn(inputParser);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("1");
        Controller controller = new Controller(mainMenuFactory, inputParserFactory, consoleView, user);

        controller.run();

        verify(listBooksMenuItem).performOperation();
    }
}