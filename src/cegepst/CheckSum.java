package cegepst;

import java.util.ArrayList;

public class CheckSum {

    public CheckSum() {
        Menu menu = new Menu();
        Encoder encoder = new Encoder(menu.askEntry());
        ArrayList<Block> blocks = encoder.encode();
        // TODO : switch numbers in the grid
        Decoder decoder = new Decoder(blocks);
        decoder.decode();
    }
}
