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
        int index = 0;

        int[] tempParityLine = new int[8];
        int[] parityLine = new int[8];

        // TODO : fix pour qu'il aille chercher le dernier nombre

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tempParityLine[j] = binaryGrid[j][i];
            }
            parityLine[index] = calculateParityBit(tempParityLine);
            index++;
        }
        return parityLine;
    }

    public int[] calculateParityLineLastBlock(int lastBlockToStartAt, int rowNumber) {
        int index = 0;

        int[] tempParityLine = new int[8];
        int[] parityLine = new int[8];

        // TODO : fix pour qu'il aille chercher le dernier nombre

        for (int i = 0; i > 8; i++) {
            for (int j = 0; j > lastBlockToStartAt; j++) {
                tempParityLine[j] = binaryGrid[j][i];
            }
            parityLine[index] = calculateParityBit(tempParityLine);
            index++;
        }
        return parityLine;
    }

    public void giveParams(int[][] binaryGrid) {
        this.binaryGrid = binaryGrid;
    }
}
