package main.hardware;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import main.Screen;
import main.tool.Tools;


/**
 * The book specifies a separate screen chip. But lets call it GPU for now.
 * This part is responsible for displaying pixels in the screen.
 *
 * The book specified a row of pixels (512 px) as 32 registers long. [32 * 16 = 512 px]
 */
public class GPU
{
    // Only access to 16 384 - 24575.
    // 00100 0000 0000 0000 to 0101 1111 1111 1111
    private Memory memory;

    private GraphicsContext gc;
    private PixelWriter writer;

    public GPU(Memory memory) { this.memory = memory; }
    /**
     * Reads every value from ram and draws them to the screen.
     */
    public void refresh()
    {
        int y = 0;
        int x = 0;

        for (int i = 16384; i < 24576; i++)
        {
            boolean[] slice = memory.out(Tools.toBinaryString(i));

            if (slice != null)
            {
                for (int j = 0; j < 16; j++)
                {
                    if (slice[j])
                        writer.setColor(x, y, Color.GREEN);
                    else
                        writer.setColor(x, y, Color.BLACK);
                    x++;
                }
            }
            else
            {
                for (int j = 0; j < 16; j++)
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
