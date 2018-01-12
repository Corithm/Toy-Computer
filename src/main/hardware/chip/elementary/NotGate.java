package main.hardware.chip.elementary;

/**
 * Implements 'NOT' -gate.
 *
 * == REFERENCE ==
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#NOT">REFERENCE</a>
 */
public class NotGate
{
    private boolean out;
    private NandGate nand = new NandGate();

    /**
     * Sets the output value to true (NOT 0 = 1).
     */
    public NotGate() { out = true; }

    /**
     * Sets an output value.
     *
     * @param a the input
     */
    public void in(boolean a)
    {
        nand.in(a, a);
        out = nand.out();
    }

    public boolean out() { return out; }
}
