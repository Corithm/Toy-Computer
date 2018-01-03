package main.gate;

/**
 * Implements a not -gate with nand -gate.
 *
 * Output values: 0 xor 1.
 */
public class NotGate extends Gate
{
    private NandGate nand;

    public NotGate() { nand = new NandGate(); }

    /**
     * Sets an output value.
     *
     * @param a the input value.
     */
    public void in(boolean a) {
        nand.in(a, a);
        out = nand.out();
    }
}
