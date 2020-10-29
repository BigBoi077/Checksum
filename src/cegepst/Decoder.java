package cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Integer> rowErrors;
    private ArrayList<Integer> colErrors;
    private ArrayList<Block> blocks;
    private GridScanner gridScanner;
    private BlockFixer blockFixer;
    private BlockManager blockManager;
    private String decodedString = "";

    public Decoder(String binaryBlock) {
        gridScanner = new GridScanner();
        blockFixer = new BlockFixer();
        blockManager.placeBinaryBlock(binaryBlock);
    }

    public void initialiseErrorLists() {
        rowErrors = new ArrayList<>();
        colErrors = new ArrayList<>();
    }

    public boolean isGridError() {
        return rowErrors.size() != colErrors.size();
    }

    public String getChar(String binaryString) {
        int charCode = Integer.parseInt(binaryString, 2);
        return String.valueOf((char)charCode);
    }

    public String decode(ArrayList<Block> blocks) {
        int nbrBlocks = blocks.size();
        for (int i = 0; i < nbrBlocks; i++) {
            initialiseErrorLists();
            gridScanner.scanRows(blocks.get(i).getBinaryGrid(), rowErrors);
            gridScanner.scanCols(blocks.get(i).getBinaryGrid(), colErrors);
            if (isGridError()) {
                throwGridError();
            }
            killLAstIndex();
            blockFixer.repairBrokenBytes(blocks.get(i), rowErrors, colErrors);
            decodeGrid(blocks.get(i).getBinaryGrid());
        }
        return decodedString;
    }

    private void killLAstIndex() {
        int lastIndex = rowErrors.size() - 1;
        if (lastIndex == -1) {
            return;
        }
        if (rowErrors.get(lastIndex) == 8 && colErrors.get(lastIndex) == 8) {
            rowErrors.remove(lastIndex);
            colErrors.remove(lastIndex);
        }
    }

    private void decodeGrid(int[][] binaryGrid) {
        for (int row = 0; row < 8; row++) {
            decodedString += decodeGridRow(binaryGrid, row);
        }
    }

    private String decodeGridRow(int[][] binaryGrid, int rowNumber) {
        String binaryString = "";
        for (int i = 0; i < 8; i++) {
            binaryString += binaryGrid[rowNumber][i];
        }
        return String.valueOf(getChar(binaryString));
    }

    private void throwGridError() {
        Console.printLine("There was a irreversible mistake sorry...");
        System.exit(1);
    }
}
