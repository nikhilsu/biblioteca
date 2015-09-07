package com.thoughtworks.librarysys;

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

