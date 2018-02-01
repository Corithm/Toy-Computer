package main.tool;

import main.hardware.chip.combinational.ALU;

/**
 * A class to represent a binary sequence.
 */
public class Binary
{
    private final int WIDTH = 16;
    private final boolean[] INCREMENT_CONTROL = { false, true, true, true, true, true };
    private final boolean[] DECREMENT_CONTROL = { false, false, true, true, true, false };

    public boolean[] sequence = new boolean[WIDTH];

    public Binary(String sequence) {
        set(sequence);
    }

    public Binary(int integer) {
        set(Tools.toBinaryString(integer));
    }

    /**
     * Sets the string as binary.
     *
     * @param sequence
     */
    public final void set(String sequence)
    {
        for (int i = 0; i < WIDTH; i++)
        {
            this.sequence[i] = (sequence.charAt(i) == 1);
        }
    }

    public final void decrement() {
        Tools.alu.in(sequence, null, DECREMENT_CONTROL);
    }

    public final void increment() {
        Tools.alu.in(sequence, null, INCREMENT_CONTROL);
    }
}