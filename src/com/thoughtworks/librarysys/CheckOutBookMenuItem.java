package com.thoughtworks.librarysys;

//checkoutbook menu item is a menu item responsible for checking out a book from the books
public class CheckoutBookMenuItem extends MenuItem {
    private Books books;
    private ConsoleView consoleView;

    public CheckoutBookMenuItem(Books books, ConsoleView consoleView) {
        this.books = books;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to checkout: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToCheckout = new Book(nameOfTheBookToCheckout, "Not needed", 0);
        books.checkOut(bookToCheckout);
    }
}
