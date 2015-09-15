package com.thoughtworks.librarysys;

//listbooksmenuitem is a mainmenuitem that returns the list of all the books in the books
public class ListBooksMenuItem extends MenuItem {
    private Books books;
    private ConsoleView consoleView;

    public ListBooksMenuItem(Books books, ConsoleView consoleView) {
        this.books = books;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return books.displayListOfDetails();
    }
}
