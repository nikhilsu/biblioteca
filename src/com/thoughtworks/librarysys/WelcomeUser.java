package com.thoughtworks.librarysys;

//Welcomes the user by printing out a message
public class WelcomeUser {
    private String welcomeMessage;

    public WelcomeUser(){
        welcomeMessage = "Welcome";
    }

    @Override
    public String toString() {
        return welcomeMessage;
    }
}
