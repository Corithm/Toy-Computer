/* This is free and unencumbered software released into the public domain.
 * ...
 * For more information, please refer to <http://unlicense.org/>
 */
package main.tool;

import main.hardware.chip.combinational.ALU;

/**
 * Contains tools that aren't really possible in real life implementation.
 */
public final class Tools
{
    public static ALU alu = new ALU();

    /**
     * Converts a String of binary code to boolean[].
     *
     * @param code to be converted
     * @return the input as an array of boolean values
     */
    public static boolean[] toBinary(String code)
    {
        code = code.trim();

        boolean[] result = new boolean[code.length()];

        for (int i = 0; i < code.length(); i++)
        {
            result[i] = (code.charAt(i) == '1');
        }

        return result;
    }

    public static boolean[] toBinary(int decNumber)
    {
        return toBinary(toBinaryString(decNumber));
    }

    /**
     * Returns a 16-bit binary string with leading zeroes
     *
     * @param decNumber
     * @return 16-bit binary string
     */
    public static String toBinaryString(int decNumber)
    {
        StringBuilder result = new StringBuilder();
        String binString = Integer.toBinaryString(decNumber);

        // Add the leading zeroes.
        for (int i = 0; i < 16 - binString.length(); i++)
        {
            result.append('0');
        }

        result.append(binString);

        return result.toString();
    }

    private Tools(){}
}
