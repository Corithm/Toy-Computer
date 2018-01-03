package main.gate;

/**
 * Implements a nor gate with a not and a or gate.
 *
 * Output values: 1 0 0 0
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

    public void in(boolean a, boolean b)
    {
        or.in(a, b);
        not.in(or.out());

        out = not.out();
    }
}
