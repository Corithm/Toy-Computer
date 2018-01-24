package main.assembler

import main.Tools
import java.io.BufferedWriter
import java.io.FileWriter

/**
 * Hack Assembler implementation
 *
 * Based on The Elements of Computing Systems chapter 6
 */
class Assember
{
    private val code = Code()
    private val symbols = SymbolTable()

    private var fileName: String? = null
    private var writer: BufferedWriter? = null

    /**
     * Compiles the file intro a binary code file.
     *
     * @param fileName the name of *.asm file
     */
    fun assemble(fileName: String)
    {
        val file = Parser("$fileName.asm")
        this.fileName = fileName
        writer = BufferedWriter(FileWriter("$fileName.bin"))

        // Read the file and translate it into 16-bit binary sequence
        while (file.nextLine())
        {
            when (file.commandType())
            {
                file.A_COMMAND ->
                {
                    val result = StringBuilder("0")
                    val symbol = file.symbolMnemonic()

                    // Assume it is a integer.
                    result.append(
                            Tools.toBinaryString(symbol.toInt()))

                    writeLine(result.toString())
                }
                file.C_COMMAND ->
                {
                    val result = StringBuilder("111")
                    result.append(code.compCode(file.compMnemonic()))
                    result.append(code.destCode(file.destMnemonic()))
                    result.append(code.jumpCode(file.jumpMnemonic()))

                    writeLine(result.toString())
                }
                // Else it would an unspported command or a comment.
            }
        }
    }

    /** Writes a line of binary code to the file. */
    private fun writeLine(binaryCode: String)
    {
        writer!!.write(binaryCode)
    }
}