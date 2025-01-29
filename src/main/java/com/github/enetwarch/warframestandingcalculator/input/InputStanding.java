package com.github.enetwarch.warframestandingcalculator.input;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class InputStanding {

    private final Rank[] rankRecords;
    private final int[][] standingPerRank;
    private final int userRank;

    public InputStanding(Rank[] rankRecords, int[][] standingPerRank, int userRank) {
        this.rankRecords = rankRecords;
        this.standingPerRank = standingPerRank;
        this.userRank = userRank;
    }

    public int getStanding() {
        final String rankTitle = rankRecords[userRank].rankTitle();
        final int[] validStandingRange = standingPerRank[userRank];
        final int validStandingMin = validStandingRange[0];
        final int validStandingMax = validStandingRange[1];
        System.out.printf("Rank %d %s: %,d to %,d standing%n", userRank, rankTitle, validStandingMin, validStandingMax);
        int userInput = Input.getUserInputInt("Enter your standing", validStandingMin, validStandingMax);
        Output.printSpace();
        return userInput;
    }

}