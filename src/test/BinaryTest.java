import main.tool.Binary;

public class BinaryTest
{
    public static void main(String[] args)
    {
        out(new Binary(0).toString());

        out(new Binary(1).toString());

        out(new Binary("0000_1111_0000_1111").toString());
    }

    private static void out(String o)
    {
        System.out.println(o);
    }
}
