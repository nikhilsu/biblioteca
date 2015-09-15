package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class InputParserTest {

    @Test
    public void shouldReturnAnObjectOfTypeListBooksWhenTheUsersChoiceOfMenuItemIsOne() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "1";

        assertEquals(new ListBooksMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutBookMenuItemWhenTheUsersChoiceOfMenuItemIsTwo() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "2";

        assertEquals(new CheckoutBookMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeQuitMenuItemWhenTheUsersChoiceOfMenuItemIsFour() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "4";

        assertEquals(new QuitMenuItem().getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeInvalidMenuChoiceWhenTheUsersChoiceOfMenuItemIsInvalid() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "0";

        assertEquals(new InvalidMenuItem("Select a valid option!", consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeReturnBookMenuItemWhenTheUsersChoiceOfMenuItemIsThree() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "3";

        assertEquals(new ReturnBookMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeListMoviesItemWhenTheUsersChoiceOfMenuItemIsFive () {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "5";

        assertEquals(new ListMovieMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutMovieItemWhenTheUsersChoiceOfMenuItemIsSix () {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        InputParser inputParser = new InputParser(library, consoleView);

        String userChoice = "6";

        assertEquals(new CheckoutMovieMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }
}