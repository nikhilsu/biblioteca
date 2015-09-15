package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class Movies {
    ArrayList<Movie> listOfMovies;
    LibraryObserver libraryObserver;

    public Movies(ArrayList<Movie> listOfMovies, LibraryObserver libraryObserver) {
        this.listOfMovies = listOfMovies;
        this.libraryObserver = libraryObserver;
    }

    public String displayListOfDetails() {
        String listOfMovieDetails = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-");
        for (Movie movie : listOfMovies)
            listOfMovieDetails += movie.displayDetails();
        return listOfMovieDetails + "\n";
    }

    public void checkOut(Movie libraryItem) {
        int indexOfMovieToCheckout = listOfMovies.indexOf(libraryItem);
        if(indexOfMovieToCheckout != -1) {
            listOfMovies.remove(indexOfMovieToCheckout);
            libraryObserver.notifySuccessfulMovieCheckout();
        }
        else
            libraryObserver.notifyUnsuccessfulMovieCheckout();
    }
}
