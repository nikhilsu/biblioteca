package com.thoughtworks.librarysys;

public class ListMovie extends MenuItem {
    private LibraryMovies libraryMovies;
    private ConsoleView consoleView;

    public ListMovie(LibraryMovies libraryMovies, ConsoleView consoleView) {
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
