package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldCheckoutABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheCheckoutMenuItem() {
        MainMenu mainMenu = mock(MainMenu.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("1");
        InputParser inputParser = mock(InputParser.class);
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        when(inputParser.parse("1")).thenReturn(listBooksMenuItem);
        Controller controller = new Controller(mainMenu, inputParser, consoleView);

        controller.run();

        verify(listBooksMenuItem).performOperation();
    }
}