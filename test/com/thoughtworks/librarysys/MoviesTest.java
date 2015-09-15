package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MoviesTest {

    @Test
    public void shouldReturnTheNamesOfAllTheMovieList() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryObserver libraryObserver = mock(LibraryObserver.class);
        Movies movies = new Movies(listOfMovies, libraryObserver) ;

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 8) +
                String.format("%-25s%-20s%-30s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9) + "\n";

        assertEquals(testString, movies.displayListOfDetails());
    }

    @Test
    public void shouldCheckoutAMovieThatIsPresentInTheLibrary() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryObserver libraryObserver = mock(LibraryObserver.class);
        Movies movies = new Movies(listOfMovies, libraryObserver) ;

        Movie movieToCheckOut = new Movie("Gone Girl", 0, "Director" ,0);
        movies.checkOut(movieToCheckOut);

        verify(libraryObserver).notifySuccessfulMovieCheckout();
    }

    @Test
    public void shouldNotCheckOutAMovieThatIsNotPresentInTheLibrary() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryObserver libraryObserver = mock(LibraryObserver.class);
        Movies movies = new Movies(listOfMovies, libraryObserver) ;

        Movie movieToCheckOut = new Movie("Movie", 0, "Director" ,0);
        movies.checkOut(movieToCheckOut);

        verify(libraryObserver).notifyUnsuccessfulMovieCheckout();
    }
}