package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMovieMenuItemTest {

    @Test
    public void shouldPrintTheListOfMoviePresentInTheLibrary() {
        Library library = mock(Library.class);
        when(library.listMovies()).thenReturn(String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 9) +
                String.format("%-25s%-20s%-30s%-20s\n", "Movie Name", 2010, "Director", 8) + "\n");
        ConsoleView consoleView = mock(ConsoleView.class);
        ListMovieMenuItem listMovieMenuItem = new ListMovieMenuItem(library, consoleView);

        listMovieMenuItem.performOperation();
        String testString = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 9) +
                String.format("%-25s%-20s%-30s%-20s\n", "Movie Name", 2010, "Director", 8) + "\n";

        verify(consoleView).printOnConsole(testString);
    }

    @Test
    public void shouldPrintTheListOfMoviePresentInTheLibraryWhenTheToStringMethodIsCalled() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        Movie movieOne = new Movie("Gone Girl", 2014, "David Fincher", 9);
        Movie movieTwo = new Movie("Movie Name", 2010, "Director", 8);
        listOfMovies.add(movieOne);
        listOfMovies.add(movieTwo);
        ConsoleView consoleView = mock(ConsoleView.class);
        Library library = mock(Library.class);
        when(library.listMovies()).thenReturn(String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 9) +
                String.format("%-25s%-20s%-30s%-20s\n", "Movie Name", 2010, "Director", 8) + "\n");

        ListMovieMenuItem listMovieMenuItem = new ListMovieMenuItem(library, consoleView);

        String testString = String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Name Of The Movie", "Year Of Release", "Director", "Rating") +
                String.format("%085d\n", 0).replace("0", "-") +
                String.format("%-25s%-20s%-30s%-20s\n", "Gone Girl", 2014, "David Fincher", 9) +
                String.format("%-25s%-20s%-30s%-20s\n", "Movie Name", 2010, "Director", 8) + "\n";

        assertEquals(testString, listMovieMenuItem.toString());
    }
}