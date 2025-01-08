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
                continue; // Prompts the user to try again.
            } finally {
                // Occurs regardless of a valid or invalid input.
                scanner.nextLine(); // Absorbs any stray \n from the user pressing "Enter".
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

    // getUserInputString Helper method
    private static void inputErrorString(String[] validInputs) {
        System.out.printf("Input error. Only accepts these values: "); // Error message.
        for (int i = 0; i < validInputs.length - 1; i++) {
            // Prints all the valid inputs in this format: 0, 1, 2, 3, 4, 
            String validInput = validInputs[i];
            System.out.printf("%s, ", validInput); 
        }
        String lastValidInput = validInputs[validInputs.length - 1];
        System.out.printf("and %s.\n", lastValidInput);
        // Makes the format finish off with 0, 1, 2, 3, 4, and 5.\n
    }

    public static String getUserInputString(String message, String[] validInputs) {
        // Starts a loop that can only end when the user input is within the array of valid inputs.
        String userInput;
        while (true) {
            inputMessage(message);
            userInput = scanner.nextLine(); // Actual user input.
            for (String validInput : validInputs) {
                // Loops through the array of valid inputs.
                if (userInput.equals(validInput)) {
                    // Returns the user input if it matches a valid input in the array.
                    return userInput;
                }
            }
            inputErrorString(validInputs);
            // Gets called if the user input did not successfully break through the method with return;.
        }
    }

    public static boolean getUserInputBoolean(String message) {
        // Starts a loop that can only end when the user input is y or n.
        String userInput;
        while (true) {
            System.out.printf("%s? (y/n) >> ", message); // Message and affordance to y/n
            userInput = scanner.nextLine().toLowerCase(); // Actual user input.
            switch (userInput) {
                case "y" -> { return true; } // True if y
                case "n" -> { return false; } // False if n
                default -> System.out.print("Input error. Please enter y or n.\n");
            }
        }
    }

    public static void inputBuffer() {
        // Gives a delay to the program to give the user time to read the printed outputs. 
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

    public static String pluralizeNoun(int amount) {
        // A basic pluralizer method that returns an "s" or "" depending on the amount
        if (amount != 1) {
            return "s"; // Plural
        } else {
            return ""; // Singular
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