package cegepst;

public class ParityCalculator {

    public int calculateParityBit(int[] parityArray) {
        int sum = 0;
        for (int j : parityArray) {
            sum += j;
        }
        if (sum % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public int[] calculateParityLine(int[][] binaryGrid) {
        int[] verticalColumn = new int[8];
        int[] parityLine = new int[9];
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 8; row++) {
                verticalColumn[row] = binaryGrid[row][col];
            }
            parityLine[col] = calculateParityBit(verticalColumn);
        }
        return parityLine;
    }
}