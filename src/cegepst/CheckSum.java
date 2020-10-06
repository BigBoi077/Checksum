package cegepst;

public class CheckSum {

    private String entry;

    public CheckSum() {
        Menu menu = new Menu();
        this.entry = menu.askEntry();
        Encoder encoder = new Encoder(entry);
    }
}
