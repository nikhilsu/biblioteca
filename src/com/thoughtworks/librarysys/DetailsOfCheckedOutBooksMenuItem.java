package com.thoughtworks.librarysys;

public class DetailsOfCheckedOutBooksMenuItem implements MenuOptions {
    private Library library;
    private ConsoleView consoleView;

    public DetailsOfCheckedOutBooksMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }


    @Override
    public void performOperation() {
        String bookCheckoutDetails = library.listBookCheckoutDetails();
        consoleView.printOnConsole(bookCheckoutDetails + "\n\n");
    }
}
