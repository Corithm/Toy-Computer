package main.tool;

import main.hardware.chip.combinational.ALU;

/**
 * A class to represent a binary sequence.
 */
public class Binary
{
    private final int LENGTH = 16;
    private final boolean[] INCREMENT_CONTROL = Tools.toBinary("01 1111");
    private final boolean[] DECREMENT_CONTROL = Tools.toBinary("00 1110");

    public boolean[] sequence = new boolean[LENGTH];

    public Binary()
    {
        set("0000 0000 0000 0000");
    }

    public Binary(String sequence)
    {
        set(sequence);
    }

    public Binary(int integer)
    {
        set(Tools.toBinaryString(integer));
    }

    /**
     * Sets the string as binary.
     *
     * @param sequence
     */
    public final void set(String sequence)
    {
        sequence = sequence.trim();
        for (int i = 0; i < LENGTH; i++)
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