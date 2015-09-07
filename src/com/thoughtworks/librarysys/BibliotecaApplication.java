package com.thoughtworks.librarysys;

import java.util.Scanner;

public class BibliotecaApplication {
    WelcomeUser welcomeUser;
    MainMenu mainMenu;

    public BibliotecaApplication(WelcomeUser welcomeUser, MainMenu mainMenu) {
        this.welcomeUser = welcomeUser;
        this.mainMenu = mainMenu;
    }

    public void run() {
        new ConsoleDisplay(welcomeUser.toString()).displayOnScreen();
        new ConsoleDisplay(mainMenu.toString()).displayOnScreen();
    }
}
