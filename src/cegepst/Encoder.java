package cegepst;

import java.util.ArrayList;

public class Encoder {

    private GridManager gridManager;
    private BinaryConverter binaryConverter;
    private ParityCalculator parityCalculator;
    private ArrayList<Block> blocks;

    public Encoder(String entry) {
        initialiseClasses();
        initialiseBlocks(entry);
        giveParamsToClasses();
        binaryConverter.convertToBinary(entry, blocks);
    }

    private void initialiseBlocks(String entry) {
        int nbrBlock = gridManager.getNbrOfBlocks(entry);
        for (int i = 0; i < nbrBlock; i++) {
            Block block = new Block();
            blocks.add(block);
        }
    }

    private void giveParamsToClasses() {
        gridManager.giveParams(parityCalculator);
    }

    private void initialiseClasses() {
        gridManager = new GridManager();
        binaryConverter = new BinaryConverter(gridManager);
        parityCalculator = new ParityCalculator();
        blocks = new ArrayList<>();
    }
}
