import main.gate.AndGate;
import main.gate.NotGate;

public class LogicTest
{
    public static void main(String[] args)
    {
        AndGate();
        MuxGate();
        // Nand gate will not be tested.
        NotGate();
        NorGate();
        OrGate();
        XorGate();
    }

    private static void AndGate()
    {
        AndGate and = new AndGate();

        boolean results[] = new boolean[4];

        and.in(false, false);
        results[0] = and.out();

        and.in(false, true);
        results[1] = and.out();

        and.in(true, false);
        results[2] = and.out();

        and.in(true, true);
        results[3] = and.out();

        if (results[0] == results[1] == results[2] == false && results[3])
            System.out.println("[X] and -gate");
        else
            System.out.println("[ ] and -gate");
    }

    private static void MuxGate()
    {

    }

    private static void NorGate()
    {

    }

    private static void NotGate()
    {
        NotGate not = new NotGate();

        not.in(true);
        boolean val1 = not.out();

        not.in(false);
        boolean val2 = not.out();

        if (val1 == false && val2 == true)
            System.out.println("[X] not -gate");
        else
            System.out.println("[ ] not -gate");
    }

    private static void OrGate()
    {

    }

    private static void XorGate()
    {

    }
}
