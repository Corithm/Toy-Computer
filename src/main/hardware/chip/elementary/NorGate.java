package main.hardware.chip.elementary;

/**
 * Implements a 'NOR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#NOR">REFERENCE</a>
 */
public class NorGate extends Gate
{
    private NotGate not = new NotGate();
    private OrGate or = new OrGate();

    /**
     * Sets the output value to true (0 NOR 0 = 1).
     */
    public NorGate() { out = true; }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        or.in(a, b);
        not.in(or.out());

        out = not.out();
    }
}
