package com.thoughtworks.librarysys;

//returnbookmenuitem is a menu item responsible for returning a book to the library
public class ReturnBookMenuItem extends  MainMenuItem {
    private Library library;
    private ConsoleView consoleView;

    public ReturnBookMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public String performOperation() {
        String nameOfTheBookToCheckout = consoleView.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        if (library.toReturn(bookToBeReturned) == true)
            return "Thank you for returning the book\n";
        else
            return "That is not a valid book to return\n";
    }
}
