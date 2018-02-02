package main.hardware.chip.sequential;

import main.hardware.chip.combinational.Inc16Bit;
import main.tool.Tools;

public class PC
{
    private Inc16Bit incrementer = new Inc16Bit();
    private boolean[] out = new boolean[16];


    public void input(boolean[] in, boolean inc, boolean load, boolean reset)
    {
        // Shortcut...
        if (reset)
        {
            out = Tools.toBinary(0);
        }
        else if (load)
        {
            out = in;
        }
        else if (inc)
        {
            incrementer.input(in);
            out = incrementer.output();
        }
    }

    public boolean[] output() { return out; }
}
