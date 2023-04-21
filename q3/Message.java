package q3;

/**
 * <p>The Message class represents a Message of MIXChars. The long array of
 * characters stores up to 11 MIXChars packed into a long for each index. The
 * integer charsInMessageCount counts the total number of characters in the
 * Message. The variable maxNumChars stores the maximum number of MIXChars that
 * can be stored in a long index of the array, which is 11. The variable 
 * fiftySix stores base 56, which is used when converting the MIXChar as a
 * number into a long.</p>
 * 
 * <p>The Message object constructor takes in either a MIXChar array or a 
 * string as the parameter. It counts how many characters are in the parameter
 * and stores that number. It divides that number by 11 to get the number of
 * array indexes needed to store the entire message into the long array. There
 * is an integer that keeps track of the position/place of the character, 
 * starting from 11, and decrementing each time a for loop is run. There is an
 * outer for loop that loops the number of indexes there are in the array, and
 * stores the calculated long into the array index. The inner for loop takes
 * the MIXChar at the current index of the loop, then calls the ordinal() method
 * from the MIXChar class to convert it to it's numeric value. The variable
 * value loops through a small for loop and multiplies itself by base 56 the
 * number of places that MIXChar is. The value result is multiplied by the 
 * MIXChar ordinal. This number is added on to a long called packedDigits,
 * which stores the sum of all the digits being packed in a single array index.
 * At the end of the inner for loop, the counter values are reset, and the sum
 * of packedDigits is stored in the long array index. This inner loop repeats
 * for each MIXChar. The outer loop repeats when there are more than 11 MIXChars
 * in the message.</p>
 * 
 * <p>The toLongs() method loops through each index of the long array, and
 * prints each of the long values separated by spaces. The toString() method has
 * an outer for loop that goes through the number if index in the long array.
 * The inner for loop is used to get the remainder and division from the long in
 * the current array index divided by base 56. Methods from the Long class are
 * used to store the remainder and quotient results as a long. The MIXChar in 
 * the array of MIXChars from the MIXChar class that corresponds to the 
 * remainder number is appended to a string that stores the decoded MIXChars 
 * from the long. This for loop is repeated for each index in the long array.
 * When both loops have finished, the string storing the decoded MIXChars is
 * returned.</p>
 * 
 * @author Monica
 * @version 1.0
 *
 */
public class Message {

    /** Array of characters in message object. */
    private long[] charsInMessage;
    
    /** The count of how many characters are in the message. */
    private int charsInMessageCount;
    
    /** 
     * Stores the maximum number of MIXChars that can be stored in an array 
     * index. 
     */
    private final int maxNumChars = 11;
    
    /** Stores base 56. */
    private final int fiftySix = 56;
    
    
    /**
     * Constructor represents an array of MIXChar's.
     * @param m MIXChar[] array
     */
    public Message(MIXChar[] m) {
        
        // Stores the number of characters in the parameter array
        int numOfChars = m.length;
        
        // Number of long indexes to store
        // Divide the number of characters by 11 to get the size of the array
        int numArrIndexes = numOfChars / maxNumChars;
        
        // If there's a remainder, you need to store the extra characters
        // Add another index to the array
        if (numOfChars % maxNumChars != 0) {
            numArrIndexes++;
        }
        
        // Set the charsInMessageCount variable to the number of characters in
        // the parameter array
        charsInMessageCount = numOfChars;
        
        // Array stores the temporary values of the charsInMessage array
        long[] initialArray = new long[numArrIndexes];
        
        // Stores the sum of the packed digits
        long packedDigits = 0;
        
        // Variable keeps track of the position of the current character in the
        // array
        int currCharCount = 0;
        
        // Outer for loop goes through each index in the array
        for (int arrIndex = 0; arrIndex < numArrIndexes; arrIndex++) {
            
            // Variable multiplies the array index by 11 to get the next
            // position instead of having to restart at zero
            int incEleven = arrIndex * maxNumChars;
            
           
            // For loop goes through each MIXChar and packs it into the long
            // array
            for (int index = 0; index < maxNumChars; index++) {
                
                // Boolean checks if the position of the current character
                boolean validIndex = currCharCount <= (numOfChars - 1);
                
                // If statement checks if validIndex is true, if not it skips
                // the other condition and doesn't execute the if statement
                if (validIndex && m[currCharCount] != null) {
                    
                    // Get the MIXChar at the current index
                    MIXChar currChar = m[index + incEleven];
                    
                    // Gets the MIXChar as a digit
                    long charDigit = (long) currChar.ordinal();
                    
                    // Pack the MIXChar
                    long value = 1;
                    for (int i = 0; i < index; i++) {
                        value *= fiftySix;
                    }
                    
                    // Convert packing result to a long
                    long currDigit = charDigit * value;
                    
                    // Add the current digit to the sum of the packed digits
                    packedDigits += currDigit;
                    
                    // Keeps track of current char
                    currCharCount++;
                }
                
            }
            
            // Get the total sum and add it to array
            initialArray[arrIndex] = packedDigits;
            
            // Reset the sum of packed digits
            packedDigits = 0;
        }
        
        // Set the initial array value to the instance variable charsInMessage
        charsInMessage = initialArray;
        
    }
    

