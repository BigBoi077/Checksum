package cegepst;

public class Printer {
    public static void printGrid(int[][] binaryGrid, int gridHeight) {
        Console.printLine("");
        for (int i = 1; i < gridHeight; i++) {
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
}
