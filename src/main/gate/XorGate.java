package main.gate;

/**
 * Implements an Xor gate with four nand gates.
 *
 * Output values: 0 1 1 0
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

    public void in(boolean a, boolean b)
    {
        nand1.in(a, b);
        nand2.in(a, nand1.out());
        nand3.in(nand1.out(), b);
        nand4.in(nand2.out(), nand3.out());

        out = nand4.out();
    }
}
