package main.hardware.chip.combinational;

import main.tool.Tools;

public class Inc16Bit
{
    private final Adder16Bit adder = new Adder16Bit();
    private final boolean[] ONE = Tools.toBinary(1);
    private boolean[] out = new boolean[16];

    public void input(boolean[] in) { adder.in(in, ONE); }

    public boolean[] output() { return out; }
}
