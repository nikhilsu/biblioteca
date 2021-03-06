package com.thoughtworks.librarysys;

public class ListMovieMenuItem implements MenuOptions {
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
