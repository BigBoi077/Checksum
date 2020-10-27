package cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Integer> rowErrors;
    private ArrayList<Integer> colErrors;
    private GridScanner gridScanner;
    private String decodedString = "";

    public Decoder() {
        gridScanner = new GridScanner();
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
            if (!isGridError()) {
                throwGridError();
            }
            decodeGrid(blocks.get(i).getBinaryGrid());
            // TODO : fix les broken bytes
        }
        return decodedString;
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
