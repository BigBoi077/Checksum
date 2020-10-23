package cegepst;

import java.util.ArrayList;

public class CheckSum {

    public CheckSum() {
        Menu menu = new Menu();
        Encoder encoder = new Encoder(menu.askEntry());
        ArrayList<Block> blocks = encoder.encode();
        BlockDisruptor blockDisruptor = new BlockDisruptor(blocks);
        Decoder decoder = new Decoder(blocks);
        decoder.decode();
    }
}
