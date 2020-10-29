package cegepst;

import java.util.ArrayList;

public class BinaryConverter {

    private BlockManager blockManager;
    private ParityCalculator parityCalculator;
    private String fullBinaryString;
    private int blockIndex = 0;

    public BinaryConverter(BlockManager gridManager) {
        this.blockManager = gridManager;
    }

    public String toBinary(char currentChar) {
        String result = Integer.toBinaryString(currentChar);
        if (isToShort(result)) {
            for (int i = 0; i < 9 - result.length(); i++) {
                result = "0" + result;
            }
            return result;
        }
        return result;
    }

    public void giveParams(ParityCalculator parityCalculator) {
        this.parityCalculator = parityCalculator;
    }

    public String getFullBinaryString() {
        return fullBinaryString;
    }

    public void start(String entry, ArrayList<Block> blocks) {
        int strLength = entry.length();
        for (int i = 0; i < strLength; i++) {
            blockManager.putInGrid(toBinary(entry.charAt(i)), blocks.get(blockIndex).getBinaryGrid());
            if (strLength == 1) {
                manageParityLine(blocks);
                blockIndex++;
            }
            if ((isBeforeLastLine(i) || isEnd(i, strLength)) && i != 0) {
                manageParityLine(blocks);
                blockIndex++;
            }
        }
        fullBinaryString = blockManager.getFullBinaryString(blocks);
        Console.printLine(fullBinaryString);
    }

    private boolean isBeforeLastLine(int i) {
        return (i % 7 == 0);
    }

    private void manageParityLine(ArrayList<Block> blocks) {
        int[][] binaryGrid = blocks.get(blockIndex).getBinaryGrid();
        int[] parityLine = parityCalculator.calculateParityLine(binaryGrid);
        blockManager.placeParityLine(parityLine, binaryGrid);
        binaryGrid[8][8] = parityCalculator.calculateParityBit(parityLine);
    }

    private boolean isEnd(int i, int strLength) {
        return i + 1 == strLength;
    }

    private boolean isToShort(String result) {
        return (result.length() <= 7 && result.charAt(0) == '1');
    }
}
