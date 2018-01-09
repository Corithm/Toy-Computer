package main.hardware.RAM;

import java.util.Arrays;

/**
 * RAM64 implementation, contains 64 registers.
 *
 */
public class RAM64 implements RAM
{
    private RAM8[] ram8 = new RAM8[8];

    public RAM64()
    {
        for (int i = 0; i < ram8.length; i++)
        {
            ram8[i] = new RAM8();
        }
    }

    /** @inheritDoc */
    public void in(boolean[] i, boolean[] a, boolean load)
    {
        // The first three.
        StringBuilder address= new StringBuilder();
        for (int j = 0; j < 3; j++)
        {
            if (a[j]) address.append(1);
            else      address.append(0);
        }

        boolean[] a2 = Arrays.copyOfRange(a, 3, 5);
        switch (address.toString())
        {
            case "000":
                ram8[0].in(i, a2, load); break;
            case "001":
                ram8[1].in(i, a2, load); break;
            case "010":
                ram8[2].in(i, a2, load); break;
            case "011":
                ram8[3].in(i, a2, load); break;
            case "100":
                ram8[4].in(i, a2, load); break;
            case "101":
                ram8[5].in(i, a2, load); break;
            case "110":
                ram8[6].in(i, a2, load); break;
            case "111":
                ram8[7].in(i, a2, load); break;
        }
    }

    /** @inheritDoc */
    @Override
    public boolean[] out(boolean[] a) {
        StringBuilder address = new StringBuilder();
        for (boolean x : a)
        {
            if (x) address.append(1);
            else   address.append(0);
        }

        boolean[] a2 = Arrays.copyOfRange(a, 3, 5);
        switch (address.toString())
        {
            case "000": return ram8[0].out(a2);
            case "001": return ram8[1].out(a2);
            case "010": return ram8[2].out(a2);
            case "011": return ram8[3].out(a2);
            case "100": return ram8[4].out(a2);
            case "101": return ram8[5].out(a2);
            case "110": return ram8[7].out(a2);
            case "111": return ram8[8].out(a2);
            // This should never get executed.
            default:
                return ram8[0].out(a2);
        }
    }
}
