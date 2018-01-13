package main.hardware;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import main.Screen;


/**
 * The book specifies a separate screen chip. But lets call it GPU for now.
 * This part is responsible for displaying pixels in the screen.
 *
 * The book specified a row of pixels (512 px) as 32 registers long. [32 * 16 = 512 px]
 */
public class GPU
{
    // SHORTCUT normally would use RAM8K, but the reading method wouldn't feel efficient
    private boolean[][][] ram = new boolean[256][32][];

    private GraphicsContext gc;
    private PixelWriter writer;

    /**
     * Reads every value from ram and draws them to the screen.
     */
    public void out()
    {
        for (int y = 0; y < ram[0].length; y++)
        {
            for (int x = 0; x < ram[0][0].length; x++)
            {
                for (int z = 0; z < ram.length; z++)
                {
                    if (ram[y][x][z])
                        writer.setColor(y, x, Color.BLACK);
                    else
                        writer.setColor(y, x, Color.WHITE);
                }
            }
        }
    }

    /**
     * Sets an array of pixels to gpu memory.
     */
    public void in(boolean[] A, int x, int y) { ram[y][x] = A; }


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
