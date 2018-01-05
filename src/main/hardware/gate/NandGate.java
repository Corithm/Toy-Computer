package main.hardware.gate;

/**
 * Implements 'NAND'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#NAND">REFERENCE</a>
 */
public class NandGate extends Gate
{
    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b) { out = !(a && b); }
}
