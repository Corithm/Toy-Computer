package main.gate;

/**
 * Implements an and -gate with nand and not gates.
 */
public class AndGate extends Gate {
    private NandGate nand;
    private NotGate not;

    public AndGate()
    {
        nand = new NandGate();
        not  = new NotGate();
    }

    /**
     * Sets an input value.
     *
     * @param a the first value.
     * @param b the second value.
     */
    public void in(boolean a, boolean b) {
        nand.in(a, b);
        not.in(nand.out());

        out = not.out();
    }
}
