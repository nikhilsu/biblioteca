package com.thoughtworks.librarysys;

public class CheckoutMovieMenuItem implements MenuOptions {
    private Library library;
    private ConsoleView consoleView;

    public CheckoutMovieMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole("Enter The Movie to checkout: ");
        String nameOfTheMovieToCheckout = consoleView.inputFromUser();
        Movie movieToCheckout = new Movie(nameOfTheMovieToCheckout, 0, "Not needed", 0);
        library.checkOut(movieToCheckout);
    }
}
