package com.thoughtworks.librarysys;

//checkoutbook menu item is a menu item responsible for checking out a book from the libraryBooks
public class CheckoutBookMenuItem extends MenuItem {
    private LibraryBooks libraryBooks;
    private ConsoleView consoleView;

    public CheckoutBookMenuItem(LibraryBooks libraryBooks, ConsoleView consoleView) {
        this.libraryBooks = libraryBooks;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to checkout: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        libraryBooks.checkOut(bookToCheckout);
    }
}
