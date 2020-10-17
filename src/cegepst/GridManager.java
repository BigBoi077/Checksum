package cegepst;

public class GridManager {

    private ParityCalculator parityCalculator;
    private int rowNumber;
    public int getGridHeight(String entry) {
        int strLength = entry.length();
        if (strLength <= 8) {
            return strLength + 1;
        }
        return (int) Math.ceil((double) strLength / 9) + strLength;
    }

    public void putInGrid(String binaryString, int[][] binaryGrid) {
        int[] parityArray = new int[8];

        if (rowNumber % 9 == 0 && rowNumber != 0) {
            parityCalculator.calculateParityLine(rowNumber);
            binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);
            rowNumber++;
            return;
        }

        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }

        binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);
        Console.printLine("Bit de parité : " + parityCalculator.calculateParityBit(parityArray));
        rowNumber++;
    }

    public void giveParams(int rowNumber, ParityCalculator parityCalculator) {
        this.rowNumber = rowNumber;
        this.parityCalculator = parityCalculator;
    }
}
