package main.hardware.chip.elementary;

/**
 * Implements 'XOR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#XOR">REFERENCE</a>
 */
public class XorGate extends Gate
{
    private NandGate[] nand = new NandGate[4];

    /**
     * Sets the output value to false (0 XOR 0 = 0)
     */
    public XorGate()
    {
        for (int i = 0; i < 4; i++) { nand[i] = new NandGate(); }
        out = false;
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand[1].in(a, b);
        nand[2].in(a, nand[1].out());
        nand[3].in(nand[1].out(), b);
        nand[4].in(nand[2].out(), nand[3].out());

        out = nand[4].out();
    }
}
