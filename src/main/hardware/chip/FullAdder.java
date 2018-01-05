package main.hardware.chip;

import main.hardware.gate.AndGate;
import main.hardware.gate.OrGate;
import main.hardware.gate.XorGate;

/**
 * Implements 'FULL-ADDER'.
 *
 * <a href="https://en.wikipedia.org/wiki/Adder_(electronics)#Full_adder">REFERENCE</a>
 */
public class FullAdder
{
    private XorGate xor1;
    private XorGate xor2;
    private AndGate and1;
    private AndGate and2;
    private OrGate or;

    private boolean sum;
    private boolean carry;

    public FullAdder()
    {
        xor1 = new XorGate();
        xor2 = new XorGate();
        and1 = new AndGate();
        and2 = new AndGate();
        or = new OrGate();
    }

    public void in(boolean a, boolean b, boolean c)
    {
        xor1.in(a, b);
        xor2.in(xor1.out(), c);

        and1.in(xor1.out(), c);
        and2.in(a, b);
        or.in(and1.out(), and2.out());

        sum = xor2.out();
        carry = or.out();
    }

    public boolean outS() { return sum; }
    public boolean outC() { return carry; }
}
