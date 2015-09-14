package com.thoughtworks.librarysys;

import java.util.ArrayList;

//listbooksmenuitem is a mainmenuitem that returns the list of all the books in the library
public class ListBooksMenuItem extends MenuItem {
    private Library library;
    private ConsoleView consoleView;

    public ListBooksMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return library.toString();
    }
}
