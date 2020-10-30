package cegepst;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void choseProgram() {
        Console.printText("Would you like to Encode or Decode ? : ");
        int choice = askChoice();
        if (choice == 1) {
            Encoder encoder = new Encoder();
            encoder.encode(askEntry());
        } else {
            Decoder decoder = new Decoder();
            decoder.decode(askBinaryEntry());
        }
    }

    public int askChoice() {
        do {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("encode")) {
                return 1;
            }
            if (str.equalsIgnoreCase("decode")) {
                return 2;
            }
            Console.printLine("Answer must be Encode or Decode ...");
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
