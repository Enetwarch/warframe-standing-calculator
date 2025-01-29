package com.github.enetwarch.warframestandingcalculator.output;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;

public class OutputHeader {

    private final int standingCap;
    private final int masteryRank;

    public OutputHeader(int standingCap, int masteryRank) {
        this.standingCap = standingCap;
        this.masteryRank = masteryRank;
    }

    public void buildOutputHeader() {
        Calculator.calculatorOutput.append(String.format("Mastery Rank: %d%n", masteryRank));
        Calculator.calculatorOutput.append(String.format("Daily Standing Cap: %,d%n", standingCap));
        Calculator.calculatorOutput.append(String.format("%n"));
    }

}