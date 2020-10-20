package cegepst;

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

    public void convertToBinary(String entry, int[][] binaryGrid) {
        int strLength = entry.length();
        String binaryString;
        for (int i = 0; i < strLength; i++) {
            binaryString = toBinary(entry.charAt(i));

            if (i <= 9) {
                Console.printLine(i + " : " + binaryString);
            } else {
                Console.printLine(i + ": " + binaryString);
            }
            gridManager.putInGrid(binaryString, binaryGrid);
        }
    }
}
