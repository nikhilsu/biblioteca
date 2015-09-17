package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputParserFactoryTest {

    @Test
    public void shouldReturnAParserWithAnAppropriateMapperForTheRegisteredUser(){
        Library library = mock(Library.class);
        ConsoleView consoleView = mock(ConsoleView.class);
        Users users = mock(Users.class);
        InputParserFactory inputParserFactory = new InputParserFactory(library, consoleView, users);
        User user = mock(User.class);
        when(user.getRole()).thenReturn("Registered");
        HashMap<String, MenuOptions> mapper = new HashMap<>();
        mapper.put("1", new ListBooksMenuItem(library, consoleView));
        mapper.put("2", new ListMovieMenuItem(library, consoleView));
        mapper.put("3", new CheckoutMovieMenuItem(library, consoleView));
        mapper.put("4", new CheckoutBookMenuItem(library, consoleView, user));
        mapper.put("5", new ReturnBookMenuItem(library, consoleView, user));
        mapper.put("6", new LogoutMenuItem(user, consoleView));

        InputParser inputParser = new InputParser(consoleView, mapper);

        assertEquals(inputParserFactory.manufacture(user).getClass(), inputParser.getClass());
    }
}