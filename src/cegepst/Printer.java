package cegepst;

public class Printer {
    public static void printGrid(int[][] binaryGrid, int gridHeight) {
        Console.printLine("");
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < 8; j++) {
                Console.printInt(binaryGrid[i][j]);
            }
            Console.printLine("");
        }
    }
}
