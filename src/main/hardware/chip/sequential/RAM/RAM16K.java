package main.hardware.chip.sequential.RAM;

import java.util.Arrays;

public class RAM16K
{
    private RAM4K[] ram4k = new RAM4K[4];

    public RAM16K()
    {
        for (int i = 0; i < ram4k.length; i++)
        {
            ram4k[i] = new RAM4K();
        }
    }

    /** @inheritDoc */
    public void in(boolean[] i, boolean[] a, boolean load)
    {
        // The first two
        StringBuilder address= new StringBuilder();
        for (int j = 0; j < 2; j++)
        {
            if (a[j]) address.append(1);
            else      address.append(0);
        }

        boolean[] a2 = Arrays.copyOfRange(a, 2, 13);
        switch (address.toString())
        {
            case "00":
                ram4k[0].in(i, a2, load); break;
            case "01":
                ram4k[1].in(i, a2, load); break;
            case "10":
                ram4k[2].in(i, a2, load); break;
            case "11":
                ram4k[3].in(i, a2, load); break;
        }
    }

    /** @inheritDoc */
    public boolean[] out(boolean[] a) {
        StringBuilder address = new StringBuilder();
        for (boolean x : a)
        {
            if (x) address.append(1);
            else   address.append(0);
        }

        boolean[] a2 = Arrays.copyOfRange(a, 2, 13);
        switch (address.toString())
        {
            case "00": return ram4k[0].out(a2);
            case "01": return ram4k[1].out(a2);
            case "10": return ram4k[2].out(a2);
            case "11": return ram4k[3].out(a2);
            // This should never get executed.
            default:
                return ram4k[0].out(a2);
        }
    }
}
