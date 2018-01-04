package main.gate;

/**
 * Implements 'NOT' -gate.
 *
 * == REFERENCE ==
 * @see <a href="https://en.wikipedia.org/wiki/NAND_logic#NOT">REFERENCE</a>
 */
public class NotGate
{
    private boolean out;

    /**
     * Sets an output value.
     *
     * @param a the input
     */
    public void in(boolean a) { out = !a; }

    public boolean out() { return out; }
}
