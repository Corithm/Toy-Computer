package main.hardware.gate;

/**
 * Implements 'AND'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#AND">REFERENCE</a>
 */
public class AndGate extends Gate
{
    private NandGate nand;
    private NotGate not;

    public AndGate()
    {
        nand = new NandGate();
        not  = new NotGate();
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand.in(a, b);
        not.in(nand.out());

        out = not.out();
    }
}
