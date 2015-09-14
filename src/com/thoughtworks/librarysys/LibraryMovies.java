package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class LibraryMovies {
    ArrayList<Movie> listOfMovies;

    public LibraryMovies(ArrayList<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public String displayListOfDetails() {
        String listOfMovieDetails = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0","-");
        for (Movie movie : listOfMovies)
            listOfMovieDetails += movie.displayDetails();
        return listOfMovieDetails + "\n";
    }
}
