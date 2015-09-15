package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class ListMovieMenuItem extends MenuItem {
    private Library library;
    private ConsoleView consoleView;

    public ListMovieMenuItem(Library library, ConsoleView consoleView) {
        this.library = library;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return library.listMovies();
    }
}
