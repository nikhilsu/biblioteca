package com.thoughtworks.librarysys;

import java.util.ArrayList;
//MainMenu has a list of items that is displayed on the screen
public class MainMenu {
    private ArrayList<String> listOfMenuItems;

    public MainMenu(ArrayList<String> listOfMenuItems) {
        this.listOfMenuItems = listOfMenuItems;
    }

    @Override
    public String toString() {
        String menu = "";
        for (String item : listOfMenuItems)
            menu += item + "\n";
        return menu;
    }
}
