package q3;

/**
 * <p>The MIXChar class represents a single MIXChar character. The MIXChar
 * constructor checks if the parameter char is a valid MIXChar by calling the
 * isMixChar() method, which goes through the array of all the MIXChars and
 * checks if that char is one of them. It returns true if it is, otherwise
 * false. The constructor throws an exception if the parameter char can't be
 * converted. The constructor also sets the ordinal/numeric value of the MIXChar
 * to the index of the array it's at. The ordinal() method returns this number.
 * The toChar() method returns the parameter char at the index of the ordinal
 * value. The toString() method takes in a MIXChar array and adds each of the
 * MIXChars to a string, which is returned. The toMixChar() method takes in a 
 * string, and converts each char to a MIXChar. These MIXChar are added to a
 * MIXChar array, which is returned. An exception is thrown if a character isn't
 * a MIXChar. The toString() method returns the MIXChar as a char in a string.
 * </p>
 * 
 * @author Monica
 * @version 1.0
 *
 */
public class MIXChar {
    /** Represents delta. */
    private static final char DELTA = '\u0394';
    
    /** Represents sigma. */
    private static final char SIGMA = '\u03A3';
    
    /** Represents PI. */
    private static final char PI = '\u03A0';
    
    /** Array of all MIXChars. */
    public static final char[] MIXCHARACTERS = {' ', 'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', DELTA, 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
        'R', SIGMA, PI, 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', 
        '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '(', ')', '+', 
        '-', '*', '/', '=', '$', '<', '>', '@', ';', ':', '\'' };
    
    /** Represents a single MIXChar. */
    private char mixChar;
    
    /** Represents the numeric value of the MIXChar. */
    private int ordinalValue;
    
    
    /**
     * Constructor converts c to the corresponding MIXChar. If a conversion is
     * not possible, an exception is thrown.
     *
     * @param c char
     * @throws IllegalArgumentException if parameter can't be converted to a
     *      MIXChar
     */
    public MIXChar(char c) {
        // Checks if the parameter char is a MIXChar
        if (isMIXChar(c)) {
            
            // If it is, go through each character in the MIXChar array until
            // that character is found
            for (int index = 0; index < MIXCHARACTERS.length; index++) {
                
                // If the parameter character equals the MIXChar at this index
                if (c == MIXCHARACTERS[index]) {
                    
                    // Set the MIXChar variable to the character at the index
                    mixChar = MIXCHARACTERS[index];
                    
                    // Set the ordinal value to the index
                    ordinalValue = index;
                }
            }
        } else {
            // If parameter char is not a MIXChar, throw an exception
            throw new IllegalArgumentException("Conversion not possible.");
        }
    }
    
    
    /**
     * Returns true if c corresponds to a MIXChar character, otherwise false.
     *
     * @param c char
     * @return isMixChar boolean
     */
    public static boolean isMIXChar(char c) {
        // Variable stores boolean value depending on if the parameter char is
        // a MIXChar
        boolean isMixChar = false;
        
        // For loop goes through each index in the array of MIXChars
        for (int index = 0; index < MIXCHARACTERS.length; index++) {
            // If the char equals one of the MIXChars
            if (c == MIXCHARACTERS[index]) {
                // The char is a MIXChar
                isMixChar = true;
            }
        }
        
        // Return if the parameter char is a MIXChar
        return isMixChar;
    }
    
    
    /**
     * Converts this MIXChar character to corresponding Java char.
     *
     * @return javaChar char
     */
    public char toChar() {
        // Variables stores the MIXChar value as a char
        char javaChar = MIXCHARACTERS[ordinalValue];
        
        // Return the MIXChar as a char
        return javaChar;
    }

    /**
     * Returns a string with characters corresponding to ones in the parameter
     * array.
     *
     * @param chars MIXChar array
     * @return characters string
     */
    public static String toString(MIXChar[] chars) {
        // Variable stores the current MIXChar in the array
        MIXChar currentMixChar;
        
        // String stores all the MIXChar characters in the array as a string
        String characters = "";
        
        // For loop goes through each index in the parameter array
        for (int index = 0; index < chars.length; index++) {
            
            // Get the current MIXChar at the index of the array
            currentMixChar = chars[index];
            
            // Add the current MIXChar to the string
            characters += currentMixChar;
        }
        
        // Return the MIXChar characters as a string
        return characters;
    }
    
    /**
     * Returns an array of MIXChar characters for the chars in the parameter
     * string.
     *
     * @param s string
     * @return ordinal integer
     * @throws IllegalArgumentException if at least one character in the string
     *      is not a MIXChar
     */
    public static MIXChar[] toMIXChar(String s) {
        // Array stores the characters in the parameter string
        MIXChar[] mixChars = new MIXChar[s.length()];
        
        // Variable stores the current char in the string
        char currentChar;
        
        // For loop goes through each character in the string
        for (int index = 0; index < s.length(); index++) {
            // Get current character at the index
            currentChar = s.charAt(index);
            
            // If any if the string's characters do not correspond to MIXChar
            // characters
            if (!isMIXChar(currentChar)) {
                // Throw an exception
                throw new IllegalArgumentException("At least one character"
                  + " does not correspond to a MIXChar character.");
            } else {
                // If all characters can be converted
                // Set the index of the loop to the value at that index in the
                // string
                mixChars[index] = new MIXChar(currentChar);
            }
        }
        
        // Return mixChars array
        return mixChars;
    }
    
    
    /**
     * Returns the numerical value of this MIXChar.
     *
     * @return ordinalValue integer
     */
    public int ordinal() {
        // Return the ordinal value of the MIXChar, which was initialized in
        // the constructor
        return ordinalValue;
    }

    
    /**
     * Returns a string containing this MIXChar as a Java char.
     *
     * @return string value of mixChar
     */
    public String toString() {
        // Return a string containing the MIXChar as a char
        return String.valueOf(mixChar);
    }
    
}
