package main.hardware.chip.elementary;

/**
 * Implements 'NAND'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#NAND">REFERENCE</a>
 */
public class NandGate extends Gate
{
    /**
     * Sets the default output value to true (0 NAND 0 = 1).
     */
    public NandGate() { out = true; }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b) { out = !(a && b); }
}
