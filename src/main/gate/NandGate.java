package main.gate;

/**
 * Primitive gate, that is used for building other gates.
 *
 * Output values: 1 | 1 | 1 | 0
 */
public class NandGate extends Gate
{
    /**
     * Sets an output value.
     *
     * @param a the first input
     * @param b the second input
     */
    public void in(boolean a, boolean b) { out = !(a && b); }
}
