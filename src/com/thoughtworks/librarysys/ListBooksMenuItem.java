package com.thoughtworks.librarysys;

//listbooksmenuitem is a mainmenuitem that returns the list of all the books in the library
public class ListBooksMenuItem extends MainMenuItem {
    private Library library;

    public ListBooksMenuItem(Library library) {
        this.library = library;
    }

    @Override
    public String performOperation() {
        return this.toString();
    }

    @Override
    public String toString() {
        return library.toString();
    }
}
