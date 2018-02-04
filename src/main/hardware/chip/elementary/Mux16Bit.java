package main.hardware.chip.elementary;

public class Mux16Bit
{
    private boolean[] output = new boolean[16];

    public void input(boolean[] A, boolean[] B, boolean selector)
    {
        if (!selector) output = A; else output = B;
    }

    public boolean[] output() { return output; }
}
