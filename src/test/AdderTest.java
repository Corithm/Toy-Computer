import main.chip.HalfAdder;

public class AdderTest
{
    public static void main(String[] args)
    {
        halfAdder();
    }

    private static void halfAdder()
    {
        HalfAdder chip = new HalfAdder();

        boolean[] results = new boolean[4];

        chip.in(false, false);
        results[0] = (chip.outS() == false && chip.outC() == false);

        chip.in(false, true);
        results[1] = (chip.outS() && chip.outC() == false);

        chip.in(true, false);
        results[2] = (chip.outS() && chip.outC() == false);

        chip.in(true, true);
        results[3] = (chip.outS() == false && chip.outC());

        if (results[0] == results[1] == results[2] == results[3])
            System.out.println("[X] HalfAdder");
        else
            System.out.println("[ ] HalfAdder");

    }
}
