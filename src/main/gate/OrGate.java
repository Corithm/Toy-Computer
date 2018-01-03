package main.gate;

/**
 * Implemens or gate with three nand gates.
 *
 * Output values: 0 0 0 1.
 */
public class OrGate extends Gate
{
    private NandGate nand1;
    private NandGate nand2;
    private NandGate nand;

    public OrGate()
    {
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand = new NandGate();
    }

    /**
     * Sets an output value.
     *
     * @param a
     * @param b
     */
    public void in(boolean a, boolean b)
    {
        nand1.in(a, a);
        nand2.in(b, b);
        nand.in(nand1.out(), nand2.out());

        out = nand.out();
    }
}
