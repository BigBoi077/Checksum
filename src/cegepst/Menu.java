package cegepst;

import java.util.Scanner;

public class Menu {
    public String askEntry() {
        Scanner scanner = new Scanner(System.in);
        String entry;
        Console.printText("Please enter a string of characters : ");
        entry = scanner.next();
        return entry;
    }
}
