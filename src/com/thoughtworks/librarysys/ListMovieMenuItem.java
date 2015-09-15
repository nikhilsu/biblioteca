package com.thoughtworks.librarysys;

public class ListMovieMenuItem extends MenuItem {
    private Movies movies;
    private ConsoleView consoleView;

    public ListMovieMenuItem(Movies movies, ConsoleView consoleView) {
        this.movies = movies;
        this.consoleView = consoleView;
    }

    @Override
    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        return movies.displayListOfDetails();
    }
}
