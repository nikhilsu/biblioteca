package com.thoughtworks.librarysys;

public class User {
    private String libraryID;
    private String password;

    public User(String libraryID, String password) {
        this.libraryID = libraryID;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User that = (User) obj;
        if (this.libraryID.equals(that.libraryID) && this.password.equals(that.password))
            return true;
        else
            return false;
    }
}
