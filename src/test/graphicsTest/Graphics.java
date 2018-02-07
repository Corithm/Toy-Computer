package graphicsTest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Screen;
import main.hardware.GPU;
import main.hardware.Memory;
import main.tool.Binary;
import main.tool.Tools;

public class Graphics extends Application
{
    private static Screen screen = new Screen();
    private Memory memory = new Memory();
    private GPU gpu = new GPU(memory);

    private void test()
    {
        memory.input(
                new Binary("0100_0000_0010_0000"), // 16 416
                new Binary("1111_1111_1111_1111"),
                true
        );
        memory.input(
                new Binary("0100_0000_0100_0000"), // 16 448
                new Binary("1111_1111_1111_1111"),
                true
        );
        memory.input(
                new Binary("0100_0000_0110_0000"), // 16 480
                new Binary("1111_1111_1111_1111"),
                true
        );
        memory.input(
                new Binary("0100_0000_1000_0000"), // 16 512
                new Binary("1111_1111_1111_1111"),
                true
        );

        // This should draw some pixels to the screen.
        gpu.refresh();
    }

    @Override
    public void start(Stage frame) throws Exception
    {
        try
        {
            Group root = new Group(screen);
            Scene env = new Scene(root);
            frame.setScene(env);
            gpu.connect(screen);

            frame.show();
            frame.setTitle("Graphics Test");
            test();
        }
        catch (Exception e) { e.printStackTrace(); }
    }


    public static void main(String[] args) { launch(args); }
}
