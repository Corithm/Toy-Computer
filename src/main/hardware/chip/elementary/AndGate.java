package main.hardware.chip.elementary;

/**
 * Implements 'AND'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#AND">REFERENCE</a>
 */
public class AndGate extends Gate
{
    private NandGate nand = new NandGate();
    private NotGate not = new NotGate();

    /**
     * Sets an initial output value to false (0 AND 0 = 0).
     */
    public AndGate() { out = false; }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand.in(a, b);
        not.in(nand.out());

        out = not.out();
    }
}
