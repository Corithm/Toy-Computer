package main.hardware.chip.elementary;

/**
 * A gate supertype that every gates inherits.
 */
public abstract class Gate {
    protected boolean out;

    /**
     * Returns output as boolean value.
     *
     * @return output value
     */
    public boolean out() { return out; }

    /**
     * Sets an output value.
     *
     * @param a the first input
     * @param b the second input
     */
    public abstract void in(boolean a, boolean b);

}
