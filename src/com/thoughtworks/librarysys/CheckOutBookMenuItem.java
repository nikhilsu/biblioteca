package com.thoughtworks.librarysys;

import java.util.ArrayList;
import java.util.Scanner;

//checkoutbook menu item is a menu item responsible for checking out a book from the library
public class CheckoutBookMenuItem extends MainMenuItem{
    private Library library;
    private ConsoleInput consoleInput;

    public CheckoutBookMenuItem(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    @Override
    public String performOperation() {
        String nameOfTheBookToCheckout = consoleInput.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        if (library.checkOut(bookToCheckout) == true)
            return "Thank you! Enjoy the book\n";
        else
            return "That book is not available\n";
    }
}
