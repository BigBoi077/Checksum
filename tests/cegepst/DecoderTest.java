package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoderTest {

    private Decoder decoder;

    public DecoderTest() {
        decoder = new Decoder();
    }

    @Test
    public void getCharTest() {
        assertEquals("c", decoder.getChar("01100011"));
        assertEquals("j", decoder.getChar("01101010"));
        assertEquals("&", decoder.getChar("00100110"));
    }
}
