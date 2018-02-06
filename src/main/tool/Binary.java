package main.tool;

/**
 * Represents a binary sequence.
 *
 * The values are stored as an array of boolean values.
 */
public final class Binary
{
    private final int LENGTH;
    private boolean[] sequence;

    /**
     * The default constructor sets the LENGTH to 16.
     */
    public Binary() {
        LENGTH = 16;
        sequence = new boolean[16];
    }

    /**
     * Initialize a new Binary -sequence with a String object.
     *
     * @param sequence to save
     */
    public Binary(String sequence)
    {
        LENGTH = sequence.length();
        this.sequence = new boolean[LENGTH];

        set(sequence);
    }

    /**
     * Sets the string as binary.
     *
     * @param sequence to set
     */
    public final void set(String sequence)
    {
        sequence = sequence.replaceAll("_", "");

        for (int i = 0; i < LENGTH; i++)
        {
            this.sequence[i] = (sequence.charAt(i) == 1);
        }
    }

    /**
     * Returns the binary sequence as boolean array.
     *
     * @return sequence as boolean[]
     */
    public final boolean[] getSequence() { return sequence; }

    /**
     * Returns the length of sequence.
     *
     * @return length as int
     */
    public final int getLength() { return LENGTH; }

    /**
     * Returns the binary sequence as String.
     * Use this as little as possible as this builds a String every call.
     *
     * @return sequence as String.
     */
    @Override public String toString()
    {
        StringBuilder result = new StringBuilder(LENGTH);

        for (boolean bit : sequence)
        {
            if (bit)
                result.append('1');
            else
                result.append('0');
        }

        return result.toString();
    }
}