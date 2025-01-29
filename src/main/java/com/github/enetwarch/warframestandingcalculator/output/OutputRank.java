package com.github.enetwarch.warframestandingcalculator.output;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class OutputRank {

    private final Rank[] rankRecords;
    private final String syndicateName;
    private final int[][] standingPerRank;
    private final int standingCap;
    private int userStanding;
    private int userRank;

    public OutputRank(Rank[] rankRecords, String syndicateName, int[][] standingPerRank, int standingCap, int userStanding, int userRank) {
        this.rankRecords = rankRecords;
        this.syndicateName = syndicateName;
        this.standingPerRank = standingPerRank;
        this.standingCap = standingCap;
        this.userStanding = userStanding;
        this.userRank = userRank;
    }

    private boolean proceedOrNot(int maxRank, int userRankMaxStanding) {
        final boolean isAlreadyMax = userRank == maxRank;
        final boolean edgeCase = userRank == maxRank - 1 && userStanding == userRankMaxStanding;
        if (isAlreadyMax || edgeCase) {
            buildEdgeFooter(isAlreadyMax);
            return false;
        } else {
            return true;
        }
    }

    private void buildHeader() {
        Calculator.calculatorOutput.append(String.format("%s%n", syndicateName.toUpperCase()));
    }

    private void buildBody(int userRankMaxStanding) {
        final String rankTitle = rankRecords[userRank].rankTitle();
        Calculator.calculatorOutput.append(String.format("Rank: %d %s%n", userRank, rankTitle));
        Calculator.calculatorOutput.append(String.format("Standing: %,d out of %,d%n", userStanding, userRankMaxStanding));
    }

    private void buildFooter(int userRankMaxStanding, int maxRank) {
        int daysToMaxRank = 0;
        int standingToMaxRank = userRankMaxStanding - userStanding;
        while(true) {
            if (userStanding < userRankMaxStanding) {
                userStanding += standingCap;
            } else {
                userRank += 1;
                if (userRank == maxRank) {
                    final String pluralizedDay = Output.pluralizeNoun(daysToMaxRank);
                    Calculator.calculatorOutput.append(String.format("%,d day%s with %,d standing to max.%n", daysToMaxRank, pluralizedDay, standingToMaxRank));
                    return;
                }
                userStanding += standingCap - userRankMaxStanding;
                userRankMaxStanding = standingPerRank[userRank][1];
                standingToMaxRank += userRankMaxStanding;
            }
            daysToMaxRank += 1;
        }
    }

    private void buildEdgeFooter(boolean isAlreadyMax) {
        if (isAlreadyMax) {
            Calculator.calculatorOutput.append(String.format("Already max rank.%n"));
        } else {
            Calculator.calculatorOutput.append(String.format("Eligible for max rank.%n"));
        }
        Calculator.calculatorOutput.append(String.format("%n"));
    }

    public void buildOutputRank() {
        int userRankMaxStanding = standingPerRank[userRank][1];
        final int maxRank = rankRecords.length - 1;
        buildHeader();
        buildBody(userRankMaxStanding);
        if (!proceedOrNot(maxRank, userRankMaxStanding)) {
            return;
        }
        buildFooter(userRankMaxStanding, maxRank);
        Calculator.calculatorOutput.append(String.format("%n"));
    }

}