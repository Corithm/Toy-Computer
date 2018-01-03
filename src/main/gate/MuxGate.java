package main.gate;

public class MuxGate
{
    private AndGate and1;
    private AndGate and2;
    private NotGate not;
    private OrGate or;

    public MuxGate()
    {
        and1 = new AndGate();
        and2 = new AndGate();
        not  = new NotGate();
        or   = new OrGate();
    }

    /**
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
    }
}
