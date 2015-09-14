package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void shouldCheckoutABookWhoseNameIsPassedAsInputToTheApplicationWhenTheUserSelectsTheCheckoutMenuItem() {
        MenuItem menuItem = mock(MenuItem.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        when(consoleView.inputFromUser()).thenReturn("1");
        InputParser inputParser = mock(InputParser.class);
        Library library = mock(Library.class);
        ListBooksMenuItem listBooksMenuItem = mock(ListBooksMenuItem.class);
        when(inputParser.parse("1")).thenReturn(listBooksMenuItem);
        Controller controller = new Controller(menuItem, library, inputParser, consoleView);

        controller.run();

        verify(listBooksMenuItem).performOperation();
    }
}