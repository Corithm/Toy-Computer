package main.chip;

public abstract class Adder
{
    protected boolean[] sum;
    protected boolean carry;

    public boolean[] outS() { return sum; }

    /**
     * Returns the carry value.
     *
     * @return carry
     */
    public boolean outC() { return carry; }
}
