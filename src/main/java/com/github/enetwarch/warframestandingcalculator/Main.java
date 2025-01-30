package com.github.enetwarch.warframestandingcalculator;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.data.Syndicate;
import com.github.enetwarch.warframestandingcalculator.util.Interface;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.data.Data;

public class Main {

    private static final Interface[] INTERFACE_ARRAY = new Interface[] {
        new Interface(1, Syndicate.CONCLAVE.getSyndicate(), Data.conclaveData),
        new Interface(2, Syndicate.OSTRON.getSyndicate(), Data.ostronData),
        new Interface(3, Syndicate.THE_QUILLS.getSyndicate(), Data.theQuillsData),
        new Interface(4, Syndicate.SOLARIS_UNITED.getSyndicate(), Data.solarisUnitedData),
        new Interface(5, Syndicate.VOX_SOLARIS.getSyndicate(), Data.voxSolarisData),
        new Interface(6, Syndicate.VENTKIDS.getSyndicate(), Data.ventkidsData),
        new Interface(7, Syndicate.ENTRATI.getSyndicate(), Data.entratiData),
        new Interface(8, Syndicate.NECRALOID.getSyndicate(), Data.necraloidData),
        new Interface(9, Syndicate.THE_HOLDFASTS.getSyndicate(), Data.theHoldfastsData),
        new Interface(10, Syndicate.CAVIA.getSyndicate(), Data.caviaData),
        new Interface(11, Syndicate.THE_HEX.getSyndicate(), Data.theHexData),
        new Interface(0, "Exit Program", null)
    };

    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = INTERFACE_ARRAY.length - 1;

    public static void main(String[] args) {
        Calculator.setMasteryRank();
        while (true) {
            Interface.printInterface(INTERFACE_ARRAY);
            int userInput = Input.getUserInputInt("Choose a syndicate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            Output.printSpace();
            Data data = Interface.getData(INTERFACE_ARRAY, userInput);
            new Calculator(data).logToConsole();
            Input.inputBuffer();
        }
    }

}