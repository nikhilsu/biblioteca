package com.thoughtworks.librarysys;

//returnbookmenuitem is a menu item responsible for returning a book to the books
public class ReturnBookMenuItem extends MenuItem {
    private Books books;
    private ConsoleView consoleView;

    public ReturnBookMenuItem(Books books, ConsoleView consoleView) {
        this.books = books;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to Return: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        books.toReturn(bookToBeReturned);
    }
}
