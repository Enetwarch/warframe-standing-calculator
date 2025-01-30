package com.github.enetwarch.warframestandingcalculator.calc.input;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class InputRank {

    private final Rank[] rankRecords;

    public InputRank(Rank[] rankRecords) {
        this.rankRecords = rankRecords;
    }

    private void printRankRecords() {
        final StringBuilder printRankRecords = new StringBuilder();
        for (Rank rankRecord : rankRecords) {
            final int rankNumber = rankRecord.rankNumber();
            final String rankTitle = rankRecord.rankTitle();
            printRankRecords.append(String.format("%d %s%n", rankNumber, rankTitle));
        }
        System.out.print(printRankRecords);
    }

    public int getRank() {
        printRankRecords();
        final int rankMin = rankRecords[0].rankNumber();
        final int rankMax = rankRecords[rankRecords.length - 1].rankNumber();
        final int userInput = Input.getUserInputInt("Enter your rank", rankMin, rankMax);
        Output.printSpace();
        return userInput;
    }

}