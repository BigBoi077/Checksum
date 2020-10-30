package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityVerifierTest {

    private ParityVerifier parityVerifier;

    public ParityVerifierTest() {
        this.parityVerifier = new ParityVerifier();
    }

    @Test
    public void testVerification() {
        assertEquals(false, parityVerifier.verify(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 1));
        assertEquals(true, parityVerifier.verify(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0));
        assertEquals(false, parityVerifier.verify(new int[]{0, 1, 0, 1, 0, 0, 0, 0}, 1));
        assertEquals(true, parityVerifier.verify(new int[]{1, 1, 0, 0, 0, 0, 1, 0}, 1));
        assertEquals(false, parityVerifier.verify(new int[]{1, 1, 1, 0, 1, 0, 0, 0}, 1));
    }
}
