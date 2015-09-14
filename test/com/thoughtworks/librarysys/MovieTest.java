package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnTheNameOfTheMovieYearOfReleaaseDirectorAndRatingInAFormattedString() {
        Movie movie = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        String testString = String.format("%-30s%-20s%-35s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9);

        assertEquals(testString, movie.displayDetails());
    }
}