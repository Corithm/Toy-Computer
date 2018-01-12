package main.hardware.chip.elementary;

/**
 * Implemens 'OR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#OR">REFRENCE</a>
 */
public class OrGate extends Gate
{
    private NandGate[] nand = new NandGate[3];

    /**
     * Sets the output value to false (0 OR 0 = 0)
     */
    public OrGate()
    {
        for (int i = 0; i < 3; i++) { nand[i] = new NandGate(); }
        out = false;
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand[1].in(a, a);
        nand[2].in(b, b);
        nand[3].in(nand[1].out(), nand[2].out());

        out = nand[3].out();
    }
}
