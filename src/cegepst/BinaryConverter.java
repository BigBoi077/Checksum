package cegepst;

public class BinaryConverter {

    private GridManager gridManager;

    public BinaryConverter(GridManager gridManager) {
        this.gridManager = gridManager;
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

    public void convertToBinary(String entry, int[][] binaryGrid) {
        int strLength = entry.length();
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));

            Console.printLine(binaryString);

            gridManager.putInGrid(binaryString, binaryGrid);
        }
    }
}
