package cegepst;

public class Block {

    private int[][] binaryGrid;

    public Block() {
        binaryGrid = new int[9][9];
        initialiseBlock();
    }

    public int[][] getBinaryGrid() {
        return binaryGrid;
    }

    private void initialiseBlock() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                binaryGrid[row][col] = 0;
            }
        }
    }
}
