package cegepst;

import java.awt.*;

public class Encoder {

    private GridManager gridManager;
    private BinaryConverter binaryConverter;
    private ParityCalculator parityCalculator;
    private int[][] binaryGrid;
    private final int GRID_WIDTH = 9;
    private int gridHeight;
    private int rowNumber = 0;

    public Encoder(String entry) {
        initialiseClasses();
        initialiseGrid(entry);

        parityCalculator.giveParams(binaryGrid);

        binaryConverter.convertToBinary(entry, binaryGrid);

        Printer.printGrid(binaryGrid);
    }

    private void initialiseClasses() {
        gridManager = new GridManager();
        binaryConverter = new BinaryConverter(gridManager);
        parityCalculator = new ParityCalculator();
        gridManager.giveParams(rowNumber, parityCalculator);
    }

    private void initialiseGrid(String entry) {
        this.gridHeight = gridManager.getGridHeight(entry);
        this.binaryGrid = new int[this.gridHeight][this.GRID_WIDTH];
    }
}
