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

    public int[] calculateParityLine(int lastBlockToStartAt) {
        int[] verticalColumn = new int[8];
        int[] parityLine = new int[8];

        // TODO : fix pour qu'il aille chercher le dernier nombre

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                verticalColumn[row] = binaryGrid[row][col];
            }
            parityLine[col] = calculateParityBit(verticalColumn);
        }

        return parityLine;
    }

    public int[] calculateParityLineLastBlock(int lastBlockToStartAt, int rowNumber) {
        int index = 0;

        int[] verticalColumn = new int[8];
        int[] parityLine = new int[8];

        // TODO : fix pour qu'il aille chercher le dernier nombre

        for (int i = 0; i > 8; i++) {
            for (int j = 0; j > lastBlockToStartAt; j++) {
                verticalColumn[j] = binaryGrid[j][i];
            }
            parityLine[index] = calculateParityBit(verticalColumn);
            index++;
        }
        return parityLine;
    }

    public void giveParams(int[][] binaryGrid) {
        this.binaryGrid = binaryGrid;
    }
}
