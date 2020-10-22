package cegepst;

public class Block {

    private int[][] binaryGrid;

    public Block() {
        binaryGrid = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                binaryGrid[row][col] = 0;
            }
        }
    }

    public int[][] getBinaryGrid() {
        return binaryGrid;
    }
}
