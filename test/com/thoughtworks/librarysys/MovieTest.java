package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void shouldNotBeEqualToAnotherMovie() {
        Movie movieOne = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        Movie movieTwo = new Movie("Gone Girl", 2014, "David Fincher", 9);

        assertNotEquals(movieOne, movieTwo);
    }

    @Test
    public void shouldHaveSameHashCodeWhenTheObjectsAreSame() {
        Movie movieOne = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        assertEquals(movieOne.hashCode(), movieOne.hashCode());
    }

    @Test
    public void twoMoviesShouldHaveSameHashCodesWhenTheirStatesAreTheSame() {
        Movie movieOne = new Movie("Matrix", 1999, "Andy Wachowski", 9);
        Movie movieTwo = new Movie("Matrix", 1999, "Andy Wachowski", 9);

        assertEquals(movieOne.hashCode(), movieTwo.hashCode());
    }
}