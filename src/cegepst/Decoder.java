package cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Integer> rowErrors;
    private ArrayList<Integer> colErrors;
    private ArrayList<Block> blocks;
    private GridScanner gridScanner;
    private BlockFixer blockFixer;
    private BlockManager blockManager;
    private String decodedString;

    public Decoder() {
        gridScanner = new GridScanner();
        blockFixer = new BlockFixer();
        blockManager = new BlockManager();
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

    public String decode(String binaryString) {
        decodedString = "";
        blocks = blockManager.placeBinaryBlock(blocks, binaryString);
        int nbrBlocks = blocks.size();
        for (int i = 0; i < nbrBlocks; i++) {
            scanForErrors(i);
            if (isGridError()) {
                throwGridError();
            }
            blockFixer.repairBrokenBytes(blocks.get(i), rowErrors, colErrors);
            decodeGrid(blocks.get(i).getBinaryGrid());
        }
        Console.printLine(decodedString);
        return decodedString;
    }

    private void scanForErrors(int i) {
        initialiseErrorLists();
        gridScanner.scanRows(blocks.get(i).getBinaryGrid(), rowErrors);
        gridScanner.scanCols(blocks.get(i).getBinaryGrid(), colErrors);
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
        if (binaryString.equals("00000000")) {
            return "";
        }
        return String.valueOf(getChar(binaryString));
    }

    private void throwGridError() {
        Console.printLine("There was a irreversible mistake sorry...");
        System.exit(1);
    }
}
