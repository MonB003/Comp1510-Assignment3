package q3;

import java.util.Scanner;

/**
 * <P>The TestMIXChar class demonstrates how the Message and MIXChar classes
 * work. Two examples are printed to the console that use each of the Message
 * constructors. A Message object is created using a MIXChar array as a 
 * parameter, and another Message object is created using a string as the 
 * parameter. The Message constructor encodes up to 11 MIXChars into Message 
 * object by packing it into a long, which is printed to the console using the
 * toLongs() method. To decode the longs back into the original message, the
 * toString() method is called, which returns a string of the original 
 * MIXChars.</p>
 * 
 * <p>After the example Messages are encoded and decoded, the results are
 * printed to the console. The program then prompts the user to enter MIXChars,
 * and prints the results of the encoding and decoding methods. If the user's
 * input contains characters that aren't MIXChars, an exception is thrown that
 * tells the user their input isn't valid.</p>
 * 
 * @author Monica
 * @version 1.0
 */
public class TestMIXChar {
    
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // This array of MIXChars tests the constructor that takes an array
        // parameter
        MIXChar[] array = {new MIXChar('A'), new MIXChar('B'), new MIXChar('C'),
            new MIXChar('D'), new MIXChar('E'), new MIXChar('F'), 
            new MIXChar('G'), new MIXChar('1'), new MIXChar('2'),
            new MIXChar('3'), new MIXChar('4'), new MIXChar('5')};
        
        // Print the original message
        System.out.println("Message: " + MIXChar.toString(array));
        
        // Create a Message object with the array as the parameter
        Message messageArray = new Message(array);
        
        // Print result of the encoding method
        System.out.println("Encoded: " + messageArray.toLongs());
        
        // Print result of the decoding method
        System.out.println("Decoded: " + messageArray.toString());
        System.out.println();
        
        
        // This string tests the constructor that takes a string parameter
        String string = "HI MY NAME IS MONICA";
        
        // Create a Message object with quotes as the parameter
        Message messageString = new Message(string);
        
        // Print the original message
        System.out.println("Message: " + messageString);
        
        // Print result of the encoding method
        System.out.println("Encoded: " + messageString.toLongs());
        
        // Print result of the decoding method
        System.out.println("Decoded: " + messageString.toString());
        System.out.println();
        
        
        // Create a Scanner object
        Scanner scan = new Scanner(System.in);
        
        // Prompt user for input
        System.out.println("Enter a line of characters: ");
        
        // Store user's input
        String userCharacters = scan.nextLine();
        
        // Create a Message object with user's input as the parameter
        Message userMessage = new Message(userCharacters);
        
        // Print the original message
        System.out.println("Message: " + userMessage);
        
        // Print result of the encoding method
        System.out.println("Encoded: " + userMessage.toLongs());
        
        // Print result of the decoding method
        System.out.println("Decoded: " + userMessage.toString());
        
        // Prints at the end of the main method
        System.out.println();
        System.out.println("Question three was called and ran successfully.");
        
        // Close scanner
        scan.close();
    }
    
}
