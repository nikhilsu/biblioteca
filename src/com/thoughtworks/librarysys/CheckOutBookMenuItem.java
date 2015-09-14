package com.thoughtworks.librarysys;

//checkoutbook menu item is a menu item responsible for checking out a book from the library
public class CheckoutBookMenuItem extends MenuItem {
    private Library library;
    private ConsoleView consoleView;

    public CheckoutBookMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to checkout: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        library.checkOut(bookToCheckout);
    }
}
