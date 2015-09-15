package com.thoughtworks.librarysys;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    @Test
    public void shouldAuthenticateARegisteredUserWithValidCredentials() {
        User userOne = new User("111-1111", "password1", "Registered");
        User userTwo = new User("222-2222", "password2", "Registered");
        User userThree = new User("333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("111-1111", "password1", "Registered");

        assertEquals(authenticator.authenticateUser(userToAuthenticate), new User("111-1111", "password1", "Registered"));
    }

    @Test
    public void shouldNotAuthenticateARegistedUserWithInvalidCredentials() {
        User userOne = new User("111-1111", "password1", "Registered");
        User userTwo = new User("222-2222", "password2", "Registered");
        User userThree = new User("333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("111-1111", "wrong Password", "Registered");

        assertNotEquals(authenticator.authenticateUser(userToAuthenticate), new User("Not a member", "No password", "Unregistered"));
    }

    @Test
    public void shouldNotAuthenticateAnUnregisteredUser() {
        User userOne = new User("111-1111", "password1", "Registered");
        User userTwo = new User("222-2222", "password2", "Registered");
        User userThree = new User("333-3333", "password3", "Registered");
        ArrayList<User> listOfRegisteredUsers = new ArrayList<>(Arrays.asList(userOne, userTwo, userThree));
        Authenticator authenticator = new Authenticator(listOfRegisteredUsers);
        User userToAuthenticate = new User("Not a member", "No password", "Unregistered");

        assertEquals(authenticator.authenticateUser(userToAuthenticate), new User("Not a Member", "No password", "Unregistered"));
    }
}