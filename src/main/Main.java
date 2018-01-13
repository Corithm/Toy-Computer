package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This only boot one computer. I plan to fork this project,
 * improve the design and possibly simulate a minimal internet
 * technology.
 */
public class Main extends Application
{
    private static Computer computer = new Computer();
    private static Screen screen = new Screen();
    private static Keyboard keyboard = new Keyboard();

    @Override
    public void start(Stage frame)
    {
        try
        {
            Group root = new Group(screen);
            Scene env = new Scene(root);
            frame.setScene(env);
            computer.connect(screen);
            keyboard.set(env);

            frame.show();
            computer.boot();
        }
        // TODO: Implement BSOD
        catch (Exception e) { computer.shutDown(); }
    }

    public static void main(String[] args) { launch(args); }
}
