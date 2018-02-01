package main.software.vm;

import main.hardware.chip.sequential.RAM.RAM16K;
import main.tool.Binary;

/**
 * Stack implementation that uses the virtual system RAM.
 *
 * Addresses 256-2047 are allocated to this stack.
 */
public class Stack
{
    private final Binary LOWER_LIMIT = new Binary(257);
    private final Binary UPPER_LIMIT = new Binary(2048);
    private final RAM16K RAM = new RAM16K();

    private Binary index = new Binary(256);

    /**
     * Push an item to the stack.
     * Only the pointers are pushed.
     *
     * @param item as binary sequence
     */
    public void push(Binary item)
    {
        if (index.equals(UPPER_LIMIT)) {
            // Throw an exception
        }
        else
        {
            RAM.in(item.sequence, index.sequence, true);
            index.increment();
        }
    }

    public boolean[] pop()
    {
        boolean[] result = RAM.out(index.sequence);
        index.decrement();

        return result;
    }
}
