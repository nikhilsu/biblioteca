package com.thoughtworks.librarysys;

import java.util.Scanner;

//checkoutbook menu item is a menu item responsible for checking out a book from the library
public class CheckoutBookMenuItem extends MainMenuItem{
    private Library library;

    public CheckoutBookMenuItem(Library library) {
        this.library = library;
    }

    @Override
    public String performOperation() {
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        String nameOfTheBookToCheckout = consoleInput.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        if (library.checkOut(bookToCheckout) == true)
            return "Thank you! Enjoy the book\n";
        else
            return "That book is not available\n";
    }
}
