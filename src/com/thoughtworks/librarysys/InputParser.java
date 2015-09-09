package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    Library library;
    ConsoleInput consoleInput;

    public InputParser(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    public MainMenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(library);
        else if (userChoice.equals("2"))
            return new CheckoutBookMenuItem(library, consoleInput);
        else if (userChoice.equals("3"))
            return new ReturnBookMenuItem(library, consoleInput);
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!");
    }
}
