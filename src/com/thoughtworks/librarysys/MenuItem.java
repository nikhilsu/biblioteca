package com.thoughtworks.librarysys;

import java.util.ArrayList;

//MenuItem has a list of menu items which it returns as a string to be displayed
public class MenuItem {
    private ArrayList<String> listOfMenuItems;
    private ConsoleView consoleView;

    public MenuItem() {
    }

    public MenuItem(ArrayList<String> listOfMenuItems, ConsoleView consoleView) {
        this.listOfMenuItems = listOfMenuItems;
        this.consoleView = consoleView;
    }

    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        String menu = "";
        for (String item : listOfMenuItems)
            menu += item + "\n";
        return menu;
    }
}