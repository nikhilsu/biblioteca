package com.thoughtworks.librarysys;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    @Test
    public void shouldAuthenticateARegisteredUserWithValidCredentials() {
        User userOne = new User("111-1111", "password1");
        User userTwo = new User("222-2222", "password2");
        User userThree = new User("333-3333", "password3");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("111-1111", "password1");

        assertTrue(authenticator.authenticateUser(userToAuthenticate));
    }

    @Test
    public void shouldNotAuthenticateARegistedUserWithInvalidCredentials() {
        User userOne = new User("111-1111", "password1");
        User userTwo = new User("222-2222", "password2");
        User userThree = new User("333-3333", "password3");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("111-1111", "wrong Password");

        assertFalse(authenticator.authenticateUser(userToAuthenticate));
    }

    @Test
    public void shouldNotAuthenticateAnUnregisteredUser() {
        User userOne = new User("111-1111", "password1");
        User userTwo = new User("222-2222", "password2");
        User userThree = new User("333-3333", "password3");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("Not registered", "password1");

        assertFalse(authenticator.authenticateUser(userToAuthenticate));
    }
}