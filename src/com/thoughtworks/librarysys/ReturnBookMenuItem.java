package com.thoughtworks.librarysys;

//returnbookmenuitem is a menu item responsible for returning a book to the libraryBooks
public class ReturnBookMenuItem extends MenuItem {
    private LibraryBooks libraryBooks;
    private ConsoleView consoleView;

    public ReturnBookMenuItem(LibraryBooks libraryBooks, ConsoleView consoleView) {
        this.libraryBooks = libraryBooks;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to Return: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        libraryBooks.toReturn(bookToBeReturned);
    }
}
