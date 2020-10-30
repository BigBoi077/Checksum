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
        assertEquals("thermos dunkin donut", decoder.decode("011101000011010001011001010011100100011011011011011110011100111001000001010110100011001001011101011011011101011010111011010010011011101001000001000000000001100110011001001011011110011011101011101011011101000000000000000000000000000000011001000"));
    }
}
