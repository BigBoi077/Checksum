package cegepst;

public class ParityVerifier {


    public boolean verify(int[] binaryArray, int parityBit) {
        int sum = 0;
        int wantedParityBit;
        for (int j : binaryArray) {
            sum += j;
        }
        if (sum % 2 == 0) {
            wantedParityBit = 0;
        }
        wantedParityBit = 1;
        return wantedParityBit == parityBit;
    }
}
