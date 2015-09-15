package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnTheNameOfTheMovieYearOfReleaaseDirectorAndRatingInAFormattedString() {
        Movie movie = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        String testString = String.format("%-25s%-20s%-30s%-20s\n", "Matrix", 1999, "Andy Wachowski", 9);

        assertEquals(testString, movie.displayDetails());
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie movie = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        assertEquals(movie, movie);
    }

    @Test
    public void shouldBeEqualToAnotherMovieWithTheSameName() {
        Movie movieOne = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        Movie movieTwo = new Movie("Matrix", 0, "Director", 0);

        assertEquals(movieOne, movieTwo);
    }

    @Test
    public void shouldNotBeEqualoSomethingThatIsNotAMovie() {
        Movie movie = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        assertNotEquals(movie, "Movie");
    }

    @Test
    public void shouldNotBeEqualToNull() {
        Movie movie = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        assertNotEquals(movie, null);
    }
}