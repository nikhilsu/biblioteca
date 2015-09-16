package com.thoughtworks.librarysys;

import java.util.HashMap;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private Library library;
    private ConsoleView consoleView;
    private HashMap<String, MenuOptions> mapper;

    public InputParser(Library library, ConsoleView consoleView, HashMap<String, MenuOptions> mapper) {
        this.library = library;
        this.consoleView = consoleView;
        this.mapper = mapper;
    }

    public MenuOptions parse(String userChoice) {
       if (mapper.get(userChoice) != null)
           return mapper.get(userChoice);
        else
           return new InvalidMenuItem("Select a valid option!", consoleView);
    }
}
