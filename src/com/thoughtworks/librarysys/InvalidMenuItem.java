package com.thoughtworks.librarysys;

//invalidmenuitem is a mainmenuitem that return "select a valic option!" string
public class InvalidMenuItem extends MenuItem {
    private String displayMessage;

    public InvalidMenuItem(String displayMessage){
        this.displayMessage = displayMessage + "\n";
    }

    @Override
    public String performOperation() {
        return this.toString();
    }

    @Override
    public String toString() {
        return displayMessage;
    }
}

