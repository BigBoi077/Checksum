package cegepst;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }
    public String askEntry() {
        Console.printText("Please enter a string of characters : ");
        return scanner.nextLine();
    }

    public void showDecodedString(String decodedString) {
        Console.printLine("The decoded string is : " + decodedString);
    }

    public void askChoice() {
        Console.printText("Would you like to (Encode : 1 or Decode : 2) ? : ");
        int choice = askOneOrTwo();
        if (choice == 1) {
            new Encoder(askEntry());
        } else {
            new Decoder(askEntry());
        }
    }

    public int askOneOrTwo() {
        do {
            String str = scanner.nextLine();
            if (str.equals("1")) {
                return 1;
            }
            if (str.equals("2")) {
                return 2;
            }
            Console.printLine("Answer must be 1 or 2 ...");
        } while (true);
    }
}
