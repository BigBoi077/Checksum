package cegepst;

public class Printer {
    public static void printGrid(int[][] binaryGrid) {
        Console.printLine("");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Console.printInt(binaryGrid[i][j]);
            }
            Console.printLine("");
        }
    }
}
