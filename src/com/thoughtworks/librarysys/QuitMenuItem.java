package com.thoughtworks.librarysys;

//quitMenuItem is a mainmenuitem that exits the application
public class QuitMenuItem extends MainMenuItem {

    @Override
    public String performOperation() {
        System.exit(0);
        return this.toString();
    }

    @Override
    public String toString() {
        return "Exiting Application";
    }
}
