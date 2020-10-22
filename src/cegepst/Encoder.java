package cegepst;

import java.util.ArrayList;

public class Encoder {

    private GridManager gridManager;
    private BinaryConverter binaryConverter;
    private ParityCalculator parityCalculator;
    private ArrayList<Block> blocks;
    private String entry;

    public Encoder(String entry) {
        this.entry = entry;
    }

    public ArrayList<Block> encode() {
        initialiseClasses();
        initialiseBlocks(entry);
        giveParamsToClasses();
        binaryConverter.start(entry, blocks);
        return blocks;
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
