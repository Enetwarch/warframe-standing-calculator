package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    private static final Scanner scanner = new Scanner(System.in);


    ////// INPUT METHODS


    // Input helper method
    private static void inputMessage(String message) {
        System.out.printf("%s: >> ", message);
    }

    // getUserInputInt Helper method
    private static void inputErrorInt(int min, int max) {
        System.out.printf("Input error. Only accepts integers from %d to %d.\n", min, max);
    }

    public static int getUserInputInt(String message, int min, int max) {
        int userInput; 
        while (true) {
            try {
                inputMessage(message);
                userInput = scanner.nextInt(); 
            } catch (InputMismatchException e) {
                inputErrorInt(min, max); 
                continue;
            } finally {
                scanner.nextLine(); // Absorbs \n
            }
            if (userInput >= min && userInput <= max) {
                return userInput; 
            } else {
                inputErrorInt(min, max);
            }
        }
    }

    // getUserInputString Helper method
    private static void inputErrorString(String[] validInputs) {
        System.out.printf("Input error. Only accepts these values: ");
        for (int i = 0; i < validInputs.length - 1; i++) {
            String validInput = validInputs[i];
            System.out.printf("%s, ", validInput); 
        }
        String lastValidInput = validInputs[validInputs.length - 1];
        System.out.printf("and %s.\n", lastValidInput);
    }

    public static String getUserInputString(String message, String[] validInputs) {
        String userInput;
        while (true) {
            inputMessage(message);
            userInput = scanner.nextLine();
            for (String validInput : validInputs) {
                if (userInput.equals(validInput)) {
                    return userInput;
                }
            }
            inputErrorString(validInputs);
        }
    }

    public static boolean getUserInputBoolean(String message) {
        String userInput;
        while (true) {
            System.out.printf("%s? (y/n) >> ", message);
            userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "y" -> { return true; }
                case "n" -> { return false; }
                default -> System.out.print("Input error. Please enter y or n.\n");
            }
        }
    }

    public static void inputBuffer() {
        // Gives users time to read printed output.
        System.out.print("Press enter to proceed. ");
        scanner.nextLine();
        System.out.print("\n");
    }



    ////// OUTPUT METHODS 


    public static void printNumberedArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, array[i]);
        }
    }

    public static String pluralizeNoun(int amount) {
        if (amount != 1) {
            return "s";
        } else {
            return "";
        }
    }

    public static void terminateProgram() {
        System.out.print(
            """
            Thank you for using Warframe Standing Calculator!
            Code by: Enetwarch     
            """
        );
        scanner.close();
        System.exit(0);
    }

}