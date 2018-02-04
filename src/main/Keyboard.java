/* This is free and unencumbered software released into the public domain.
 * ...
 * For more information, please refer to <http://unlicense.org/>
 */
package main;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import main.tool.Tools;

/**
 * Keyboard implementation.
 * We begin with ASCII keycodes
 *
 */
public class Keyboard
{
    private final String LEAD = "0000 0000 ";

    private Scene env;
    private boolean[] key;

    public void set(Scene scene)
    {
        env = scene;
        env.setOnKeyPressed(event -> register(event.getCode()));
    }

    // Translates a key String to binary values.
    // https://en.wikipedia.org/wiki/ASCII#Printable_characters
    private void register(KeyCode code)
    {
        String part = "";
        switch (code)
        {
            case A: part = "0100 0001"; break; // 41
            case B: part = "0100 0010"; break; // 42
            case C: part = "0100 0011"; break; // 43
            case D: part = "0100 0100"; break; // 44
            case E: part = "0100 0101"; break; // 45
            case F: part = "0100 0110"; break; // 46
            case G: part = "0100 0111"; break; // 47
            case H: part = "0100 1000"; break; // 48
            case I: part = "0100 1001"; break; // 49
            case J: part = "0100 1010"; break; // 4A
            case K: part = "0100 1011"; break; // 4B
            case L: part = "0100 1100"; break; // 4C
            case M: part = "0100 1101"; break; // 4D
            case N: part = "0100 1110"; break; // 4E
            case O: part = "0100 1111"; break; // 4F
            case P: part = "0101 0000"; break; // 50
            case Q: part = "0101 0001"; break; // 51
            case R: part = "0101 0010"; break; // 52
            case S: part = "0101 0011"; break; // 53
            case T: part = "0101 0100"; break; // 54
            case U: part = "0101 0101"; break; // 55
            case V: part = "0101 0110"; break; // 56
            case W: part = "0101 0111"; break; // 57
            case X: part = "0101 1000"; break; // 58
            case Y: part = "0101 1001"; break; // 59
            case Z: part = "0101 1010"; break; // 5A
            default: break;
        }

        key = convert(LEAD + part);
        System.out.println("Typed: " + code);
    }

    private boolean[] convert(String code) { return Tools.toBinary(code); }
}
