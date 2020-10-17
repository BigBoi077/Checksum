package cegepst;

public class CheckSum {

    public CheckSum() {
        Menu menu = new Menu();
        new Encoder(menu.askEntry());
    }
}
