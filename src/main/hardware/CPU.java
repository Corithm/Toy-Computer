package main.hardware;

/**
 * CPU implementation.
 * The clock rate is not fixed and changes its value whenever necessary and possible.
 */
public class CPU
{
    private Clock clock = Clock.getInstance();

    public void run()
    {
        boolean on = true;
        while (on)
        {

            // Update the clock signal.
            clock.next();
        }
    }
}
