package cegepst;

import java.util.ArrayList;

public class BlockFixer {
    public void repairBrokenBytes(Block block, ArrayList<Integer> rowErrors, ArrayList<Integer> colErrors) {
        int nbrErrors = rowErrors.size();
        for (int i = 0; i < nbrErrors; i++) {
            switchByte(block.getBinaryGrid(),rowErrors.get(i), colErrors.get(i));
        }
    }

    // TODO : fix the byte switch looks like their inverted

    private void switchByte(int[][] binaryGrid, int row, int col) {
        Console.printLine("Repaired : " + row + " | " + col);
        int gridByte = binaryGrid[row][col];
        binaryGrid[row][col] = gridByte == 1 ? 0 : 1;
    }
}
