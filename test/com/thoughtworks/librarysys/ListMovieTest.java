package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMovieTest {

    @Test
    public void shouldPrintTheListOfMoviePresentInTheLibrary() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 9);
        Movie movieTwo = new Movie("Movie Name", 2010, "Director", 8);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        ConsoleView consoleView = mock(ConsoleView.class);
        LibraryMovies libraryMovies = new LibraryMovies(listOfMovies);
        ListMovie listMovie = new ListMovie(libraryMovies, consoleView);

        listMovie.performOperation();
        String testString = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 9) +
                String.format("%-25s%-20s%-30s%-20s\n", "Movie Name", 2010, "Director", 8) + "\n";

        verify(consoleView).printOnConsole(testString);
    }

}