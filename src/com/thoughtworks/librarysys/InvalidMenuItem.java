package com.thoughtworks.librarysys;

//invalidmenuitem is a mainmenuitem that return "select a valic option!" string
public class InvalidMenuItem extends MainMenuItem {

    @Override
    public String performOperation() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Select a valid option!\n";
    }
}

