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
    }

    @Test
    public void testToBinary() {
        assertEquals("01000011", encoder.toBinary('C'));
        assertEquals("01001010", encoder.toBinary('J'));
        assertEquals("00110001", encoder.toBinary('1'));
    }

    @Test
    public void calculateParityBit() {
        assertEquals(0, encoder.calculateParityBit(new int[]{0, 0, 0, 0, 0, 0, 0}));
        assertEquals(1, encoder.calculateParityBit(new int[]{0, 1, 0, 0, 0, 0, 0}));
        assertEquals(0, encoder.calculateParityBit(new int[]{0, 0, 1, 1, 0, 0, 0}));
    }
}
