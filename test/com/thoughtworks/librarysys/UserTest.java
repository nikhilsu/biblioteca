package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameLibraryID() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "password1", "Registered");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldBeEqualToAnotherUserWithTheSameLibraryIDAndPassword() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "passwd", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "passwd", "Registered");

        assertEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToAnotherUserWithSameLibraryIDButDifferentPassword() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "passwd", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "Not a Password", "Registered");

        assertNotEquals(userOne, userTwo);
    }

    @Test
    public void shouldNotBeEqualToSomethingThatIsNotAUser() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "passwd", "Registered");

        assertNotEquals(userOne, "User");
    }

    @Test
    public void shouldNotBeEqualToNull() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "passwd", "Registered");

        assertNotEquals(userOne, null);
    }

    @Test
    public void shouldHaveTheSameHashCodeAsAnotherObjectHavingTheSameState() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "passwd", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "passwd", "Registered");

        assertEquals(userOne.hashCode(), userTwo.hashCode());
    }

    @Test
    public void sameObjectsHaveEqualHashCodes() {
        User userOne = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "passwd", "Registered");

        assertEquals(userOne.hashCode(), userOne.hashCode());
    }

    @Test
    public void registeredUserShouldHaveTheirRoleAsRegistered() {
        User user = new User("Mary", "xyz@mail.com", "22345678", "111-1111", "password", "Registered");

        assertEquals(user.getRole(), "Registered");
    }

    @Test
    public void shouldReturnTheLibraryIDOfTheUserWhenTheToStringMethodIsCalled() {
        User user = new User("Mary", "xyz@mail.com", "22345678", "222-2222", "password2", "Registered");

        String testString = String.format("%s\t%s\t%s\t%s", "222-2222", "Mary", "xyz@mail.com", "22345678");

        assertEquals(testString, user.toString());
    }
}