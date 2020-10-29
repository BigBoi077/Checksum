package cegepst;

import java.util.ArrayList;

public class BlockManager {

    private ParityCalculator parityCalculator;
    private int rowNumber = -1;

    public void giveParams(ParityCalculator parityCalculator) {
        this.parityCalculator = parityCalculator;
    }

    public int getNbrOfBlocks(String entry) {
        return (int) Math.ceil((double)entry.length() / 8);
    }

    public void putInGrid(String binaryString, int[][] binaryGrid) {
        rowNumber++;
        int[] parityArray = new int[8];
        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }
        binaryGrid[rowNumber][8] = parityCalculator.calculateParityBit(parityArray);
    }

    public void placeParityLine(int[] parityLine, int[][] binaryGrid) {
        for (int i = 0; i < 9; i++ ) {
            binaryGrid[8][i] = parityLine[i];
        }
        rowNumber = -1;
    }

    public void placeBinaryBlock(ArrayList<Block> blocks, String binaryBlock) {
    }

    public ArrayList<Block> initialiseBlocks(String entry) {
        ArrayList<Block> blocks = new ArrayList<>();
        int nbrBlock = getNbrOfBlocks(entry);
        for (int i = 0; i < nbrBlock; i++) {
            Block block = new Block();
            blocks.add(block);
        }
        return blocks;
    }

    public String getFullBinaryString(ArrayList<Block> blocks) {
        String fullBinaryString = "";
        int nbrBlocks = blocks.size();
        for (int blockIndex = 0; blockIndex < nbrBlocks; blockIndex++) {
            int[][] currentBinaryGrid = blocks.get(blockIndex).getBinaryGrid();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    fullBinaryString += currentBinaryGrid[row][col];
                }
            }
        }
        return fullBinaryString;
    }
}
