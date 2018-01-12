package main.hardware.chip.combinational;

/**
 * Implements a '16-bit adder'.
 *
 */
public class Adder16Bit extends Adder
{
    private FullAdder[] fas;

    public Adder16Bit()
    {
        fas = new FullAdder[16];
        for (int i = 0; i < 16; i++) { fas[i] = new FullAdder(); }

        sum = new boolean[16];
    }

    private void add(boolean[] A, boolean[] B, boolean C)
    {
        for (int i = 0; i < 16; i++)
        {
            fas[i].in(A[i], B[i], C);
            sum[i] = fas[i].outS();
            C = fas[i].outC();
        }
    }

    public void in(boolean[] A, boolean[] B) { add(A, B, false); }

}