    /**
     * Constructor represents a packed string of MIXChar's.
     * @param s string
     */
    public Message(String s) {
        
        // Create a MIXChar array and store each character in the string in the
        // array
        // This will throw an exception if string input is invalid
        MIXChar[] mixCharArray = MIXChar.toMIXChar(s);
        
        // Stores the number of characters in the string
        int numOfChars = s.length();
        
        // Number of long indexes to store
        // Divide the number of characters by 11 to get the size of the array
        int numArrIndexes = numOfChars / maxNumChars;
        
        // If there's a remainder, you need to store the extra characters
        // Add another index to the array
        if (numOfChars % maxNumChars != 0) {
            numArrIndexes++;
        }
        
        // Set the charsInMessageCount variable to the number of characters in
        // the parameter string
        charsInMessageCount = numOfChars;
        
        // Array stores the temporary values of the charsInMessage array
        long[] initialArray = new long[numArrIndexes];
        
        // Stores the sum of the packed digits
        long packedDigits = 0;
        
        // Variable keeps track of the position of the current character in the
        // array
        int currCharCount = 0;
        
        // Outer for loop goes through each index in the array
        for (int arrIndex = 0; arrIndex < numArrIndexes; arrIndex++) {
            
            // Variable multiplies the array index by 11 to get the next
            // position instead of having to restart at zero
            int incEleven = arrIndex * maxNumChars;
            
           
            // For loop goes through each MIXChar and packs it into the long
            // array
            for (int index = 0; index < maxNumChars; index++) {
                
                // Boolean checks if the position of the current character
                boolean validIndex = currCharCount <= (numOfChars - 1);
                
                // If statement checks if validIndex is true, if not it skips
                // the other condition and doesn't execute the if statement
                if (validIndex && mixCharArray[currCharCount] != null) {
                    
                    // Get the MIXChar at the current index
                    MIXChar currChar = new MIXChar(s.charAt(index + incEleven));
                    
                    // Gets the MIXChar as a digit
                    long charDigit = (long) currChar.ordinal();
                    
                    // Pack the MIXChar
                    long value = 1;
                    for (int i = 0; i < index; i++) {
                        value *= fiftySix;
                    }
                    
                    // Convert packing result to a long
                    long currDigit = charDigit * value;
                    
                    // Add the current digit to the sum of the packed digits
                    packedDigits += currDigit;
                    
                    // Keeps track of current char
                    currCharCount++;
                }
                
            }
            
            // Get the total sum and add it to array
            initialArray[arrIndex] = packedDigits;
            
            // Reset the sum of packed digits
            packedDigits = 0;
        }
        
        // Set the initial array value to the instance variable charsInMessage
        charsInMessage = initialArray;
    }
    

    /**
     * Returns a string corresponding to the characters in the message.
     * This decodes the message.
     * 
     * @return messageCharsStr string
     */
    public String toString() {
        // Stores the decoded message characters
        String messageCharsStr = "";
        
        // Stores the current remainder
        int remainder;
        
        // Stores the current dividend
        long dividend;
        
        // Outer for loop loops through each index of the charsInMessage array
        for (int arrIndex = 0; arrIndex < charsInMessage.length; arrIndex++) {
            
            // Set the dividend to the current value in the long array at
            // the array index
            dividend = charsInMessage[arrIndex];
            
            // For loop divides the current dividend by the position in the
            // array starting from the last index, and stores the remainder
            for (int index = 0; index < maxNumChars; index++) {
                
                // Get the remainder when dividing the long value in the array
                // by base 56
                remainder = (int) Long.remainderUnsigned(dividend, fiftySix);
                
                // Get the MIXChar corresponding to the remainder number by
                // calling the array of MIXChars from the MIXChar class
                // Append that MIXChar to the decoded message string
                messageCharsStr += MIXChar.MIXCHARACTERS[remainder];

                // If the dividend does not equal zero, divide it by base 56
                if (dividend != 0) {
                    // Get the quotient of the dividend divided by base 56
                    dividend = Long.divideUnsigned(dividend, fiftySix);
                }
                
            }
            
        }
        
        // Return the decoded message string
        return messageCharsStr;
    }
    
    
    /**
     * Returns a string of the long[] array formatted as unsigned integers
     * and separated by spaces.
     * 
     * @return longFormatted string
     */
    public String toLongs() {
        // Variable stores the string result of the long array
        String longFormatted = "";
        
        // For loop goes through each index in the character in message array
        for (int index = 0; index < charsInMessage.length; index++) {
            
            // Get the long stored at the current index
            long currDigits = charsInMessage[index];
            
            // Add the long to the string result and separate each long with
            // a space
            longFormatted += Long.toUnsignedString(currDigits) + " ";
        }
        
        // Return the long array as a string
        return longFormatted;
    }
    
}
