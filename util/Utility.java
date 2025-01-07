package util;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Utility {
    private static final Scanner scanner = new Scanner(System.in); // Used to scan user input.

    //////////////////////////////////////////////////
    /// INPUT METHODS

    // Helper method
    private static void inputMessage(String message) {
        // Prints a message to prompt the user on what to input.
        System.out.printf("%s: >> ", message);
    }

    // getUserInputInt Helper method
    private static void inputErrorInt(int min, int max) {
        // Sends an error for integer inputs that are out of range or completely different data types.
        System.out.printf("Input error. Only accepts integers from %d to %d.\n", min, max);
    }

    public static int getUserInputInt(String message, int min, int max) {
        // Starts a loop that can only end when the user input is a valid integer.
        int userInput; 
        while (true) {
            try {
                inputMessage(message);
                userInput = scanner.nextInt(); // Gets user integer input.
            } catch (InputMismatchException e) {
                // Occurs when user input is not an integer.
                inputErrorInt(min, max); 
                scanner.nextLine(); // Absorbs any stray \n from the user pressing "Enter".
                continue; // Prompts the user to try again.
            }
            if (userInput >= min && userInput <= max) {
                return userInput; // Returns the integer input and breaks out of the method.
            } else {
                // Occurs when user input is out of range.
                inputErrorInt(min, max);
                // Does not need to absorb \n or "Enter" because it is an integer input.
            }
        }
    }

    public static void inputBuffer() {
        // Gives a delay to the program to give the user time to read the printed outputs. 
        scanner.nextLine(); // Absorbs the "enter" or \n from the user's input.
        System.out.print("Press enter to proceed. ");
        scanner.nextLine(); // Actual user input.
        System.out.print("\n");
        // Leaves a total of two enter spaces (one empty line).
    }

    ///////////////////////////////////////////////////////
    /// OUTPUT METHODS 

    public static void printNumberedArray(String[] array) {
        // Prints an entire array in ordered sequence from [1] to [array.length]
        for (int i = 0; i < array.length; i++) {
            // Iterates through the entire array.
            System.out.printf("[%d] %s\n", i + 1, array[i]);
            // Prints the array in ordered sequence and with numbers.
        }
    }

    public static void terminateProgram() {
        System.out.print(
            """
            Thank you for using Warframe Standing Calculator!
            Code by: Enetwarch     
            """
        );
        scanner.close(); // Closes scanner.
        System.exit(0); // Exits program.
        // Will be called when the user exits the program.
    }

}