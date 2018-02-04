package main.hardware.chip.sequential;

/**
 * Implements a '1-bit register'.
 *
 * Reference: The Elements of Computing Systems p. 43
 */
public class BinaryCell
{
    private boolean out;

    public void in(boolean a, boolean load)
    {
        if (load) out = a;
    }

    public boolean out() { return out; }
}
