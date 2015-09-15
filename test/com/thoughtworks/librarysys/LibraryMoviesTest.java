package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LibraryMoviesTest {

    @Test
    public void shouldReturnTheNamesOfAllTheMovieList() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryMovies libraryMovies = new LibraryMovies(listOfMovies) ;

        String testString = String.format("%085d\n", 0).replace("0","-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 8) +
                String.format("%-25s%-20s%-30s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9) + "\n";

        assertEquals(testString, libraryMovies.displayListOfDetails());
    }

    @Test
    public void shouldCheckoutAMovieThatIsPresentInTheLibrary() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryMovies libraryMovies = new LibraryMovies(listOfMovies) ;

        Movie movieToCheckOut = new Movie("Gone Girl", 0, "Director" ,0);
        libraryMovies.checkOut(movieToCheckOut);
        String testString = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9) + "\n";

        assertEquals(testString, libraryMovies.displayListOfDetails());
    }

    @Test
    public void shouldNotCheckOutAMovieThatIsNotPresentInTheLibrary() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 8);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        LibraryMovies libraryMovies = new LibraryMovies(listOfMovies) ;

        Movie movieToCheckOut = new Movie("Movie", 0, "Director" ,0);
        libraryMovies.checkOut(movieToCheckOut);
        String testString = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 8) +
                String.format("%-25s%-20s%-30s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9) + "\n";

        assertEquals(testString, libraryMovies.displayListOfDetails());
    }
}