package com.github.enetwarch.warframestandingcalculator.util;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.data.Data;

public record Interface(int input, String output, Data data) {

    public Interface {
        if (input < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }

    public static int getInputMin(Interface[] interfaceRecords) {
        int inputMin = interfaceRecords[0].input;
        for (Interface interfaceRecord : interfaceRecords) {
            final int input = interfaceRecord.input;
            if (input < inputMin) {
                inputMin = input;
            }
        }
        return inputMin;
    }

    public static int getInputMax(Interface[] interfaceRecords) {
        int inputMax = interfaceRecords[0].input;
        for (Interface interfaceRecord : interfaceRecords) {
            final int input = interfaceRecord.input;
            if (input > inputMax) {
                inputMax = input;
            }
        }
        return inputMax;
    }

    public static void printInterface(Interface[] interfaceRecords) {
        final StringBuilder printInterface = new StringBuilder();
        for (Interface interfaceRecord : interfaceRecords) {
            final int input = interfaceRecord.input;
            final String output = interfaceRecord.output;
            printInterface.append(String.format("%d %s%n", input, output));
        }
        System.out.print(printInterface);
    }

    public static Data getData(Interface[] interfaceRecords, int userInput) {
        for (Interface interfaceRecord : interfaceRecords) {
            final int input = interfaceRecord.input;
            if (input == userInput) {
                Data data = interfaceRecord.data;
                if (data != null) {
                    return data;
                } else {
                    Output.terminateProgram();
                }
            }
        }
        throw new IllegalArgumentException("Invalid data.");
    }

}