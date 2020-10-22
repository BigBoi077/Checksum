package cegepst;

import java.util.ArrayList;

public class BinaryConverter {

    private GridManager gridManager;

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
            if (i % 7 == 0 && i != 0) {
                // TODO : mettre le calculate parity line ici ?
                blockIndex++;
            }
        }
        Printer.printBlocks(blocks);
    }
}
