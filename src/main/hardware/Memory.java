package main.hardware;

import java.util.Hashtable;

public class Memory
{
    // SHORTCUT: Using hashtable instead of ram16k + ram8k + register
    private Hashtable<String, boolean[]> memory = new Hashtable<>();

    /**
     * Writes data to memory.
     * 0 - 16 383: RAM16K
     * 16 384 - 24 575: Screen Memory Map 8K
     * 24576: Keyboard memory map
     *
     * @param data to write
     * @param address for data
     */
    public void input(String address, boolean[] data, boolean load) {
        if (load) memory.put(address, data);
    }

    /**
     * Returns the value in the address.
     *
     * @param address the address where information is
     * @return value in the address
     */
    public boolean[] out(String address) { return memory.get(address); }
}
