/* This is free and unencumbered software released into the public domain.
 * ...
 * For more information, please refer to <http://unlicense.org/>
 */
package main;

/**
 * Contains tools that aren't really possible in real life implementation.
 */
public final class Tools
{
    /**
     * Converts a String of binary code to boolean[].
     *
     * @param code to be converted
     * @return the input as an array of boolean values
     */
    public static boolean[] toBinary(String code, int length)
    {
        boolean[] value = new boolean[length];

        int j = 0;
        for (int i = 0; i < code.length(); i++)
        {
            if (code.charAt(i) == '1')
            {
                value[j] = true;
                j++;
            }
            else if (code.charAt(i) == '0')
            {
                value[j] = false;
                j++;
            }
        }

        return value;
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
