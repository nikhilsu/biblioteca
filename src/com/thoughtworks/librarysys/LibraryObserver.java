package com.thoughtworks.librarysys;
//LibraryObserver observes the library class for successful and unsuccessful return and checkouts

public class LibraryObserver {
    private ConsoleView consoleView;

    public LibraryObserver(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void notifySuccessfulBookCheckout() {
        consoleView.printOnConsole("Thank you! Enjoy the book\n\n");
    }

    public void notifyUnsuccessfulBookCheckout() {
        consoleView.printOnConsole("That book is not available\n\n");
    }

    public void notifySuccessfulBookReturn() {
        consoleView.printOnConsole("Thank you for returning the book\n\n");
    }

    public void notifyUnsuccessfulBookReturn() {
        consoleView.printOnConsole("That is not a valid book to return\n\n");
    }

    public void notifySuccessfulMovieCheckout() {
        consoleView.printOnConsole("Thank you! Enjoy the Movie\n\n");
    }

    public void notifyUnsuccessfulMovieCheckout() {
        consoleView.printOnConsole("That Movie is not available\n\n");
    }
}
