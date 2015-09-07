package com.thoughtworks.librarysys;

import java.util.Scanner;
//Console input return the input from the user
public class ConsoleInput {
    private Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFromUser() {
        return scanner.nextLine();
    }
}
