package com.thoughtworks.librarysys;

//checkoutbook menu item is a menu item responsible for checking out a book from the library
public class CheckoutBookMenuItem extends MainMenuItem {
    private Library library;
    private ConsoleView consoleView;

    public CheckoutBookMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public String performOperation() {
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        if (library.checkOut(bookToCheckout) == true)
            return "Thank you! Enjoy the book\n";
        else
            return "That book is not available\n";
    }
}
