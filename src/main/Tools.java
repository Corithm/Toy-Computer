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

    private Tools(){}
}
