package main.hardware.chip.sequential.RAM;

import main.tool.Binary;

import java.util.Arrays;

public class RAM4K implements RAM
{
    private RAM512[] ram512 = new RAM512[8];

    public RAM4K()
    {
        for (int i = 0; i < ram512.length; i++)
        {
            ram512[i] = new RAM512();
        }
    }

    /** @inheritDoc */
    public void in(boolean[] i, boolean[] a, boolean load)
    {
        // The first three.
        StringBuilder address = new StringBuilder();
        for (int j = 0; j < 3; j++)
        {
            if (a[j]) address.append(1);
            else      address.append(0);
        }

        boolean[] a2 = Arrays.copyOfRange(a, 3, 11);
        switch (address.toString())
        {
            case "000":
                ram512[0].in(i, a2, load); break;
            case "001":
                ram512[1].in(i, a2, load); break;
            case "010":
                ram512[2].in(i, a2, load); break;
            case "011":
                ram512[3].in(i, a2, load); break;
            case "100":
                ram512[4].in(i, a2, load); break;
            case "101":
                ram512[5].in(i, a2, load); break;
            case "110":
                ram512[6].in(i, a2, load); break;
            case "111":
                ram512[7].in(i, a2, load); break;
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

        boolean[] a2 = Arrays.copyOfRange(a, 3, 11);
        switch (address.toString())
        {
            case "000": return ram512[0].out(a2);
            case "001": return ram512[1].out(a2);
            case "010": return ram512[2].out(a2);
            case "011": return ram512[3].out(a2);
            case "100": return ram512[4].out(a2);
            case "101": return ram512[5].out(a2);
            case "110": return ram512[7].out(a2);
            case "111": return ram512[8].out(a2);
            // This should never get executed.
            default:
                return ram512[0].out(a2);
        }
    }
}
