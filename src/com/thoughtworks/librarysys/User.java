package com.thoughtworks.librarysys;

public class User {
    private String libraryID;
    private String password;
    private String role;

    public User(String libraryID, String password, String role) {
        this.libraryID = libraryID;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        User that = (User) obj;
        if (this.libraryID.equals(that.libraryID) && this.password.equals(that.password))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int result = libraryID.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
