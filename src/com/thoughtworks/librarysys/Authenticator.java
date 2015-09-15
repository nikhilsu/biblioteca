package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> listOfRegisteredUsers;

    public Authenticator(ArrayList<User> listOfRegisteredUsers) {
        this.listOfRegisteredUsers = listOfRegisteredUsers;
    }

    public boolean authenticateUser(User userToAuthenticate) {
        return listOfRegisteredUsers.contains(userToAuthenticate);
    }
}
