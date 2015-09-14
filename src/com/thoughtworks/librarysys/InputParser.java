package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private Library library;
    private ConsoleView consoleView;

    public InputParser(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    public MainMenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(library);
        else if (userChoice.equals("2")) {
            consoleView.printOnConsole("Enter The Book to checkout: ");
            return new CheckoutBookMenuItem(library, consoleView);
        }
        else if (userChoice.equals("3")) {
            consoleView.printOnConsole("Enter the book to return: ");
            return new ReturnBookMenuItem(library, consoleView);
        }
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!");
    }
}
