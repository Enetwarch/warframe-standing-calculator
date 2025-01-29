package com.github.enetwarch.warframestandingcalculator.util;
import com.github.enetwarch.warframestandingcalculator.data.*;

public record Interface(int input, String output, Data data) {

    public Interface {
        if (input < 0) {
            throw new IllegalArgumentException("Invalid user input");
        }
    }

    public static void printInterface(Interface[] interfaceArray) {
        StringBuilder printInterface = new StringBuilder();
        for (Interface interfaceElement : interfaceArray) {
            int input = interfaceElement.input;
            String output = interfaceElement.output;
            printInterface.append(String.format("%d %s%n", input, output));
        }
        printInterface.append(String.format("0 Exit Program%n"));
        System.out.print(printInterface);
    }



    public static Data getData(Interface[] interfaceArray, int userInput) {
        for (Interface interfaceElement : interfaceArray) {
            int input = interfaceElement.input;
            if (input == userInput) {
                return interfaceElement.data;
            }
        }
        if (userInput == 0) {
            Output.terminateProgram();
        }
        return null;
    }

}