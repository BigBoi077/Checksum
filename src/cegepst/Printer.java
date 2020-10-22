package cegepst;

import java.util.ArrayList;

public class Printer {
    // TODO : Adjust printer
    public static void printBlock(int[][] binaryGrid) {
        Console.printLine("");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8) {
                    Console.printText(" Parity bit : " + binaryGrid[i][j]);
                } else {
                    Console.printInt(binaryGrid[i][j]);
                }
            }
            Console.printLine("");
        }
    }

    public static void printBinairyString(String binaryString, int i) {
        if (i <= 9) {
            Console.printText(i + " : " + binaryString);
        } else {
            Console.printText(i + ": " + binaryString);
        }
    }
}
