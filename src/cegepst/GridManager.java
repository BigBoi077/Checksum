package cegepst;

public class GridManager {

    private ParityCalculator parityCalculator;
    private int rowNumber;
    private int gridHeight;

    public int getGridHeight(String entry) {
        int strLength = entry.length();
        if (strLength <= 8) {
            this.gridHeight = strLength + 1;
            return strLength + 1;
        }
        this.gridHeight = (int) Math.ceil((double) strLength / 9) + strLength;
        return (int) Math.ceil((double) strLength / 9) + strLength;
    }

    public void putInGrid(String binaryString, int[][] binaryGrid) {
        int[] parityArray = new int[8];

        if (rowNumber % 7 == 0 && rowNumber != 0) {
            rowNumber++;
            int[] parityLine = parityCalculator.calculateParityLine(rowNumber);

            placeParityLine(parityLine, binaryGrid);

            binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityLine);

            rowNumber++;
            return;
        }

        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }

        binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);

        rowNumber++;
    }

    private void placeParityLine(int[] parityLine, int[][] binaryGrid) {
        Console.printLine("Parity line " + rowNumber + " : ");
        Console.printText("    ");
        for (int i = 0; i < 8; i++ ) {
            binaryGrid[rowNumber][i] = parityLine[i];
            Console.printText(String.valueOf((binaryGrid[rowNumber][i])));
        }
        Console.printLine("");
        Console.printLine("");
    }

    public void giveParams(int rowNumber, ParityCalculator parityCalculator) {
        this.rowNumber = rowNumber;
        this.parityCalculator = parityCalculator;
    }
}
