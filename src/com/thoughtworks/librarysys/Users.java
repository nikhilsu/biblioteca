package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> listOfRegisteredUsers;

    public Users(ArrayList<User> listOfRegisteredUsers) {
        this.listOfRegisteredUsers = listOfRegisteredUsers;
    }

    public User authenticate(String libraryID, String password) {
        User userToAuthenticate = new User(libraryID, password, "Not Known");
        int indexOfRegisteredUserInTheList = listOfRegisteredUsers.indexOf(userToAuthenticate);
        if (indexOfRegisteredUserInTheList != -1)
            return listOfRegisteredUsers.get(indexOfRegisteredUserInTheList);
        else
            return new User("Not a Member", "No password", "Unregistered");
    }
}
