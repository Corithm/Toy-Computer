package main.hardware.chip.elementary;

/**
 * DMux4Way implementation.
 *
 * The Elements of Computing Systems p. 25
 */
public class DMux4Way
{
    private DMux[] dmux = new DMux[3];

    private boolean[] out = new boolean[4];

    public DMux4Way()
    {
        for (int i = 0; i < dmux.length; i++)
        {
            dmux[i] = new DMux();
        }
    }

    /**
     * Sets the output value.
     * This is based on book's specification and therefore s[1] is used first.
     *
     * @param i input
     * @param s selector values, the largest index will be executed first
     */
    public void in(boolean i, boolean[] s)
    {
        dmux[0].in(i, s[1]);

        dmux[1].in(dmux[0].out(0), s[0]);
        out[0] = dmux[1].out(0);
        out[1] = dmux[1].out(1);

        dmux[2].in(dmux[1].out(1), s[0]);
        out[2] = dmux[2].out(0);
        out[3] = dmux[2].out(1);
    }

    /**
     * Returns the output value at chosen index.
     *
     * @param i index
     * @return the value of element at {a, b, c, d}
     */
    public boolean out(int i) { return out[i]; }
}
