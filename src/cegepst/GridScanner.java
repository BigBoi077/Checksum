package cegepst;

import java.util.ArrayList;

public class GridScanner {

    private ParityVerifier verifier;

    public GridScanner() {
        verifier = new ParityVerifier();
    }

    public void scanRows(int[][] binaryGrid, ArrayList<Integer> rowErrors) {
        int[] binaryArray = new int[8];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 8; col++) {
                binaryArray[col] = binaryGrid[row][col];
            }
            int parityBit = binaryGrid[row][8];
            if (!verifier.verify(binaryArray, parityBit)) {
                rowErrors.add(row);
            }
        }
    }

    public void scanCols(int[][] binaryGrid, ArrayList<Integer> colErrors) {
        int[] binaryArray = new int[8];
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 8; row++) {
                binaryArray[row] = binaryGrid[row][col];
            }
            int parityBit = binaryGrid[8][col];
            if (!verifier.verify(binaryArray, parityBit)) {
                colErrors.add(col);
            }
        }
    }
}
