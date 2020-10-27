package cegepst;

import java.util.ArrayList;

public class CheckSum {

    private ArrayList<Block> blocks;

    public CheckSum() {
        Menu menu = new Menu();
        Encoder encoder = new Encoder(menu.askEntry());
        blocks = encoder.encode();
        new BlockDisruptor(blocks);
        Decoder decoder = new Decoder();
        menu.showDecodedString(decoder.decode(blocks));
    }
}
