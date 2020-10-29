package cegepst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertEquals("Q", decoder.getChar("01010001"));
    }

    @Test
    public void decodingTest() {
        assertEquals("&", decoder.decode("001001101000000000000000000000000000000000000000000000000000000000000000001001100"));
        assertEquals("joshua", decoder.decode("011010100011011110011100111011010001011101011011000011000000000000000000000010100"));
    }
}
