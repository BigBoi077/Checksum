package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryConverterTest {

    private BinaryConverter binaryConverter;

    public BinaryConverterTest() {
        BlockManager gridManager = new BlockManager();
        this.binaryConverter = new BinaryConverter(gridManager);
    }

    @Test
    public void testToBinary() {
        assertEquals("01000011", binaryConverter.toBinary('C'));
        assertEquals("01001010", binaryConverter.toBinary('J'));
        assertEquals("00110001", binaryConverter.toBinary('1'));
        assertEquals("00100000", binaryConverter.toBinary(' '));
        assertEquals("01100010", binaryConverter.toBinary('b'));
        assertEquals("01101111", binaryConverter.toBinary('o'));
        assertEquals("01101110", binaryConverter.toBinary('n'));
        assertEquals("01101100", binaryConverter.toBinary('l'));
        assertEquals("01101010", binaryConverter.toBinary('j'));
        assertEquals("00111100", binaryConverter.toBinary('<'));
    }
}
