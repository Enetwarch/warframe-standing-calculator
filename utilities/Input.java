package utilities;

import java.util.Scanner;

public class Input {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_ERROR = "INPUT ERROR";

    private static void inputMessageInt(String message) {
        System.out.printf("%s: ", message);
    }

    private static void inputErrorInt(int min, int max) {
        System.out.printf("%s. Accepts integers %d to %d.%n", INPUT_ERROR, min, max);
    }

    public static int getUserInputInt(String message, int min, int max) {
        int userInput;
        while (true) {
            try {
                inputMessageInt(message);
                userInput = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                inputErrorInt(min, max); 
                continue;
            }
            if (userInput >= min && userInput <= max) {
                return userInput; 
            } else {
                inputErrorInt(min, max);
            }
        }
    }

    private static void inputMessageBoolean(String message) {
        System.out.printf("%s? (y/n): ", message);
    }

    private static void inputErrorBoolean() {
        System.out.printf("%s. Accepts y or n.%n", INPUT_ERROR);
    }

    public static boolean getUserInputBoolean(String message) {
        String userInput;
        while (true) {
            inputMessageBoolean(message);
            userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "y" -> {
                    return true;
                }
                case "n" -> {
                    return false;
                }
                default -> {
                    inputErrorBoolean();
                }
            }
        }
    }

    public static void inputBuffer() {
        System.out.print("Press enter to proceed. ");
        scanner.nextLine();
        System.out.printf("%n");
    }

}