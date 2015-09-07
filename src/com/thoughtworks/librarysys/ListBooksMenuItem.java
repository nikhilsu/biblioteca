package com.thoughtworks.librarysys;

public class ListBooksMenuItem extends MainMenuItem{
    Library library;

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
