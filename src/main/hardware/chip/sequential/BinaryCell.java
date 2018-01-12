package main.hardware.chip.sequential;

import main.hardware.chip.combinational.DataFlipFlop;
import main.hardware.chip.elementary.MuxGate;

/**
 * Implements a '1-bit register'.
 *
 * <br>
 * Reference: The Elements of Computing Systems p. 43
 */
public class BinaryCell
{
    private boolean out;

    private MuxGate mux = new MuxGate();
    private DataFlipFlop dff = new DataFlipFlop();

    public void in(boolean a, boolean load)
    {
       mux.in(a, dff.out(), load);
       dff.in(mux.out());

       out = dff.out();
    }

    public boolean out() { return out; }
}
