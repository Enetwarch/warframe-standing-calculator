package com.github.enetwarch.warframestandingcalculator;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.data.Data;
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

    private static final Interface[] INTERFACE_ARRAY = new Interface[] {
            new Interface(1, Syndicate.CONCLAVE.getSyndicate(), new Conclave()),
            new Interface(2, Syndicate.OSTRON.getSyndicate(), new Ostron()),
            new Interface(3, Syndicate.THE_QUILLS.getSyndicate(), new TheQuills()),
            new Interface(4, Syndicate.SOLARIS_UNITED.getSyndicate(), new SolarisUnited()),
            new Interface(5, Syndicate.VOX_SOLARIS.getSyndicate(), new VoxSolaris()),
            new Interface(6, Syndicate.VENTKIDS.getSyndicate(), new Ventkids()),
            new Interface(7, Syndicate.ENTRATI.getSyndicate(), new Entrati()),
            new Interface(8, Syndicate.NECRALOID.getSyndicate(), new Necraloid()),
            new Interface(9, Syndicate.THE_HOLDFASTS.getSyndicate(), new TheHoldfasts()),
            new Interface(10, Syndicate.CAVIA.getSyndicate(), new Cavia()),
            new Interface(11, Syndicate.THE_HEX.getSyndicate(), new TheHex()),
    };

    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = INTERFACE_ARRAY.length - 1;

    public static void main(String[] args) {
        Calculator.setMasteryRank(InputUser.getMasteryRank());
        while (true) {
            Interface.printInterface(INTERFACE_ARRAY);
            int userInput = Input.getUserInputInt("Choose a syndicate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            Output.printSpace();
            Data data = Interface.getData(INTERFACE_ARRAY, userInput);
            assert data != null;
            new Calculator(data).calculateToConsole();
            Input.inputBuffer();
        }
    }

}