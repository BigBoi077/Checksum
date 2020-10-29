package cegepst;

import java.util.ArrayList;

public class Encoder {

    private BlockManager gridManager;
    private BinaryConverter binaryConverter;
    private ParityCalculator parityCalculator;
    private ArrayList<Block> blocks;
    private String entry;

    public Encoder(String entry) {
        this.entry = entry;
        encode();
    }

    public void encode() {
        initialiseClasses();
        initialiseBlocks(entry);
        giveParamsToClasses();
        binaryConverter.start(entry, blocks);
        Printer.printBlocks(blocks);
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
        binaryConverter.giveParams(parityCalculator);
    }

    private void initialiseClasses() {
        gridManager = new BlockManager();
        binaryConverter = new BinaryConverter(gridManager);
        parityCalculator = new ParityCalculator();
        blocks = new ArrayList<>();
    }
}
