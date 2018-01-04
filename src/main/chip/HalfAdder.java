package main.chip;

import main.gate.AndGate;
import main.gate.XorGate;

/**
 * Implements an half-adder with a 'xor' and a 'and' gates.
 *
 * == REFERENCES ==
 * (1) https://en.wikipedia.org/wiki/Adder_(electronics)#Half_adder
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

    public void in(boolean a, boolean b)
    {
        sum.in(a, b);
        carry.in(a, b);
    }

    public boolean outS() { return sum.out(); }
    public boolean outC() { return carry.out(); }
}
