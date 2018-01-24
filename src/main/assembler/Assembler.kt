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

    private var nextAddress = 16

    /**
     * Compiles the file intro a binary code file.
     *
     * @param fileName the name of *.asm file
     */
    fun assemble(fileName: String)
    {
        this.fileName = fileName

        val file = Parser("$fileName.asm")
        writer = BufferedWriter(FileWriter("$fileName.bin"))

        collectSymbols()

        // Read the file and translate it into 16-bit binary sequence
        while (file.nextLine())
        {
            when (file.commandType())
            {
                file.A_COMMAND -> aCommand(file)
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

        writer?.close()
        file.close()
    }

    /* Collects all symbols and adds them to SymbolTable. */
    private fun collectSymbols()
    {
        val file = Parser("$fileName.asm")
        var romAddress = 0

        while (file.nextLine())
        {
            val type = file.commandType()
            if (type == file.A_COMMAND || type == file.C_COMMAND)
            {
                romAddress++
            }
            else if (type == file.L_COMMAND)
            {
                symbols.addEntry(file.symbolMnemonic(), romAddress)
            }
        }

        file.close()
    }

    private fun aCommand(file: Parser)
    {
        val result = StringBuilder("0")
        val symbol = file.symbolMnemonic()

        val isInt = symbol.toIntOrNull()

        if (isInt != null)
        {
            result.append(
                    Tools.toBinaryString(symbol.toInt()))
        }
        else
        {
            // To binary code
            val address: Int? = symbols.getAddress(symbol)
            try
            {
                result.append(
                        Tools.toBinaryString(address!!))
            }
            catch (e: Exception)
            {
                nextAddress++
                symbols.addEntry(symbol, nextAddress)
                result.append(
                        Tools.toBinaryString(nextAddress))
            }
        }

        writeLine(result.toString())
    }

    /** Writes a line of binary code to the file. */
    private fun writeLine(binaryCode: String)
    {
        writer!!.write(binaryCode)
    }
}