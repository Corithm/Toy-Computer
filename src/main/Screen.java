package main;

import javafx.scene.canvas.Canvas;

/**
 * Screen implementation with JavaFX.
 * We will follow the book specs for now, later we will add some colors.
 */
public class Screen extends Canvas
{
    public final int WIDTH  = 512;
    public final int HEIGHT = 256;

    public Screen()
    {
        super();
        setHeight(HEIGHT);
        setWidth(WIDTH);
    }

    public void start()
    {

    }
}
