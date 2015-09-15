package com.thoughtworks.librarysys;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    private Books books;
    private Movies movies;
    private ConsoleView consoleView;

    public InputParser(Books books, ConsoleView consoleView) {
        this.books = books;
        this.consoleView = consoleView;
    }

    public MenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(books, consoleView);
        else if (userChoice.equals("2"))
            return new CheckoutBookMenuItem(books, consoleView);
        else if (userChoice.equals("3"))

            return new ReturnBookMenuItem(books, consoleView);
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!", consoleView);
    }
}
