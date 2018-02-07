/*
 * Copyright 2018 C. H. Lay (Corithm)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.tool;

/**
 * Represents a binary sequence.
 *
 * The values are stored as an array of boolean values.
 */
public final class Binary
{
    private boolean[] sequence;

    /**
     * The default constructor sets the LENGTH to 16.
     */
    public Binary() {
        sequence = new boolean[16];
    }

    /**
     * Initialize a new Binary -sequence with a String object.
     *
     * @param sequence to initialize
     */
    public Binary(String sequence)
    {
        set(sequence);
    }

    /**
     * Initialize a new Binary sequence with integer.
     * Supports only 16 bit values.
     *
     * @param valueAsDec the value to initialize
     */
    public Binary(int valueAsDec)
    {
        sequence = new boolean[16];
        String seq = Integer.toBinaryString(valueAsDec);

        int seqIndex = 0;
        for (int i = 0; i < 16; i++)
        {
            sequence[i] = (i >= 16 - seq.length()
                                && (seq.charAt(seqIndex++) == '1'));
        }
    }

    /**
     * Sets the string as binary.
     *
     * @param sequence to set
     */
    public final void set(String sequence)
    {
        sequence = sequence.replaceAll("_", "");
        this.sequence = new boolean[sequence.length()];

        for (int i = 0; i < sequence.length(); i++)
        {
            this.sequence[i] = (sequence.charAt(i) == '1');
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
    public final int getLength() { return sequence.length; }

    /**
     * Returns the binary sequence as String.
     * Use this as little as possible as this builds a String every call.
     *
     * @return sequence as String.
     */
    @Override public String toString()
    {
        StringBuilder result = new StringBuilder(sequence.length);

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