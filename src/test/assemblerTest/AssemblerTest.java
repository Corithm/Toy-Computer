package assemblerTest;

import main.assembler.Assembler;

/**
 * Test the Assembler.java.
 */
public class AssemblerTest
{
    public static void main(String[] args)
    {
        Assembler assembler = new Assembler();
        assembler.assemble("src/test/assemblerTest/asmTest");
    }
}
