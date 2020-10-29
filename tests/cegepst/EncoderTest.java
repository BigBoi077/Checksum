package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncoderTest {

    private Encoder encoder;

    public EncoderTest() {
        this.encoder = new Encoder();
    }

    @Test
    public void testEncoding() {
        assertEquals("011010100011011110011100111011010001011101011011000011000000000000000000000010100",
                encoder.encode("joshua"));
        assertEquals("011011011011000011011100100011010010011011000011011110011101011001000001010000010011000101011101011011100111011100111011010010011001010011100100000000000011010010011001010011100111000000000000000000000000000000000000000000000000000000000101100",
                encoder.encode("marilou bussieres"));
        assertEquals("001001101000000000000000000000000000000000000000000000000000000000000000001001100",
                encoder.encode("&"));
    }
}
