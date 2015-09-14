package com.thoughtworks.librarysys;

//listbooksmenuitem is a mainmenuitem that returns the list of all the books in the libraryBooks
public class ListBooksMenuItem extends MenuItem {
    private LibraryBooks libraryBooks;
    private ConsoleView consoleView;

    public ListBooksMenuItem(LibraryBooks libraryBooks, ConsoleView consoleView) {
        this.libraryBooks = libraryBooks;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return libraryBooks.displayListOfDetails();
    }
}
