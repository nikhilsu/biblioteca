package com.thoughtworks.librarysys;

public class ReturnBookMenuItem extends  MainMenuItem{
    private Library library;
    private ConsoleInput consoleInput;

    public ReturnBookMenuItem(Library library, ConsoleInput consoleInput) {
        this.library = library;
        this.consoleInput = consoleInput;
    }

    @Override
    public String performOperation() {
        String nameOfTheBookToCheckout = consoleInput.inputFromUser();
        Book bookToBeReturned = new Book(nameOfTheBookToCheckout, "Author", 0);
        if (library.toReturn(bookToBeReturned) == true)
            return "Thank you for returning the book\n";
        else
            return "That is not a valid book to return\n";
    }
}
