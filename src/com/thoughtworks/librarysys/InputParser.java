package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private Library library;
    private ConsoleView consoleView;


    public InputParser(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    public MenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(library, consoleView);
        else if (userChoice.equals("2"))
            return new CheckoutBookMenuItem(library, consoleView);
        else if (userChoice.equals("3"))
            return new ReturnBookMenuItem(library, consoleView);
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else if (userChoice.equals("5"))
            return new ListMovieMenuItem(library, consoleView);
        else if (userChoice.equals("6"))
            return new CheckoutMovieMenuItem(library, consoleView);
        else
            return new InvalidMenuItem("Select a valid option!", consoleView);
    }
}
