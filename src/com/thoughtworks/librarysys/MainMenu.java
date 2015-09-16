package com.thoughtworks.librarysys;

import java.util.ArrayList;

//MainMenu has a list of menu items which it returns as a string to be displayed
public class MainMenu {
    private ArrayList<String> listOfMenuItems;
    private ConsoleView consoleView;

    public MainMenu(ArrayList<String> listOfMenuItems, ConsoleView consoleView) {
        this.listOfMenuItems = listOfMenuItems;
        this.consoleView = consoleView;
    }

    public void performOperation() {
        consoleView.printOnConsole(this.toString());
    }

    @Override
    public String toString() {
        String menu = "----------Menu----------\n";
        for (String item : listOfMenuItems)
            menu += item + "\n";
        return menu + "Enter your choice : ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass())
            return false;
        MainMenu that = (MainMenu) obj;
        if (this.listOfMenuItems.equals(that.listOfMenuItems))
            return true;
        else
            return false;
    }
}