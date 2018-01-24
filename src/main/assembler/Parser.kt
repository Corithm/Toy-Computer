package main.assembler

import java.io.BufferedReader
import java.io.FileReader

/**
 * Parser implementation.
 *
 * p. 113 - 114
 */
class Parser(fileName: String)
{
    private val reader: BufferedReader = BufferedReader(FileReader(fileName))

    private var currentCommand: String? = null

    val IGNORED: Int = 0
    val A_COMMAND: Int = 1
    val C_COMMAND: Int = 2
    val L_COMMAND: Int = 3

    /**
     * Sets the next command.
     */
    fun nextLine(): Boolean
    {
        currentCommand = reader.readLine().trim(' ')

        return currentCommand != null
    }

    /** @return the command type */
    fun commandType(): Int
    {
        if (currentCommand!![0] == '/'&& currentCommand!![1] == '/')
        {
            return IGNORED
        }
        else
        {
            return when (currentCommand!![0]) {
                '@' -> A_COMMAND
                '(' -> L_COMMAND
                else -> C_COMMAND
            }
        }
    }

    fun close() { reader.close() }

    /** @return the symbol or decimal of A_COMMAND or L_COMMAND. */
    fun symbolMnemonic() = currentCommand!!.substring(1).substringBefore(')')

    /** @return the dest part of the code */
    fun destMnemonic() = currentCommand!!.substringBefore('=')

    /** @return the comp part of the code */
    fun compMnemonic() = currentCommand!!.substringAfter('=').substringBefore(';')

    /** @return the jump part of the code */
    fun jumpMnemonic() = currentCommand!!.substringAfter(';')
}