package com.github.enetwarch.warframestandingcalculator.util;
import java.util.Scanner;

public class Input {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_ERROR = "INPUT ERROR";

    public static int getUserInputInt(String inputPrompt, int min, int max) {
        int userInput;
        while (true) {
            try {
                printInputPromptInt(inputPrompt);
                userInput = Integer.parseInt(scanner.nextLine().trim());
                if (userInput >= min && userInput <= max) {
                    return userInput;
                } else {
                    printInputErrorInt(min, max);
                }
            } catch (NumberFormatException e) {
                printInputErrorInt(min, max);
                continue;
            }
        }
    }

    private static void printInputPromptInt(String inputPrompt) {
        System.out.printf("%s: ", inputPrompt);
    }

    private static void printInputErrorInt(int min, int max) {
        System.out.printf("%s. Accepts integers %d to %d.%n", INPUT_ERROR, min, max);
    }

    public static boolean getUserInputBoolean(String inputPrompt) {
        String userInput;
        while (true) {
            printInputPromptBoolean(inputPrompt);
            userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "y": return true;
                case "n": return false;
                default: printInputErrorBoolean();
            }
        }
    }

    private static void printInputPromptBoolean(String inputPrompt) {
        System.out.printf("%s? (y/n): ", inputPrompt);
    }

    private static void printInputErrorBoolean() {
        System.out.printf("%s. Accepts y or n.%n", INPUT_ERROR);
    }

    public static void inputBuffer() {
        System.out.print("Press enter to proceed. ");
        scanner.nextLine();
        System.out.printf("%n");
    }

}