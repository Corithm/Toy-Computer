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

    /** @return the destination code */
    fun dest() = when (currentCommand)
    {
        "null" -> "000"
        "M"    -> "001"
        "D"    -> "010"
        "MD"   -> "011"
        "A"    -> "100"
        "AM"   -> "101"
        "AD"   -> "110"
        "AMD"  -> "111"
        else   -> throw InvalidDestCodeException()
    }

    /** @return the computation code */
    fun comp() = when (currentCommand)
    {
        // FOR A = 0
          "0" -> "0 1010 10"
          "1" -> "0 1111 11"
         "-1" -> "0 1110 10"
          "D" -> "0 0110 00"
          "A" -> "0 1100 00"
         "!D" -> "0 0011 01"
         "!A" -> "0 1100 01"
         "-D" -> "0 0011 11"
         "-A" -> "0 1100 11"
        "D+1" -> "0 0111 11"
        "A+1" -> "0 1101 11"
        "D-1" -> "0 0011 10"
        "A-1" -> "0 1100 10"
        "M-1" -> "0 1100 10"
        "D+A" -> "0 0000 10"
        "A-D" -> "0 0001 11"
        "D&A" -> "0 0000 00"
        "D|A" -> "0 0101 01"
        // FOR A = 1
          "M" -> "1 1100 00"
         "!M" -> "1 1100 01"
         "-M" -> "1 1100 11"
        "M+1" -> "1 1101 11"
        "D+M" -> "0 0000 10"
        "D-M" -> "0 0100 11"
        "M-D" -> "0 0001 11"
        "D&M" -> "0 0000 00"
        "D|M" -> "0 0101 01"
        else -> throw InvalidCompCodeException()
    }

    /** @return the jump code */
    fun jump() = when (currentCommand)
    {
        "null"-> "000"
        "JGT" -> "001"
        "JEQ" -> "010"
        "JGE" -> "011"
        "JLT" -> "100"
        "JNE" -> "101"
        "JLE" -> "110"
        "JMP" -> "111"
        else -> throw InvalidJumpCodeException()
    }
}

class InvalidJumpCodeException : Throwable()
class InvalidCompCodeException : Throwable()
class InvalidDestCodeException : Throwable()
class NoMoreCommandsException  : Throwable()