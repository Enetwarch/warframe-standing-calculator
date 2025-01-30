package com.github.enetwarch.warframestandingcalculator.util;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.data.Data;

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
        System.out.print(printInterface);
    }

    public static Data getData(Interface[] interfaceArray, int userInput) {
        for (Interface interfaceElement : interfaceArray) {
            int input = interfaceElement.input;
            if (input == userInput) {
                Data data = interfaceElement.data;
                if (data != null) {
                    return data;
                } else {
                    Output.terminateProgram();
                }
            }
        }
        return null;
    }

}