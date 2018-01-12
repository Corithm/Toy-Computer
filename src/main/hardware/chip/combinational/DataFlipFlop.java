package main.hardware.chip.combinational;

import main.hardware.Clock;

/**
 * Data flip-flop implementation.
 *
 * The book treated this chip as primitive.
 */
public class DataFlipFlop
{
    private Clock clock;

    private boolean out = false;

    // I'll just follow a truth table i found online.
    // https://circuitdigest.com/electronic-circuits/d-flip-flops
    // TODO: Try master-slave when ram test is done.
    public void in(boolean D)
    {
        if (!clock.out())
        {
            out  = false;
        //  Qc = true;
        }
        else if (clock.out() && !D)
        {
            out = false;
        //  Qc = true;
        }
        else if (clock.out() && D)
        {
            out = true;
        //  Qc = false;
        }
    }

    public boolean out() { return out; }
}
