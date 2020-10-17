package cegepst;

public class Encoder {

    private int[][] binaryGrid;
    private final int gridHeight;
    private final int GRID_WIDTH = 9;
    private int rowNumber = 0;

    // TODO : placer les public en haut OU DANS DES CLASSES UTILITAIRES

    public Encoder(String entry) {
        this.gridHeight = getGridHeight(entry);
        initialiseGrid();
        convertToBinary(entry);
        Printer.printGrid(binaryGrid);
    }

    public int calculateParityBit(int[] parityArray) {
        int sum = 0;
        for (int j : parityArray) {
            sum += j;
        }
        if (sum % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public String toBinary(char currentChar) {
        String result = Integer.toBinaryString(currentChar);
        if (result.length() <= 7 && result.charAt(0) == '1') {
            int zerosToAdd = 8 - result.length();
            for (int i = 0; i < zerosToAdd; i++) {
                result = "0" + result;
            }
            return result;
        }
        return result;
    }

    public int getGridHeight(String entry) {
        int strLength = entry.length();
        if (strLength <= 8) {
            return strLength;
        }
        return (int) Math.ceil((double) strLength / 9) + strLength;
    }

    private void convertToBinary(String entry) {
        int strLength = entry.length();
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));

            Console.printLine(binaryString);

            putInGrid(binaryString);
        }
    }

    private void putInGrid(String binaryString) {
        int[] parityArray = new int[8];

        if (rowNumber % 9 == 0 && rowNumber != 0) {
            calculateParityLine();
            binaryGrid[rowNumber][9] = calculateParityBit(parityArray);
            rowNumber++;
            return;
        }

        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            binaryGrid[rowNumber][i] = binaryString.charAt(i);
        }

        binaryGrid[rowNumber][8] = calculateParityBit(parityArray);
        rowNumber++;
    }

    public void calculateParityLine() {
        int lastRowToStartAt = rowNumber - 8;
        int endOfRow = lastRowToStartAt + 7;
        int[] parityLine = new int[9];
        for (int i = lastRowToStartAt; i < endOfRow; i++) {
            for (int j = 0; j < 8; i++) {
                parityLine[i] = binaryGrid[j][i];
            }
            binaryGrid[rowNumber][i] = calculateParityBit(parityLine);
        }
    }

    private void initialiseGrid() {
        this.binaryGrid = new int[this.gridHeight][this.GRID_WIDTH];
    }
}
