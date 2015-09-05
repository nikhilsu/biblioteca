package com.thoughtworks.librarysys;

import java.util.ArrayList;

public class MainMenu {
    ArrayList<String> listOfMenuItems;

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
