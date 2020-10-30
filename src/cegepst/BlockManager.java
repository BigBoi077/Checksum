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

    public int getNbrOfBlocksForString(String entry) {
        return entry.length() / 9 / 9;
    }

    public void placeParityLine(int[] parityLine, int[][] binaryGrid) {
        System.arraycopy(parityLine, 0, binaryGrid[8], 0, 9);
        rowNumber = -1;
    }

    public void manageParityLine(ArrayList<Block> blocks, int blockIndex) {
        int[][] binaryGrid = blocks.get(blockIndex).getBinaryGrid();
        int[] parityLine = parityCalculator.calculateParityLine(binaryGrid);
        placeParityLine(parityLine, binaryGrid);
        binaryGrid[8][8] = parityCalculator.calculateParityBit(parityLine);
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

    public ArrayList<Block> placeBinaryBlock(ArrayList<Block> blocks, String binaryBlock) {
        blocks = initialiseBlocksForString(binaryBlock);
        int index = 0;
        for (Block block : blocks) {
            int[][] currentBlock = block.getBinaryGrid();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    currentBlock[row][col] = Integer.parseInt(String.valueOf(binaryBlock.charAt(index)));
                    index++;
                }
            }
        }
        Printer.printBlocks(blocks);
        return blocks;
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

    public ArrayList<Block> initialiseBlocksForString(String entry) {
        ArrayList<Block> blocks = new ArrayList<>();
        int nbrBlock = getNbrOfBlocksForString(entry);
        for (int i = 0; i < nbrBlock; i++) {
            Block block = new Block();
            blocks.add(block);
        }
        return blocks;
    }

    public String getFullBinaryString(ArrayList<Block> blocks) {
        String fullBinaryString = "";
        for (Block block : blocks) {
            int[][] currentBinaryGrid = block.getBinaryGrid();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    fullBinaryString += currentBinaryGrid[row][col];
                }
            }
        }
        return fullBinaryString;
    }
}
