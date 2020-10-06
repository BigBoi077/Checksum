package cegepst;

public class Encoder {

    private int[][] grid;
    private int gridHeight;
    private final int GRID_WIDTH = 9;
    private String entry;

    public Encoder(String entry) {
        this.entry = entry;
        this.gridHeight = getGridHeight(entry);
        initialseGrid();
    }

    private void initialseGrid() {
        this.grid = new int[this.gridHeight][this.GRID_WIDTH];
    }

    public int getGridHeight(String entry) {
        int height;
        int strLength = entry.length();
        if (strLength <= 8) { return strLength; }
        height = strLength / 8;
        return height + strLength;
    }
}
