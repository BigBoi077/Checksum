package cegepst;

public class GridManager {

    private ParityCalculator parityCalculator;
    private int rowNumber;
    private int gridHeight;

    public void giveParams(int rowNumber, ParityCalculator parityCalculator) {
        this.rowNumber = rowNumber;
        this.parityCalculator = parityCalculator;
    }

    public int getGridHeight(String entry) {
        int strLength = entry.length();
        if (strLength <= 8) {
            this.gridHeight = strLength + 1;
            return strLength + 1;
        }
        this.gridHeight = (int) Math.ceil((double) strLength / 9) + strLength;
        return (int) Math.ceil((double) strLength / 9) + strLength;
    }

    public int getLastBlockToStartAt(int gridHeight) {
        double ratio = (double) gridHeight / 9;
        double decimals = getDecimals(ratio);
        return (int) (decimals * 9);
    }

    public double getDecimals(double number) {
        String numberD = String.valueOf(number);
        numberD = numberD.substring (numberD.indexOf ("."));
        return Double.parseDouble(numberD);
    }

    public boolean isLastLine(int rowNumber, int gridHeight) {
        return (rowNumber - gridHeight) == -1;
    }

    public boolean isLastBlock(int rowNumber, int gridHeight) {
        return (gridHeight - rowNumber) <= 8;
    }

    public void putInGrid(String binaryString, int[][] binaryGrid) {
        rowNumber++;
        int[] parityArray = new int[8];

        if (isLastLine(rowNumber, gridHeight)) {
            int[] parityLine = parityCalculator.calculateParityLineLastBlock(getLastBlockToStartAt(gridHeight), rowNumber);
            placeParityLine(parityLine, binaryGrid);
            return;
        }

        if (rowNumber % 8 == 0 && rowNumber != 0) {
            int[] parityLine = parityCalculator.calculateParityLine(rowNumber - 7);
            placeParityLine(parityLine, binaryGrid);
            binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityLine);
            return;
        }

        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }

        binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);
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
}
