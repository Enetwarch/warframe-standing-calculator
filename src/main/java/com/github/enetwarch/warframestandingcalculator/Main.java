package com.github.enetwarch.warframestandingcalculator;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.data.Syndicate;
import com.github.enetwarch.warframestandingcalculator.util.Interface;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.data.Data;

public class Main {

    public static void main(String[] args) {
        final Interface[] interfaceRecords = new Interface[] {
            new Interface(1, Syndicate.CONCLAVE.getSyndicate(), Data.getConclaveData()),
            new Interface(2, Syndicate.OSTRON.getSyndicate(), Data.getOstronData()),
            new Interface(3, Syndicate.THE_QUILLS.getSyndicate(), Data.getTheQuillsData()),
            new Interface(4, Syndicate.SOLARIS_UNITED.getSyndicate(), Data.getSolarisUnitedData()),
            new Interface(5, Syndicate.VOX_SOLARIS.getSyndicate(), Data.getVoxSolarisData()),
            new Interface(6, Syndicate.VENTKIDS.getSyndicate(), Data.getVentkidsData()),
            new Interface(7, Syndicate.ENTRATI.getSyndicate(), Data.getEntratiData()),
            new Interface(8, Syndicate.NECRALOID.getSyndicate(), Data.getNecraloidData()),
            new Interface(9, Syndicate.THE_HOLDFASTS.getSyndicate(), Data.getTheHoldfastsData()),
            new Interface(10, Syndicate.CAVIA.getSyndicate(), Data.getCaviaData()),
            new Interface(11, Syndicate.THE_HEX.getSyndicate(), Data.getTheHexData()),
            new Interface(0, Output.EXIT_PROGRAM, null)
        };
        final int syndicateOptionsMin = Interface.getInputMin(interfaceRecords);
        final int syndicateOptionsMax = Interface.getInputMax(interfaceRecords);
        Calculator.setMasteryRank();
        while (true) {
            Interface.printInterface(interfaceRecords);
            final int userInput = Input.getUserInputInt("Choose a syndicate", syndicateOptionsMin, syndicateOptionsMax);
            Output.printSpace();
            final Data data = Interface.getData(interfaceRecords, userInput);
            new Calculator(data).logToConsole();
            Input.inputBuffer();
        }
    }

}