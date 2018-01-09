package main.hardware.RAM;

/**
 *
 * The Elements of Computing Systems p. 49
 */
public abstract class RAM
{
    protected boolean[] out;

    public abstract void in(boolean[] a,
                            boolean[] address,
                            boolean load);

    public boolean[] out() { return out; }
}
