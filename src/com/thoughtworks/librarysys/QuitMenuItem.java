package com.thoughtworks.librarysys;

//quitMenuItem is a mainmenuitem that exits the application
public class QuitMenuItem extends MenuItem {

    @Override
    public void performOperation() {
        System.exit(0);
    }
}
