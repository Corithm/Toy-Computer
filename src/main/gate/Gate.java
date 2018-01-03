package main.gate;

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
}
