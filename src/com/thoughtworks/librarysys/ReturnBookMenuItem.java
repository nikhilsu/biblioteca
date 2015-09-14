package com.thoughtworks.librarysys;

//returnbookmenuitem is a menu item responsible for returning a book to the library
public class ReturnBookMenuItem extends MenuItem {
    private Library library;
    private ConsoleView consoleView;

    public ReturnBookMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to Return: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        library.toReturn(bookToBeReturned);
    }
}
