package com.thoughtworks.librarysys;

//listbooksmenuitem is a mainmenuitem that returns the list of all the books in the books
public class ListBooksMenuItem implements MenuOptions {
    private  Library library;
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
        return library.listBooks();
    }
}
