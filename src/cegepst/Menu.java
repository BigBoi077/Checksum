package cegepst;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void askChoice() {
        Console.printText("Would you like to (Encode : 1 or Decode : 2) ? : ");
        int choice = askOneOrTwo();
        if (choice == 1) {
            Encoder encoder = new Encoder();
            encoder.encode(askEntry());
        } else {
            Decoder decoder = new Decoder();
            decoder.decode(askBinaryEntry());
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

    private String askEntry() {
        Console.printText("Please enter a string of characters : ");
        return scanner.nextLine();
    }

    private String askBinaryEntry() {
        Console.printText("Please enter a string of characters : ");
        return scanner.next();
    }
}
