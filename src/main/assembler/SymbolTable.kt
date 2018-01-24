package main.assembler

import java.util.HashMap

/**
 * Symbol table implementation.
 *
 * The book suggested using hash table for this.
 */
class SymbolTable
{
    private val table = HashMap<String, Int>()

    init
    {
        addEntry("SP", 0)
        addEntry("LCL", 1)
        addEntry("ARG", 2)
        addEntry("THIS", 3)
        addEntry("THAT", 4)
        addEntry("SCREEN", 16384)
        addEntry("KBD", 24576)

        // Add the R0 - R15 labels
        var label: String = "RX"
        var i = 0
        while (i <= 15)
        {
            // Replace the second character.
            label.replaceAfter("R", i.toString())
            addEntry(label, i)

            i++
        }
    }

    /** Adds a new pair (symbol, address) to the table.
     * @param symbol
     * @param address
     */
    fun addEntry(symbol: String, address: Int)
    {
        table[symbol] = address
    }

    /**
     * @param symbol
     * @return a boolean value whether the symbol exists
     */
    fun contains(symbol: String) = table.containsKey(symbol)

    /**
     * @param symbol
     * @return the address of the symbol
     */
    fun getAddress(symbol: String) = table[symbol]
}