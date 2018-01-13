package main;

import javafx.stage.Stage;
import main.hardware.CPU;
import main.hardware.GPU;

/**
 * A 16-bit computer implementation.
 *
 */
public class Computer
{
    CPU cpu = new CPU();
    GPU gpu = new GPU();

    //RAM16K ram = new RAM16K();

    //ROM rom = new ROM();

    public void boot()
    {
        gpu.out();
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
