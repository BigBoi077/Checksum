package cegepst;

import java.util.ArrayList;
import java.util.Random;

public class BlockDisruptor {

    private Random random;

    public BlockDisruptor(ArrayList<Block> blocks) {
        this.random = new Random();
        int nbrBlocks = blocks.size();
        for (int i = 0; i < nbrBlocks; i++) {
            switchRandomByte(blocks.get(i).getBinaryGrid());
        }
        Printer.printBlocks(blocks);
    }

    private void switchRandomByte(int[][] binaryGrid) {
        int nbrBytesToChange = random.nextInt(5);
        for (int i = 0; i < nbrBytesToChange; i++) {
            int randomRow = random.nextInt(10);
            int randomCol = random.nextInt(10);
            if (binaryGrid[randomRow][randomCol] == 1) {
                binaryGrid[randomRow][randomCol] = 0;
            } else {
                binaryGrid[randomRow][randomCol] = 1;
            }
        }
    }
}
