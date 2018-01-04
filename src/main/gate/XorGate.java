package main.gate;

/**
 * Implements 'XOR'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#XOR">REFERENCE</a>
 */
public class XorGate extends Gate
{
    private NandGate nand1;
    private NandGate nand2;
    private NandGate nand3;
    private NandGate nand4;

    public XorGate()
    {
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        nand4 = new NandGate();
    }

    /** @inheritDoc */
    @Override
    public void in(boolean a, boolean b)
    {
        nand1.in(a, b);
        nand2.in(a, nand1.out());
        nand3.in(nand1.out(), b);
        nand4.in(nand2.out(), nand3.out());

        out = nand4.out();
    }
}
