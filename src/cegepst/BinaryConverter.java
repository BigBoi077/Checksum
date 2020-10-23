package cegepst;

import java.util.ArrayList;

public class BinaryConverter {

    private GridManager gridManager;
    private ParityCalculator parityCalculator;

    public BinaryConverter(GridManager gridManager) {
        this.gridManager = gridManager;
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

    private boolean isToShort(String result) {
        return (result.length() <= 7 && result.charAt(0) == '1');
    }

    public void start(String entry, ArrayList<Block> blocks) {
        int strLength = entry.length();
        int blockIndex = 0;
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));
            Printer.printBinairyString(binaryString, i);
            gridManager.putInGrid(binaryString, blocks.get(blockIndex).getBinaryGrid());
            if (i != 0) {
                if ((i % 7 == 0) || isEnd(i, strLength)) {
                    // TODO : mettre le calculate parity line ici ?
                    int[][] binaryGrid = blocks.get(blockIndex).getBinaryGrid();
                    int[] parityLine = parityCalculator.calculateParityLine(binaryGrid);
                    gridManager.placeParityLine(parityLine, binaryGrid);
                    binaryGrid[8][8] = parityCalculator.calculateParityBit(parityLine);
                    blockIndex++;
                }
            }
        }
        Printer.printBlocks(blocks);
    }

    private boolean isEnd(int i, int strLength) {
        return i + 1 == strLength;
    }

    public void giveParams(ParityCalculator parityCalculator) {
        this.parityCalculator = parityCalculator;
    }
}
