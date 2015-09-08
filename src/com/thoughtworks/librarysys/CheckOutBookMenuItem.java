package com.thoughtworks.librarysys;

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
            return "Done";
        else
            return "Can't perform OP";
    }
}
