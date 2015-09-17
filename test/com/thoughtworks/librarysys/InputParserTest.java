package com.thoughtworks.librarysys;

import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputParserTest {

    @Test
    public void shouldReturnAnObjectOfTypeListBooksWhenTheUsersChoiceOfMenuItemIsOne() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("1")).thenReturn(new ListBooksMenuItem(library, consoleView));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "1";

        assertEquals(new ListBooksMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutBookMenuItemWhenTheUsersChoiceOfMenuItemIsTwo() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        User user = mock(User.class);
        when(mapper.get("2")).thenReturn(new CheckoutBookMenuItem(library, consoleView, user));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "2";

        assertEquals(new CheckoutBookMenuItem(library, consoleView, user).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeQuitMenuItemWhenTheUsersChoiceOfMenuItemIsFour() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("4")).thenReturn(new QuitMenuItem());
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "4";

        assertEquals(new QuitMenuItem().getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeInvalidMenuChoiceWhenTheUsersChoiceOfMenuItemIsInvalid() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("0")).thenReturn(new InvalidMenuItem("Select a valid option!", consoleView));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "0";

        assertEquals(new InvalidMenuItem("Select a valid option!", consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeReturnBookMenuItemWhenTheUsersChoiceOfMenuItemIsThree() {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        User user = mock(User.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("3")).thenReturn(new ReturnBookMenuItem(library, consoleView, user));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "3";

        assertEquals(new ReturnBookMenuItem(library, consoleView, user).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeListMoviesItemWhenTheUsersChoiceOfMenuItemIsFive () {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("5")).thenReturn(new ListMovieMenuItem(library, consoleView));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "5";

        assertEquals(new ListMovieMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldReturnAnObjectOfTypeCheckoutMovieItemWhenTheUsersChoiceOfMenuItemIsSix () {
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapper = mock(HashMap.class);
        when(mapper.get("6")).thenReturn(new CheckoutMovieMenuItem(library, consoleView));
        InputParser inputParser = new InputParser(consoleView, mapper);

        String userChoice = "6";

        assertEquals(new CheckoutMovieMenuItem(library, consoleView).getClass(), inputParser.parse(userChoice).getClass());
    }

    @Test
    public void shouldBeEqualToAnotherParserWithTheSameConsoleView() {
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> map = mock(HashMap.class);
        InputParser inputParserOne = new InputParser(consoleView, map);
        InputParser inputParserTwo = new InputParser(consoleView, map);

        assertEquals(inputParserOne, inputParserTwo);
    }

    @Test
    public void shouldNotBeEqualToAnotherParserWithTheSameConsoleViewAndMap() {
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> mapOne = mock(HashMap.class);
        HashMap<String, MenuOptions> mapTwo = mock(HashMap.class);
        InputParser inputParserOne = new InputParser(consoleView, mapOne);
        InputParser inputParserTwo = new InputParser(consoleView, mapTwo);

        assertNotEquals(inputParserOne, inputParserTwo);
    }

    @Test
    public void shouldNotBeEqualToSomethingThatIsNotAParser() {
        ConsoleView consoleView = mock(ConsoleView.class);
        HashMap<String, MenuOptions> map = mock(HashMap.class);
        InputParser inputParserOne = new InputParser(consoleView, map);

        assertNotEquals(inputParserOne, "inputParserTwo");
    }
}