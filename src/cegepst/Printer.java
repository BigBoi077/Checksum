package cegepst;

public class Printer {
    public static void printGrid(int[][] binaryGrid) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; i++) {
                Console.printText(String.valueOf(binaryGrid[i][j]));
            }
            Console.printLine("");
        }
    }
}
