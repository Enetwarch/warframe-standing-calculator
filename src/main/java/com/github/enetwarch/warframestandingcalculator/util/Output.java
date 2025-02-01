package com.github.enetwarch.warframestandingcalculator.util;

public class Output {

    public static final String EXIT_PROGRAM = "Exit Program";

    public static void printSpace() {
        System.out.printf("%n");
    }

    public static String pluralizeNoun(int amount) {
        if (amount != 1) {
            return "s";
        } else {
            return "";
        }
    }

    public static void terminateProgram() {
        System.out.printf("Warframe Standing Calculator%n");
        System.out.printf("Code by: Enetwarch%n");
        Input.scanner.close();
        System.exit(0);
    }

}