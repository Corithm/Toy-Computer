package main.hardware.chip.elementary;

/**
 * Implements 'MUX'-gate.
 *
 * <a href="https://en.wikipedia.org/wiki/NAND_logic#MUX">REFERENCE</a>
 */
public class MuxGate
{
    private AndGate[] and = new AndGate[2];
    private NotGate not   = new NotGate();
    private OrGate or     = new OrGate();

    private boolean out;

    public MuxGate()
    {
        for (int i = 0; i < and.length; i++) { and[i] = new AndGate(); }
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
        and[1].in(a, not.out());
        and[2].in(b, s);

        or.in(and[1].out(), and[2].out());
        out = or.out();
    }

    public boolean out() { return out; }
}
