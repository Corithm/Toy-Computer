package main.hardware;

import main.hardware.chip.combinational.ALU;
import main.hardware.chip.elementary.Mux16Bit;
import main.hardware.chip.sequential.PC;
import main.hardware.chip.sequential.Register;

import java.util.Arrays;

/**
 * CPU implementation.
 */
public class CPU
{
    private Mux16Bit mux1 = new Mux16Bit();
    private Mux16Bit mux2 = new Mux16Bit();
    private Register registerA = new Register();
    private Register registerD = new Register();

    private ALU alu = new ALU();
    private PC address = new PC();

    // Control bits
    private boolean iBit;
    private boolean aBit;
    private boolean[] cBit;
    private boolean[] dBit;
    private boolean[] jBit;

    /**
     *
     * @param inM
     * @param instruction
     * @param reset
     */
    public void input(boolean[] inM, boolean[] instruction, boolean reset)
    {
        decode(instruction);

        if (!iBit)
        {
            registerA.in(instruction, true);
            address.input(null, true, false, reset);
        }
        else {
            mux1.input(instruction, alu.out(), iBit);
            registerA.in(mux1.output(), !iBit || dBit[0]);

            mux2.input(registerA.out(), inM, !(iBit && aBit));

            alu.in(registerD.out(), mux2.output(), cBit);
            registerD.in(alu.out(), dBit[1]);

            address.input(
                    registerA.out(),
                    true,
                    jBit[0] && jBit[1] && jBit[2],
                    reset
            );
        }
    }

    /* Output Results */
    public boolean[] outM() { return alu.out(); }
    public boolean writeM() { return !iBit == dBit[2];}
    public boolean[] addressM() { return registerA.out(); }
    public boolean[] addressI() { return address.output(); }


    private void decode(boolean[] in)
    {
        iBit = in[0];
        aBit = in[3];
        cBit = Arrays.copyOfRange(in, 4, 9);
        dBit = Arrays.copyOfRange(in, 10, 12);
        jBit = Arrays.copyOfRange(in, 13, 15);
    }
}