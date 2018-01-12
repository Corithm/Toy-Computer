package main.hardware;

/**
 * A master clock that keeps the rhythm.
 */
public class Clock
{
    private static Clock instance = new Clock();
    private boolean signal;

    public static Clock getInstance() { return instance; }

    /**
     * Changes the signal's value to its complement.
     */
    public void next() { signal = !signal; }

    public boolean out() { return signal; }

    private Clock() { }
}