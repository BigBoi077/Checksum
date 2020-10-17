package cegepst;

public class ParityCalculator {

    private int[][] binaryGrid;
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

    public void calculateParityLine(int rowNumber) {
        int lastRowToStartAt = rowNumber - 8;
        int endOfRow = lastRowToStartAt + 7;
        int[] parityLine = new int[9];
        for (int i = lastRowToStartAt; i < endOfRow; i++) {
            for (int j = 0; j < 8; j++) {
                parityLine[i] = binaryGrid[j][i];
            }
            binaryGrid[rowNumber][i] = calculateParityBit(parityLine);
        }
    }

    public void giveParams(int[][] binaryGrid) {
        this.binaryGrid = binaryGrid;
    }
}
