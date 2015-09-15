package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameName() {
        User userOne = new User("111-1111", "passwd");
        User userTwo = new User("111-1111", "passwd");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameLibraryIDAndPassword() {
        User userOne = new User("111-1111", "passwd");
        User userTwo = new User("111-1111", "passwd");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithSameLibraryIDButDifferentPassword() {
        User userOne = new User("111-1111", "passwd");
        User userTwo = new User("111-1111", "Not a Password");

        assertNotEquals(userOne, userTwo);
    }
}