package com.thoughtworks.librarysys;

//returnbookmenuitem is a menu item responsible for returning a book to the books
public class ReturnBookMenuItem implements MenuOptions {
    private Library library;
    private ConsoleView consoleView;
    private User currentUser;

    public ReturnBookMenuItem(Library library, ConsoleView consoleView, User currentUser) {
        this.library = library;
        this.consoleView = consoleView;
        this.currentUser = currentUser;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Book to Return: ");
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        library.toReturn(bookToBeReturned, currentUser);
    }
}
