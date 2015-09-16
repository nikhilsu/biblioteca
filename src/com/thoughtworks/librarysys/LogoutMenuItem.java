package com.thoughtworks.librarysys;

import com.thoughtworks.librarysys.MenuOptions;

public class LogoutMenuItem implements MenuOptions {
    private User user;

    @Override
    public void performOperation() {
        this.user = new User("Not a member", "Not known", "Guest");
    }

    public User getUser() {
        return user;
    }
}
