package main.hardware.gate;

/**
 * Demultiplexer implementation.
 *
 * Simplified from <a href="https://en.wikipedia.org/wiki/NAND_logic#DEMUX">REFERENCE</a>
 */
public class DMux
{
    private boolean[] out = new boolean[2];

    /**
     * Sets the output value.
     *
     * @param I input
     * @param S selector
     */
    public void in(boolean I, boolean S)
    {
        out[0] = (I && !S);
        out[1] = (I && S);
    }

    /**
     * Returns the boolean value from the array at specified index.
     *
     * @param i index
     * @return i = 0 returns the value from the first output and
     * i = 1 returns from the second one.
     */
    public boolean out(int i) { return out[i]; }
}
