package main.hardware.chip.register;

import main.hardware.gate.MuxGate;

/**
 * Register implementation.
 *
 * The Elements of Computing Systems p. 49
 */
public class Register
{
    private BinaryCell[] bit = new BinaryCell[16];
    private boolean[] out = new boolean[16];

    public Register(int bits)
    {
        for (int i = 0; i < bit.length; i++) { bit[i] = new BinaryCell(); }
    }

    /**
     * Sets the output value.
     *
     * @param a the input value
     * @param load the boolean value
     */
    public void in(boolean[] a, boolean load)
    {
        for (int i = 0; i < bit.length; i++)
        {
            bit[i].in(a[i], load);
            out[i] = bit[i].out();
        }
    }

    public boolean[] out() { return out; }
}
