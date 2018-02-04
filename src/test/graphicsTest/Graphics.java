package graphicsTest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Screen;
import main.hardware.GPU;
import main.hardware.Memory;
import main.tool.Tools;

public class Graphics extends Application
{
    private static Screen screen = new Screen();
    private Memory memory = new Memory();
    private GPU gpu = new GPU(memory);

    private void test()
    {
        memory.input(
                "0100000000100000", // 16 416
                Tools.toBinary("1111111111111111"),
                true
        );
        memory.input(
                "0100000001000000", // 16 448
                Tools.toBinary("1111111111111111"),
                true
        );
        memory.input(
                "0100000001100000", // 16 480
                Tools.toBinary("1111111111111111"),
                true
        );
        memory.input(
                "0100000010000000", // 16 512
                Tools.toBinary("1111111111111111"),
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
