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

        // Loop did not work...
        addEntry("R0", 0)
        addEntry("R1", 1)
        addEntry("R2", 2)
        addEntry("R3", 3)
        addEntry("R4", 4)
        addEntry("R5", 5)
        addEntry("R6", 6)
        addEntry("R7", 7)
        addEntry("R8", 8)
        addEntry("R9", 9)
        addEntry("R10", 10)
        addEntry("R11", 11)
        addEntry("R12", 12)
        addEntry("R13", 13)
        addEntry("R14", 14)
        addEntry("R15", 15)
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