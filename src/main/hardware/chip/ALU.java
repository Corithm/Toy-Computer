package main.hardware.chip;

import main.hardware.gate.AndGate;

/**
 * Implements an 'Aritmetic Logic Unit'.
 *
 * REFERENCE: The Elements of Computing Systems p. 35-39.
 */
public class ALU
{
    private boolean[] out;
    private boolean zero;
    private boolean negative;

    private AndGate and;
    private Adder16Bit adder16;

    public ALU()
    {
        and = new AndGate();
        adder16 = new Adder16Bit();

        out = new boolean[16];
    }

    /*
     * Sets output values.
     * @see The Elements of Computing Systems p. 37.
     *
     * @param X the first 16-bit input
     * @param Y the second 16-bit input
     * @param control bits {zx, nx, zy, ny, f, no}
     */
    public void in(boolean[] X, boolean[] Y, boolean[] C)
    {
        // Manipulating inputs.
        for (int i = 0; i < 16; i++)
        {
            // x to zero & not x
            if (C[0]) X[i] = false;
            if (C[1]) X[i] = !X[i];

            // y to zero & not y
            if (C[2]) Y[i] = false;
            if (C[3]) Y[i] = !Y[i];
        }

        // Selecting the function.
        if (C[4])
        {
            adder16.in(X, Y);
            out = adder16.outS();
        }
        else
        {
            for (int i = 0; i < 16; i++)
            {
                and.in(X[i], Y[i]);
                out[i] = and.out();
            }
        }

        // Not out
        if (C[5])
        {
            for (int i = 0; i < 16; i++) { out[i] = !out[i]; }
        }

        // TODO: implement out = 0
        // TODO: implement out < 0
    }

    public boolean[] out() { return out; }
}

