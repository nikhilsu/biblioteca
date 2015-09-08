package com.thoughtworks.librarysys;

import java.util.Scanner;

//input parser parses a string input to concrete mainmenuitem types
public class InputParser {
    Library library;

    public InputParser(Library library) {
        this.library = library;
    }

    public MainMenuItem parse(String userChoice) {
        if (userChoice.equals("1"))
            return new ListBooksMenuItem(library);
        else if (userChoice.equals("2"))
            return new CheckoutBookMenuItem(library);
        else if (userChoice.equals("3"))
            return new ReturnBookMenuItem(library);
        else if (userChoice.equals("4"))
            return new QuitMenuItem();
        else
            return new InvalidMenuItem("Select a valid option!");
    }
}
