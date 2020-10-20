package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityCalculatorTest {

    private ParityCalculator parityCalculator;

    public ParityCalculatorTest() {
        this.parityCalculator = new ParityCalculator();
    }

    @Test
    public void calculateParityBit() {
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{1, 1, 0, 1, 0, 0, 0, 1}));
        assertEquals(1, parityCalculator.calculateParityBit(new int[]{0, 1, 0, 0, 0, 0, 0, 0}));
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{0, 0, 1, 1, 0, 0, 0, 0}));
        assertEquals(1, parityCalculator.calculateParityBit(new int[]{1, 0, 0, 0, 0, 0}));
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{0, 0, 1, 1, 0, 0, 1, 1}));
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{0, 1, 1, 1, 1, 1, 1, 0}));
        assertEquals(0, parityCalculator.calculateParityBit(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(1, parityCalculator.calculateParityBit(new int[]{1, 1, 1}));
    }
}
