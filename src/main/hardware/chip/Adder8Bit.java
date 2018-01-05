package main.hardware.chip;

import java.util.Arrays;

/**
 * Implements '8-bit ripple-carry adder'.
 *
 */
public class Adder8Bit extends Adder
{
    private Adder4Bit adder41;
    private Adder4Bit adder42;

    public Adder8Bit()
    {
        adder41 = new Adder4Bit();
        adder42 = new Adder4Bit();

        sum = new boolean[8];
    }

    private void add(boolean[] A, boolean[] B, boolean C)
    {
        adder41.in(
                Arrays.copyOfRange(A, 0, 3),
                Arrays.copyOfRange(B, 0,3),
                C
        );

        adder42.in(
                Arrays.copyOfRange(A,4, 7),
                Arrays.copyOfRange(B, 4, 7),
                adder41.outC()
        );

        // Merge the arrays
        boolean[] sum1 = adder41.outS();
        for (int i = 0; i < 4; i++) { sum[i] = sum1[i]; }

        boolean[] sum2 = adder42.outS();
        for (int i = 4; i < 8; i++) { sum[i] = sum1[i-4]; }

        carry = adder42.outC();
    }

    public void in(boolean[] A, boolean[] B) { add(A, B, false); }
    public void in(boolean[] A, boolean[] B, boolean carry) { add(A, B, carry); }
}
