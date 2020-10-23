package cegepst;

import java.util.ArrayList;

public class Printer {
    // TODO : Adjust printer
    public static void printBlocks(ArrayList<Block> blocks) {
        int nbrBlocks = blocks.size();
        for (int blockIndex = 0; blockIndex < nbrBlocks; blockIndex++) {
            int[][] currentBinaryGrid = blocks.get(blockIndex).getBinaryGrid();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (col == 8) {
                        Console.printText(" Parity bit : " + currentBinaryGrid[row][col]);
                    } else {
                        Console.printInt(currentBinaryGrid[row][col]);
                    }
                }
                Console.printLine("");
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
