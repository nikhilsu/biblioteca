package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    MainMenuItem mainMenuItem;
    Library library;

    public InputParser(MainMenuItem mainMenuItem, Library library) {
        this.mainMenuItem = mainMenuItem;
        this.library = library;
    }

    public MainMenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(library);
        else if (userChoice.equals("2"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!");
    }
}
