package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> listOfRegisteredUsers;

    public Authenticator(ArrayList<User> listOfRegisteredUsers) {
        this.listOfRegisteredUsers = listOfRegisteredUsers;
    }

    public User authenticateUser(User userToAuthenticate) {
        int indexOfRegisteredUserInTheList = listOfRegisteredUsers.indexOf(userToAuthenticate);
        if (indexOfRegisteredUserInTheList != -1)
            return listOfRegisteredUsers.get(indexOfRegisteredUserInTheList);
        else
            return new User("Not a Member", "No password", "Unregistered");
    }
}
