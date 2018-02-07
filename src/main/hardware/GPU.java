package main.hardware;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import main.Screen;
import main.tool.Binary;
import main.tool.Tools;

/**
 * The book specifies a separate screen chip. But lets call it GPU for now.
 * This part is responsible for displaying pixels in the screen.
 *
 * The book specified a row of pixels (512 px) as 32 registers long. [32 * 16 = 512 px]
 */
public class GPU
{
    private Memory memory;
    private GraphicsContext gc;
    private PixelWriter writer;

    /**
     * Initialize a new GPU with memory.
     *
     * @param memory to read from
     */
    public GPU(Memory memory) { this.memory = memory; }

    /**
     * Reads every value from memory addresses [16_384, 24_576]
     * and draws their values to the screen.
     */
    public void refresh()
    {
        int y = 0;
        int x = 0;

        for (int address = 16384; address < 24576; address++)
        {
            Binary value = memory.out(address);
            if (value != null)
            {
                boolean[] seq = value.getSequence();

                for (int i = 0; i < 16; i++)
                {
                    if (seq[i])
                        writer.setColor(x, y, Color.GREEN);
                    else
                        writer.setColor(x, y, Color.BLACK);
                    x++;
                }
            }
            else
            {
                for (int i = 0; i < 16; i++)
                {
                    writer.setColor(x, y, Color.BLACK);
                    x++;
                }
            }

            if (x == 512) {
                x = 0;
                y++;
            }
        }
    }

    /**
     * Connects a screen with gpu.
     *
     * @param screen to connect
     */
    public void connect(Screen screen)
    {
        gc = screen.getGraphicsContext2D();
        writer = gc.getPixelWriter();
    }
}
