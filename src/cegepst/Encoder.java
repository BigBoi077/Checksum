package cegepst;

import java.util.ArrayList;

public class Encoder {

    private BlockManager blockManager;
    private BinaryConverter binaryConverter;
    private ParityCalculator parityCalculator;
    private ArrayList<Block> blocks;

    public String encode(String entry) {
        initialiseClasses(entry);
        giveParamsToClasses();
        binaryConverter.start(entry, blocks);
        Printer.printBlocks(blocks);
        return binaryConverter.getFullBinaryString();
    }

    private void giveParamsToClasses() {
        blockManager.giveParams(parityCalculator);
    }

    private void initialiseClasses(String entry) {
        blockManager = new BlockManager();
        binaryConverter = new BinaryConverter(blockManager);
        parityCalculator = new ParityCalculator();
        blocks = blockManager.initialiseBlocks(entry);
    }
}
