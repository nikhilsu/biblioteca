package com.thoughtworks.librarysys;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ConsoleInputTest {

    @Test
    public void shouldReturnTheInputTakenFromTheUser() {
        ByteArrayInputStream input = new ByteArrayInputStream("Input from user".getBytes());
        Scanner scanner = new Scanner(input);
        ConsoleInput consoleInput = new ConsoleInput(scanner);

        String testString = "Input from user";

        assertEquals(testString, consoleInput.inputFromUser());
    }

}