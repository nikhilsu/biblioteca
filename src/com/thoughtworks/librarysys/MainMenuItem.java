package com.thoughtworks.librarysys;

import java.util.ArrayList;
//MainMenuItem has a list of items that is displayed on the screen
public class MainMenuItem {
    private ArrayList<String> listOfMenuItems;

    public MainMenuItem() {
    }

    public MainMenuItem(ArrayList<String> listOfMenuItems) {
        this.listOfMenuItems = listOfMenuItems;
    }

    public String performOperation() {
        return this.toString();
    }

    @Override
    public String toString() {
        String menu = "";
        for (String item : listOfMenuItems)
            menu += item + "\n";
        return menu;
    }
}