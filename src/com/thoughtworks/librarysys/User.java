package com.thoughtworks.librarysys;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String libraryID;
    private String password;
    private String role;


    public User(String name, String email, String phoneNumber, String libraryID, String password, String role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s",libraryID, name, email, phoneNumber);
    }
}
