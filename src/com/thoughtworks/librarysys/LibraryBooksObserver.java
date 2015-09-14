package com.thoughtworks.librarysys;
//LibraryBooksObserver observes the library class for successful and unsuccessful return and checkouts

public class LibraryBooksObserver {
    private ConsoleView consoleView;

    public LibraryBooksObserver(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void notifySuccessfulBookCheckout() {
        consoleView.printOnConsole("Thank you! Enjoy the book\n\n");
    }

    public void notifyUnsuccessfulCheckout() {
        consoleView.printOnConsole("That book is not available\n\n");
    }

    public void notifySuccessfulReturn() {
        consoleView.printOnConsole("Thank you for returning the book\n\n");
    }

    public void notifyUnsuccessfulReturn() {
        consoleView.printOnConsole("That is not a valid book to return\n\n");
    }
}
