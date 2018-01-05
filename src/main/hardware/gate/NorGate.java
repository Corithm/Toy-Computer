package main.hardware.gate;

/**
 * Implements a 'NOR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#NOR">REFERENCE</a>
 */
public class NorGate extends Gate
{
    private NotGate not;
    private OrGate or;

    public NorGate()
    {
        not = new NotGate();
        or  = new OrGate();
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        or.in(a, b);
        not.in(or.out());

        out = not.out();
    }
}
