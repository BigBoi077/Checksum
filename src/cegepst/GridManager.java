package cegepst;

public class GridManager {

    private ParityCalculator parityCalculator;
    private int rowNumber = -1;

    public void giveParams(ParityCalculator parityCalculator) {
        this.parityCalculator = parityCalculator;
    }

    public int getNbrOfBlocks(String entry) {
        return (int) (Math.ceil((double)entry.length() / 8) + 1);
    }

    public void putInGrid(String binaryString, int[][] binaryGrid) {
        rowNumber++;

        int[] parityArray = new int[8];

        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }

        binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);
        Console.printLine(String.valueOf(binaryGrid[rowNumber][8]));
    }

    public void placeParityLine(int[] parityLine, int[][] binaryGrid) {
        Console.printLine("");
        Console.printLine("Parity line: ");
        Console.printText("    ");
        for (int i = 0; i < 9; i++ ) {
            binaryGrid[8][i] = parityLine[i];
            Console.printText(String.valueOf((binaryGrid[8][i])));
        }
        Console.printLine("");
        Console.printLine("");
        rowNumber = -1;
    }
}
