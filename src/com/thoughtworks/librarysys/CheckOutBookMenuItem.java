package com.thoughtworks.librarysys;

//checkoutbook menu item is a menu item responsible for checking out a book from the books
public class CheckoutBookMenuItem implements MenuOptions {
    private Library library;
    private ConsoleView consoleView;
    private User currentUser;

    public CheckoutBookMenuItem(Library library, ConsoleView consoleView, User currentUser) {
        this.library = library;
        this.consoleView = consoleView;
        this.currentUser = currentUser;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to checkout: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        library.checkOut(bookToCheckout, currentUser);
    }
}
