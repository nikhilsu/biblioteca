package com.thoughtworks.librarysys;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFromUser() {
        return scanner.nextLine();
    }
}
