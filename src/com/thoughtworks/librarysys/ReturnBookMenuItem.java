package com.thoughtworks.librarysys;

import java.util.Scanner;

public class ReturnBookMenuItem extends  MainMenuItem{
    Library library;

    public ReturnBookMenuItem(Library library) {
        this.library = library;
    }

    @Override
    public String performOperation() {
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String nameOfTheBookToCheckout = consoleInput.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        if (library.toReturn(bookToBeReturned) == true)
            return "Thank you for returning the book\n";
        else
            return "That is not a valid book to return\n";
    }
}
