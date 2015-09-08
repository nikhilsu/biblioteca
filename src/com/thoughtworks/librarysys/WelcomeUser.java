package com.thoughtworks.librarysys;

//Welcomes the user by printing out a message
public class WelcomeUser {
    private String welcomeMessage;

    public WelcomeUser(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage + "\n";
    }

    @Override
    public String toString() {
        return welcomeMessage;
    }
}