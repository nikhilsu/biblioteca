package com.thoughtworks.librarysys;

public class UserDetailMenuItem implements MenuOptions {
    private User user;
    private ConsoleView consoleView;

    public UserDetailMenuItem(User user, ConsoleView consoleView) {
        this.user = user;
        this.consoleView = consoleView;
    }


    @Override
    public void performOperation() {
        String [] tokensOfUserDetails = user.toString().split("\t");
        String userDetails = String.format("Name : %s\nE-mail : %s\nPhone No. : %s\n\n", tokensOfUserDetails[1], tokensOfUserDetails[2], tokensOfUserDetails[3]);
        consoleView.printOnConsole(userDetails);
    }
}
