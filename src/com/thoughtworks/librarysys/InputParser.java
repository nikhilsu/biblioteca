package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private LibraryBooks libraryBooks;
    private ConsoleView consoleView;

    public InputParser(LibraryBooks libraryBooks, ConsoleView consoleView) {
        this.libraryBooks = libraryBooks;
        this.consoleView = consoleView;
    }

    public MenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(libraryBooks, consoleView);
        else if (userChoice.equals("2"))
            return new CheckoutBookMenuItem(libraryBooks, consoleView);
        else if (userChoice.equals("3"))
            return new ReturnBookMenuItem(libraryBooks, consoleView);
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!", consoleView);
    }
}
