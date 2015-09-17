package com.thoughtworks.librarysys;

import java.util.HashMap;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private ConsoleView consoleView;
    private HashMap<String, MenuOptions> mapper;

    public InputParser(ConsoleView consoleView, HashMap<String, MenuOptions> mapper) {
        this.consoleView = consoleView;
        this.mapper = mapper;
    }

    public MenuOptions parse(String userChoice) {
       if (mapper.get(userChoice) != null)
           return mapper.get(userChoice);
        else
           return new InvalidMenuItem("Select a valid option!", consoleView);
    }

    @Override
    public boolean equals(Object obj) {
        InputParser that = (InputParser) obj;
        if(this.consoleView.equals(that.consoleView))
            return true;
        else
            return false;
    }
}