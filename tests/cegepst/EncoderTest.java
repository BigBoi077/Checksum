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
}
