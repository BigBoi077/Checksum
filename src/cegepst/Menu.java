package cegepst;

import java.util.Scanner;

public class Menu {
    public String askEntry() {
        Scanner scanner = new Scanner(System.in);
        Console.printText("Please enter a string of characters : ");
        return scanner.nextLine();
    }

    public void showDecodedString(String decodedString) {
        Console.printLine("The decoded string is : " + decodedString);
    }
}
