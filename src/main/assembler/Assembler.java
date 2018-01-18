package main.assembler;

import java.io.*;

/**
 * Assembler implementation.
 * Compiles *.asm files to binary code *.bin files.
 *
 * The language specification is in the Elements of Computing Systems.
 */
public class Assembler
{
    private String fileName;
    private BufferedWriter writer;


    /**
     * Compiles assembly code to binary code.
     *
     * @param fileName the file to compile
     */
    public void compile(String fileName)
    {
        this.fileName = fileName;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            writer = new BufferedWriter(new FileWriter(fileName + ".bin"));

            String line = reader.readLine();
            while (line != null)
            {
                if (line.charAt(0) == '/' && line.charAt(1) == '/')
                {
                    // Do nothing
                }
                else if (line.charAt(0) == '@')
                {
                  aInstruction(line);
                }
                else if (line.charAt(0) == '(' && line.charAt(line.length() - 1) == ')')
                {
                    pseudo(line);
                }
                else
                {
                    cInstruction(line);
                }

                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Addressing Instruction
    private void aInstruction(String line)
    {
        StringBuilder builder = new StringBuilder("0");
    }

    // Pseudoinstruction
    private void pseudo(String line)
    {
        
    }

    // Compute Instruction
    private void cInstruction(String line)
    {
        StringBuilder builder = new StringBuilder("111");

        String[] instruction = line.split("=");
        String[] rightSide = instruction[1].split(";");

        try {
            builder.append(comp(rightSide[0]));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            builder.append(dest(instruction[0]));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            builder.append(jump(rightSide[1]));
        }
        catch (ArrayIndexOutOfBoundsException ignored) { }
    }

    // Returns the comp code. I have no idea how to do this so I just hard code it for now.
    private String comp(String comp)
    {
        switch (comp)
        {
            // Note that this is from table at p. 109
            // For a=0
            case "0":   return "0101010";
            case "1":   return "0111111";
            case "-1":  return "0111010";
            case "D":   return "0001100";
            case "A":   return "0110000";
            case "!D":  return "0001101";
            case "!A":  return "0110001";
            case "-D":  return "0001111";
            case "-A":  return "0110011";
            case "D+1": return "0011111";
            case "A+1": return "0110111";
            case "D-1": return "0001110";
            case "A-1": return "0110010";
            case "D+A": return "0000010";
            case "D-A": return "0010011";
            case "A-D": return "0000111";
            case "D&A": return "0000000";
            case "D|A": return "0010101";
            // And for a = 1
            case "M":   return "1110000";
            case "!M":  return "1110001";
            case "-M":  return "1110011";
            case "M+1": return "1110111";
            case "M-1": return "1110010";
            case "D+M": return "1000010";
            case "D-M": return "1000111";
            case "M-D": return "1000111";
            case "D&M": return "1000000";
            case "D|M": return "1010101";
        }
        return null;
    }

    // Returns the dest code.
    private String dest(String dest)
    {
        switch (dest)
        {
            // Note that this is the table in the book p.110
            case "M":   return "001";
            case "D":   return "010";
            case "MD":  return "011";
            case "A":   return "100";
            case "AM":  return "101";
            case "AD":  return "110";
            case "AMD": return "111";
            default: return "000";
        }
    }
    // Returns the binary code of jump instruction.
    private String jump(String jump)
    {
        switch (jump)
        {
            // Note that this is the table in the book p.110
            case "JGT": return "001";
            case "JEQ": return "010";
            case "JGE": return "011";
            case "JLT": return "100";
            case "JNE": return "101";
            case "JLE": return "110";
            case "JMP": return "111";
            default:    return "000";
        }
    }
}
