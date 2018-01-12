package hardware;

import main.hardware.chip.combinational.ALU;

public class ALUTest
{
    private static ALU alu = new ALU();

    public static void main(String[] args)
    {
        // NOTE: The binary inputs are read from left to right.
        //         1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, G
        int[] X = {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}; // 406
        int[] Y = {1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}; // 223

        // 0
        int[] C1 = {1, 0, 1, 0, 1, 0};
        calculate(X, Y, C1);
        System.out.println(" =? 0000000000000000 (0)");

        // 1
        int[] C2 = {1, 1, 1, 1, 1, 1};
        calculate(X, Y, C2);
        System.out.println(" =? 1000000000000000 (1) !");

        // -1
        int[] C3 = {1, 1, 1, 0, 1, 0};
        calculate(X, Y, C3);
        System.out.println(" =? 1111111111111111 (-1)");

        // x
        int[] C4 = {0, 0, 1, 1, 0, 0};
        calculate(X, Y, C4);
        System.out.println(" =? 0110100110000000 (406)");

        // y
        int[] C5 = {1, 1, 0, 0, 0, 0};
        calculate(X, Y, C5);
        System.out.println(" =? 1111101100000000 (223)");

        // !x
        int[] C6 = {0, 0, 1, 1, 0, 1};
        calculate(X, Y, C6);
        System.out.println(" =? 1001011001111111 (not 406)");

        // !y
        int[] C7 = {1, 1, 0, 0, 0, 1};
        calculate(X, Y, C7);
        System.out.println(" =? 0000010011111111 (not 223)");

        // -x
        int[] C8 = {0, 0, 1, 1, 1, 1};
        calculate(X, Y, C8);
        System.out.println(" =? 0110100110000000 (-406)");

        // -y
        int[] C9 = {1, 1, 0, 0, 1, 1};
        calculate(X, Y, C9);
        System.out.println(" =? 1111101100000000 (-223)");

        // x + 1
        int[] C10 = {0, 1, 1, 1, 1, 1};
        calculate(X, Y, C10);
        System.out.println(" =? 1110100110000000 (407)");

        // y + 1
        int[] C11 = {1, 1, 0, 1, 1, 1};
        calculate(X, Y, C11);
        System.out.println(" =? 0000011100000000 (224)");

        // x - 1
        int[] C12 = {0, 0, 1, 1, 1, 0};
        calculate(X, Y, C12);
        System.out.println(" =? 1010100110000000 (405)");

        // y - 1
        int[] C13 = {1, 1, 0, 0, 1, 0};
        calculate(X, Y, C13);
        System.out.println(" =? 0111101100000000 (222)");

        // x + y
        int[] C15 = {0, 0, 0, 0, 1, 0};
        calculate(X, Y, C15);
        System.out.println(" =? 1010111001000000 (629) ");

        // x - y
        int[] C16 = {0, 1, 0, 0, 1, 1};
        calculate(X, Y, C16);
        System.out.println(" =? 1110110100000000 (183)");

        // y - x
        int[] C17 = {0, 1, 0, 0, 1, 1};
        calculate(X, Y, C17);
        System.out.println(" =? 1110110100000000 (-183)");

        int[] C18 = {0, 0, 0, 0, 0, 0};
        calculate(X, Y, C18);
        System.out.println(" =? 0110100100000000");

        int[] C19 = {0, 1, 0, 1, 0, 1};
        calculate(X, Y, C19);
        System.out.println(" =? 1111101110000000");
    }

    private static void calculate(int[] A, int[] B, int[] C)
    {
        alu.in(toBoolean(A), toBoolean(B), toBoolean(C));
        print(alu.out());
    }

    private static boolean[] toBoolean(int[] A)
    {
        boolean[] result = new boolean[A.length];

        for (int i = 0; i < A.length; i++)
        {
            result[i] = A[i] == 1;
        }

        return result;
    }

    private static void print(boolean[] A)
    {
        for (boolean i : A)
        {
            if (i) System.out.print(1);
            else System.out.print(0);
        }
    }
}
