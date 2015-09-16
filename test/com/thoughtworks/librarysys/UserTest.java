package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameName() {
        User userOne = new User("111-1111", "passwd", "Registered");
        User userTwo = new User("111-1111", "passwd", "Registered");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameLibraryIDAndPassword() {
        User userOne = new User("111-1111", "passwd", "Registered");
        User userTwo = new User("111-1111", "passwd", "Registered");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithSameLibraryIDButDifferentPassword() {
        User userOne = new User("111-1111", "passwd", "Registered");
        User userTwo = new User("111-1111", "Not a Password", "Registered");

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToSomethingThatIsNotAUser() {
        User userOne = new User("111-1111", "passwd", "Registered");

        assertNotEquals(userOne, "User");
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("111-1111", "passwd", "Registered");

        assertNotEquals(userOne, null);
    }

    @Test
    public void shouldHaveTheSameHashCodeAsAnotherObjectHavingTheSameState() {
        User userOne = new User("111-1111", "passwd", "Registered");
        User userTwo = new User("111-1111", "passwd", "Registered");

        assertEquals(userOne.hashCode(), userTwo.hashCode());
    }

    @Test
    public void sameObjectsHaveEqualHashCodes() {
        User userOne = new User("111-1111", "passwd", "Registered");

        assertEquals(userOne.hashCode(), userOne.hashCode());
    }

    @Test
    public void registeredUserShouldHaveTheirRoleAsRegistered() {
        User user = new User("111-1111", "password", "Registered");

        assertEquals(user.getRole(), "Registered");
    }
}