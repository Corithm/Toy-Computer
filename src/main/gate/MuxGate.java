package main.gate;

/**
 * Implements 'MUX'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#MUX">REFERENCE</a>
 */
public class MuxGate
{
    private AndGate and1;
    private AndGate and2;
    private NotGate not;
    private OrGate or;

    private boolean out;

    public MuxGate()
    {
        and1 = new AndGate();
        and2 = new AndGate();
        not  = new NotGate();
        or   = new OrGate();
    }

    /**
     * Sets an output value.
     *
     * @param a the first input
     * @param b the second input
     * @param s the selector
     */
    public void in(boolean a, boolean b, boolean s)
    {
        not.in(s);
        and1.in(a, not.out());
        and2.in(b, s);

        or.in(and1.out(), and2.out());
        out = or.out();
    }

    public boolean out() { return out; }
}
