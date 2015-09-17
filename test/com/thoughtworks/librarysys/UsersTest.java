package com.thoughtworks.librarysys;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UsersTest {

    @Test
    public void shouldAuthenticateARegisteredUserWithValidCredentials() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "222-2222", "password2", "Registered");
        User userThree = new User("David", "pqr@mail.com", "32345678", "333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Users users = new Users(listOfRegisteredUsers);

        assertEquals(users.authenticate("111-1111", "password1"), new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Guest"));
    }

    @Test
    public void shouldNotAuthenticateARegistedUserWithInvalidCredentials() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "222-2222", "password2", "Registered");
        User userThree = new User("David", "pqr@mail.com", "32345678", "333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Users users = new Users(listOfRegisteredUsers);

        assertEquals(users.authenticate("111-1111", "wrong Password"), new User("Temp", "mailAddress", "00000000", "Not a member", "Not known", "Guest"));
    }

    @Test
    public void shouldNotAuthenticateAnUnregisteredUser() {
        User userOne = new User("John", "abc@mail.com", "12345678", "111-1111", "password1", "Registered");
        User userTwo = new User("Mary", "xyz@mail.com", "22345678", "222-2222", "password2", "Registered");
        User userThree = new User("David", "pqr@mail.com", "32345678", "333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Users users = new Users(listOfRegisteredUsers);

        assertEquals(users.authenticate("Not a member", "No password"), new User("Temp", "mailAddress", "00000000", "Not a member", "Not known", "Guest"));
    }
}