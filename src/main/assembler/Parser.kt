package main.assembler

import java.io.BufferedReader
import java.io.FileReader

/**
 * Parser implementation.
 *
 * p. 113 - 114
 */
class Parser(var fileName: String)
{
    private val reader: BufferedReader = BufferedReader(FileReader("$fileName.asm" ))

    private var currentCommand: String = ""

    val A_COMMAND: Int = 1
    val C_COMMAND: Int = 2
    val L_COMMAND: Int = 3

    /**
     * Sets the next command.
     */
    fun nextLine()
    {
        currentCommand = reader.readLine()
        // TODO: REMOVE WHITESPACES AND COMMENTS
        if (currentCommand == null) throw NoMoreCommandsException()
    }

    /** @return the command type */
    fun commandType(): Int
    {
        return when (currentCommand[0])
        {
            '@'  -> A_COMMAND
            '('  -> L_COMMAND
            else -> C_COMMAND
        }
    }

    /** @return the symbol or decimal of A_COMMAND or L_COMMAND. */
    fun symbol() = currentCommand.substring(1)

    /** @return the dest part of the code */
    fun dest() = currentCommand.substringBefore('=')

    /** @return the comp part of the code */
    fun comp() = currentCommand.substringAfter('=').substringBefore(';')

    /** @return the jump part of the code */
    fun jump() = currentCommand.substringAfter(';')
}

class NoMoreCommandsException  : Throwable()