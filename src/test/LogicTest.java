import main.gate.AndGate;
import main.gate.NotGate;

public class LogicTest
{
    public static void main(String[] args)
    {
        // We do not test nand-gate.
        NotGate();

    }

    private static void NotGate()
    {
        NotGate not = new NotGate();

        not.in(true);
        boolean val1 = not.out();

        not.in(false);
        boolean val2 = not.out();

        if (val1 == false && val2 == true)
            System.out.println("[X] not -gate.");
        else
            System.out.println("[ ] not -gate.");
    }

    private static void AndGate()
    {
        AndGate and = new AndGate();
    }
}
