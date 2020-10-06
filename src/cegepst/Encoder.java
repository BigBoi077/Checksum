package cegepst;

public class Encoder {

    private int[][] binaryGrid;
    private int[] parityArray;
    private int gridHeight;
    private final int GRID_WIDTH = 9;
    private int rowNumber = 0;

    public Encoder(String entry) {
        this.gridHeight = getGridHeight(entry);
        initialiseGrid();
        convertToBinary(entry);
    }

    private void convertToBinary(String entry) {
        int strLength = entry.length();
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));
            putInGrid(binaryString, i);
        }
    }

    private void putInGrid(String binaryString, int index) {
        parityArray = new int[9];
        for (int i = 0; i < binaryString.length(); i++) {
            parityArray[i] = binaryString.charAt(i);
            this.binaryGrid[this.rowNumber][i] = binaryString.charAt(i);
        }
        this.binaryGrid[this.rowNumber][9] = calculateParityBit(parityArray);
        this.rowNumber++;
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
            return "0" + result;
        }
        return result;
    }

    private void initialiseGrid() {
        this.binaryGrid = new int[this.gridHeight][this.GRID_WIDTH];
    }

    public int getGridHeight(String entry) {
        int height;
        int strLength = entry.length();
        if (strLength <= 8) { return strLength; }
        height = strLength / 8;
        return height + strLength;
    }
}
