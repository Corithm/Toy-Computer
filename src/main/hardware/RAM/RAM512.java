package main.hardware.RAM;

import java.util.Arrays;

public class RAM512 implements RAM
{
    private RAM64[] ram64 = new RAM64[8];

    public RAM512()
    {
        for (int i = 0; i < ram64.length; i++)
        {
            ram64[i] = new RAM64();
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

        boolean[] a2 = Arrays.copyOfRange(a, 3, 8);
        switch (address.toString())
        {
            case "000":
                ram64[0].in(i, a2, load); break;
            case "001":
                ram64[1].in(i, a2, load); break;
            case "010":
                ram64[2].in(i, a2, load); break;
            case "011":
                ram64[3].in(i, a2, load); break;
            case "100":
                ram64[4].in(i, a2, load); break;
            case "101":
                ram64[5].in(i, a2, load); break;
            case "110":
                ram64[6].in(i, a2, load); break;
            case "111":
                ram64[7].in(i, a2, load); break;
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

        boolean[] a2 = Arrays.copyOfRange(a, 3, 8);
        switch (address.toString())
        {
            case "000": return ram64[0].out(a2);
            case "001": return ram64[1].out(a2);
            case "010": return ram64[2].out(a2);
            case "011": return ram64[3].out(a2);
            case "100": return ram64[4].out(a2);
            case "101": return ram64[5].out(a2);
            case "110": return ram64[7].out(a2);
            case "111": return ram64[8].out(a2);
            // This should never get executed.
            default:
                return ram64[0].out(a2);
        }
    }
}
