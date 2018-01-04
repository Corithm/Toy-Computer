package main.chip;

import java.util.Arrays;

/**
 * Implements a '16-bit adder'.
 *
 */
public class Adder16Bit extends Adder
{
    private Adder8Bit adder81;
    private Adder8Bit adder82;

    public Adder16Bit()
    {
        adder81 = new Adder8Bit();
        adder82 = new Adder8Bit();

        sum = new boolean[16];
    }

    private void add(boolean[] A, boolean[] B, boolean C)
    {
        adder81.in(
                Arrays.copyOfRange(A, 0, 7),
                Arrays.copyOfRange(B, 0, 7),
                C
        );

        adder82.in(
                Arrays.copyOfRange(A, 8, 15),
                Arrays.copyOfRange(B, 8, 15),
                adder81.outC()
        );


        // NOTE: If the computer feels slow, this may be the issue.

        // Merge the arrays.
        boolean[] sum1 = adder81.outS();
        for (int i = 0; i < 8; i++) { sum[i] = sum1[i]; }

        boolean[] sum2 = adder82.outS();
        for (int i = 8; i < 16; i++) { sum[i] = sum2[i-8]; }
    }

    public void in(boolean[] A, boolean[] B) { add(A, B, false); }

}
