package main;

import main.hardware.CPU;
import main.hardware.GPU;
import main.hardware.Memory;
import main.hardware.ROM32K;

/**
 * A 16-bit computer implementation.
 *
 */
public class Computer
{
    private ROM32K rom = new ROM32K();
    private CPU cpu = new CPU();
    private Memory memory = new Memory();

    // This is used for drawing to screen.
    private GPU gpu = new GPU(memory);

    public void boot()
    {
        gpu.refresh();
    }

    public void run()
    {
        boolean on = true;
        while (on)
        {
            /*cpu.input(
                    memory.out(cpu.addressM()),
                    rom.fetch(cpu.addressI()),
                    false
            );
            memory.input(
                    cpu.outM(),
                    cpu.writeM(),
                    cpu.addressM()
            );
            */
            // Refresh screen.
            gpu.refresh();
        }
    }

    public void shutDown()
    {

    }

    /**
     * Connects a computer to a display monitor.
     *
     * @param screen
     */
    public void connect(Screen screen) { gpu.connect(screen); }
}
