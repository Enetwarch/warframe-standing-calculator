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
import com.github.enetwarch.warframestandingcalculator.input.InputUser;

public class Main {

    private static final Calculator conclave = new Calculator(Conclave.SYNDICATE_NAME, Conclave.RANK_RECORD, Conclave.SACRIFICE_RECORD, Conclave.RESOURCE_RECORD);
    private static final Calculator ostron = new Calculator(Ostron.SYNDICATE_NAME, Ostron.RANK_RECORD, Ostron.SACRIFICE_RECORD, Ostron.RESOURCE_RECORD);
    private static final Calculator theQuills = new Calculator(TheQuills.SYNDICATE_NAME, TheQuills.RANK_RECORD, TheQuills.SACRIFICE_RECORD, TheQuills.RESOURCE_RECORD);
    private static final Calculator solarisUnited = new Calculator(SolarisUnited.SYNDICATE_NAME, SolarisUnited.RANK_RECORD, SolarisUnited.SACRIFICE_RECORD, SolarisUnited.RESOURCE_RECORD);
    private static final Calculator voxSolaris = new Calculator(VoxSolaris.SYNDICATE_NAME, VoxSolaris.RANK_RECORD, VoxSolaris.SACRIFICE_RECORD, VoxSolaris.RESOURCE_RECORD);
    private static final Calculator ventkids = new Calculator(Ventkids.SYNDICATE_NAME, Ventkids.RANK_RECORD, Ventkids.SACRIFICE_RECORD, Ventkids.RESOURCE_RECORD);
    private static final Calculator entrati = new Calculator(Entrati.SYNDICATE_NAME, Entrati.RANK_RECORD, Entrati.SACRIFICE_RECORD, Entrati.RESOURCE_RECORD);
    private static final Calculator necraloid = new Calculator(Necraloid.SYNDICATE_NAME, Necraloid.RANK_RECORD, Necraloid.SACRIFICE_RECORD, Necraloid.RESOURCE_RECORD);
    private static final Calculator theHoldfasts = new Calculator(TheHoldfasts.SYNDICATE_NAME, TheHoldfasts.RANK_RECORD, TheHoldfasts.SACRIFICE_RECORD, TheHoldfasts.RESOURCE_RECORD);
    private static final Calculator cavia = new Calculator(Cavia.SYNDICATE_NAME, Cavia.RANK_RECORD, Cavia.SACRIFICE_RECORD, Cavia.RESOURCE_RECORD);
    private static final Calculator theHex = new Calculator(TheHex.SYNDICATE_NAME, TheHex.RANK_RECORD, TheHex.SACRIFICE_RECORD, TheHex.RESOURCE_RECORD);

    private static final Interface[] INTERFACE_ARRAY = new Interface[] {
        new Interface(1, Syndicate.CONCLAVE.getSyndicate(), () -> conclave.calculateToConsole()),
        new Interface(2, Syndicate.OSTRON.getSyndicate(), () -> ostron.calculateToConsole()),
        new Interface(3, Syndicate.THE_QUILLS.getSyndicate(), () -> theQuills.calculateToConsole()),
        new Interface(4, Syndicate.SOLARIS_UNITED.getSyndicate(), () -> solarisUnited.calculateToConsole()),
        new Interface(5, Syndicate.VOX_SOLARIS.getSyndicate(), () -> voxSolaris.calculateToConsole()),
        new Interface(6, Syndicate.VENTKIDS.getSyndicate(), () -> ventkids.calculateToConsole()),
        new Interface(7, Syndicate.ENTRATI.getSyndicate(), () -> entrati.calculateToConsole()),
        new Interface(8, Syndicate.NECRALOID.getSyndicate(), () -> necraloid.calculateToConsole()),
        new Interface(9, Syndicate.THE_HOLDFASTS.getSyndicate(), () -> theHoldfasts.calculateToConsole()),
        new Interface(10, Syndicate.CAVIA.getSyndicate(), () -> cavia.calculateToConsole()),
        new Interface(11, Syndicate.THE_HEX.getSyndicate(), () -> theHex.calculateToConsole()),
        new Interface(0, "Exit Program", () -> Output.terminateProgram())
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