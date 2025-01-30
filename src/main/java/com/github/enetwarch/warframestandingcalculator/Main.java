package com.github.enetwarch.warframestandingcalculator;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.data.Conclave;
import com.github.enetwarch.warframestandingcalculator.data.Ostron;
import com.github.enetwarch.warframestandingcalculator.data.TheQuills;
import com.github.enetwarch.warframestandingcalculator.data.SolarisUnited;
import com.github.enetwarch.warframestandingcalculator.data.VoxSolaris;
import com.github.enetwarch.warframestandingcalculator.data.Ventkids;
import com.github.enetwarch.warframestandingcalculator.data.Entrati;
import com.github.enetwarch.warframestandingcalculator.data.Necraloid;
import com.github.enetwarch.warframestandingcalculator.data.TheHoldfasts;
import com.github.enetwarch.warframestandingcalculator.data.Cavia;
import com.github.enetwarch.warframestandingcalculator.data.TheHex;
import com.github.enetwarch.warframestandingcalculator.data.Syndicate;
import com.github.enetwarch.warframestandingcalculator.util.Interface;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.calc.input.InputUser;

public class Main {

    private static final Interface[] INTERFACE_ARRAY = new Interface[] {
        new Interface(1, Syndicate.CONCLAVE.getSyndicate(), new Calculator(new Conclave())::calculateToConsole),
        new Interface(2, Syndicate.OSTRON.getSyndicate(), new Calculator(new Ostron())::calculateToConsole),
        new Interface(3, Syndicate.THE_QUILLS.getSyndicate(), new Calculator(new TheQuills())::calculateToConsole),
        new Interface(4, Syndicate.SOLARIS_UNITED.getSyndicate(), new Calculator(new SolarisUnited())::calculateToConsole),
        new Interface(5, Syndicate.VOX_SOLARIS.getSyndicate(), new Calculator(new VoxSolaris())::calculateToConsole),
        new Interface(6, Syndicate.VENTKIDS.getSyndicate(), new Calculator(new Ventkids())::calculateToConsole),
        new Interface(7, Syndicate.ENTRATI.getSyndicate(), new Calculator(new Entrati())::calculateToConsole),
        new Interface(8, Syndicate.NECRALOID.getSyndicate(), new Calculator(new Necraloid())::calculateToConsole),
        new Interface(9, Syndicate.THE_HOLDFASTS.getSyndicate(), new Calculator(new TheHoldfasts())::calculateToConsole),
        new Interface(10, Syndicate.CAVIA.getSyndicate(), new Calculator(new Cavia())::calculateToConsole),
        new Interface(11, Syndicate.THE_HEX.getSyndicate(), new Calculator(new TheHex())::calculateToConsole),
        new Interface(0, Output.EXIT_PROGRAM, Output::terminateProgram)
    };

    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = INTERFACE_ARRAY.length - 1;

    public static void main(String[] args) {
        Calculator.setMasteryRank(InputUser.getMasteryRank());
        while (true) {
            Interface.printInterface(INTERFACE_ARRAY);
            int userInput = Input.getUserInputInt("Choose a syndicate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            Output.printSpace();
            Interface.inputRunnable(INTERFACE_ARRAY, userInput);
            Input.inputBuffer();
        }
    }

}