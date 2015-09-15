package com.thoughtworks.librarysys;

public class ListMovieMenuItem extends MenuItem {
    private LibraryMovies libraryMovies;
    private ConsoleView consoleView;

    public ListMovieMenuItem(LibraryMovies libraryMovies, ConsoleView consoleView) {
        this.libraryMovies = libraryMovies;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return libraryMovies.displayListOfDetails();
    }
}
