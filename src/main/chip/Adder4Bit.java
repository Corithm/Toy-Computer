package main.chip;

/**
 * Implements '4-bit adder'.
 *
 * <a href="https://en.wikipedia.org/wiki/Adder_(electronics)#Adders_supporting_multiple_bits">REFERENCE</a>
 */
public class Adder4Bit extends Adder
{
    private FullAdder fa0;
    private FullAdder fa1;
    private FullAdder fa2;
    private FullAdder fa3;

    public Adder4Bit()
    {
        fa0 = new FullAdder();
        fa1 = new FullAdder();
        fa2 = new FullAdder();
        fa3 = new FullAdder();

        sum = new boolean[4];
    }

    private void add(boolean[] A, boolean[] B, boolean C)
    {
        fa0.in(A[0], B[0], C);
        sum[0] = fa0.outS();

        fa1.in(A[1], B[1], C);
        sum[1] = fa1.outS();

        fa2.in(A[2], B[2], fa1.outC());
        sum[2] = fa2.outS();

        fa3.in(A[3], B[3], fa2.outC());
        sum[3] = fa3.outS();

        carry = fa3.outC();
    }

    /**
     * Ripple carry adder.
     *
     * @param A
     * @param B
     */
    public void in(boolean[] A, boolean[] B) { add(A, B, false); }

    /**
     * Carry-lookahead adder.
     *
     * @param A
     * @param B
     * @param carry
     */
    public void in(boolean[] A, boolean[] B, boolean carry) { add(A, B, carry); }
}
