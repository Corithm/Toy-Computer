package main.hardware.chip;

import main.hardware.gate.AndGate;
import main.hardware.gate.XorGate;

/**
 * Implements 'HALF-ADDER'.
 *
 * <a href="https://en.wikipedia.org/wiki/Adder_(electronics)#Half_adder">REFERENCE</a>
 */
public class HalfAdder
{
    private XorGate sum;
    private AndGate carry;

    public HalfAdder()
    {
        sum = new XorGate();
        carry = new AndGate();
    }

    /**
     * Sets output values.
     *
     * @param a the first input
     * @param b the second input
     */
    public void in(boolean a, boolean b)
    {
        sum.in(a, b);
        carry.in(a, b);
    }

    /**
     * Returns the sum value.
     *
     * @return sum of inputs
     */
    public boolean outS() { return sum.out(); }

    /**
     * Return the carry value.
     *
     * @return carry value
     */
    public boolean outC() { return carry.out(); }
}
