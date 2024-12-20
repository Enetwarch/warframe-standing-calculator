package data;
import java.util.Scanner;

public class Format {

    public static Scanner scanner = new Scanner(System.in);
    // Scanner object to get the user input.
    

    /////////////////////////////////////////////////


    // Input methods
    public static void inputError(int min, int max) {
        System.out.printf("Invalid input. Only accepts numbers from %d to %d.\n", min, max); 
    }   // Gets called by the getUserInput() method. 
    // Either the input is out of bounds or it caused an error.
    
    public static int getUserInput(String message, int min, int max) {
        int userInput = -1; // Temporary user input.
        while (true) {
            try {
                System.out.printf("%s: >> ", message); 
                // Sends a message with this format: >> 
                userInput = scanner.nextInt(); 
                if (userInput >= min && userInput <= max) {
                    break;
                } else {
                    scanner.nextLine(); // Absorbs the \n after the user presses enter.
                    inputError(min, max);
                }
            } catch (Exception e) {
                scanner.nextLine(); // Absorbs \n.
                inputError(min, max);
            }
        }
        scanner.nextLine(); // Absorbs \n.
        System.out.print("\n"); // Prints an empty space after a successful input.
        return userInput;
    }

    public static void inputBuffer() {
        System.out.print(
            "Press enter to proceed >> "
        ); // Gives the user time to look at the output.
        scanner.nextLine(); // Pauses till enter is pressed.
        System.out.print("\n"); // Prints an empty space after the input buffer.
    }


    ////////////////////////////////////////////////////////////////


    // Pluralize methods
    public static void pluralizeNames(int[] amount, String[] name) {
        for (int i = 0; i < name.length; i++) {
            if (amount[i] > 1) {
                name[i] = name[i] + "s";
            } // Pluralizes the element name if its amount is more than 1.
        } // Used in sacrifice resources methods.
    }
    
    public static String pluralizeDays(int days) {
        if (days > 1) {
            return "s"; 
        } else {
            return ""; 
        } // Adds an "s" at the end of the day string if it is more than 1.
    } // Keeps the day in singular form otherwise.


    ///////////////////////////////////////////////////////


    // Print methods
    public static void printArray(String[] list, int min) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%d. %s\n", i + min, list[i]); 
            // Prints the given array with numbered bullets.
        } // The number starts with the minimum value given.
    }

    public static void printResourceArray(int[] amount, String[] name) {
        pluralizeNames(amount,name);
        for (int i = 0; i < name.length; i++) {
            System.out.printf("- %,d %s\n", amount[i], name[i]); 
            // Prints the given array with dash bullets.
        } // Also prints the amount of the item.
    }


    ///////////////////////////////////////////


    // Exit methods
    public static void printSyndicateSelect() {
        System.out.print("0. Return to syndicate select.\n"); 
    } // To exit the faction syndicate loop.

    public static void printExitProgram() {
        System.out.print("0. Exit program\n");
    }  // To exit the program.

    public static void terminateProgram() {
        System.out.print("Program terminated.\n");
        scanner.close(); // Closes the scanner to prevent resource leakage.
        System.exit(0); // Terminates the program.
    }

}