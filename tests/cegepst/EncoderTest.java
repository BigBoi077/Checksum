package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncoderTest {
    private Encoder encoder;

    public EncoderTest() {
        this.encoder = new Encoder("");
    }

    @Test
    public void testGetGridHeight() {
        assertEquals(6, encoder.getGridHeight("joshua"));
        assertEquals(18, encoder.getGridHeight("bonjour le monde"));
        assertEquals(10, encoder.getGridHeight("El Blanco"));
        assertEquals(27, encoder.getGridHeight("Une planche de huit pied"));
    }

    @Test
    public void testToBinary() {
        assertEquals("01000011", encoder.toBinary('C'));
        assertEquals("01001010", encoder.toBinary('J'));
        assertEquals("00110001", encoder.toBinary('1'));
        assertEquals("00100000", encoder.toBinary(' '));
        assertEquals("01100010", encoder.toBinary('b'));
        assertEquals("01101111", encoder.toBinary('o'));
        assertEquals("01101110", encoder.toBinary('n'));
        assertEquals("01101100", encoder.toBinary('l'));
        assertEquals("01101010", encoder.toBinary('j'));
    }

    @Test
    public void calculateParityBit() {
        assertEquals(0, encoder.calculateParityBit(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        assertEquals(1, encoder.calculateParityBit(new int[]{0, 1, 0, 0, 0, 0, 0, 0}));
        assertEquals(0, encoder.calculateParityBit(new int[]{0, 0, 1, 1, 0, 0, 0, 0}));
        assertEquals(1, encoder.calculateParityBit(new int[]{1, 0, 1, 1, 0, 0, 0, 0}));
        assertEquals(0, encoder.calculateParityBit(new int[]{0, 0, 1, 1, 0, 0, 1, 1}));
    }
}
