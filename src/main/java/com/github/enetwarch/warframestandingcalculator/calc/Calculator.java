package com.github.enetwarch.warframestandingcalculator.calc;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.data.Resource;
import com.github.enetwarch.warframestandingcalculator.data.Sacrifice;
import com.github.enetwarch.warframestandingcalculator.data.Data;
import com.github.enetwarch.warframestandingcalculator.input.InputRank;
import com.github.enetwarch.warframestandingcalculator.input.InputStanding;
import com.github.enetwarch.warframestandingcalculator.input.InputResources;
import com.github.enetwarch.warframestandingcalculator.output.OutputHeader;
import com.github.enetwarch.warframestandingcalculator.output.OutputRank;
import com.github.enetwarch.warframestandingcalculator.output.OutputSacrifices;
import com.github.enetwarch.warframestandingcalculator.output.OutputResources;

public class Calculator {

    private final String syndicateName;
    private final Rank[] rankRecords;
    private final Sacrifice[] sacrificeRecords;
    private final Resource[] resourceRecords;

    public Calculator(Data syndicateData) {
        this.syndicateName = syndicateData.getSyndicateName();
        this.rankRecords = syndicateData.getRankRecord();
        this.sacrificeRecords = syndicateData.getSacrificeRecord();
        this.resourceRecords = syndicateData.getResourceRecord();
    }

    public static StringBuilder calculatorOutput = new StringBuilder();

    private static final int[][] standingPerRank = {
        {0, 5000}, // Neutral
        {0, 22000}, // Rank 1
        {0, 44000}, // Rank 2
        {0, 70000}, // Rank 3
        {0, 99000}, // Rank 4
        {0, 132000} // Rank 5
    };

    private static int standingCap = 16000;
    private static int masteryRank = -1;

    public static void setMasteryRank(int masteryRankValue) {
        masteryRank = masteryRankValue;
        standingCap += masteryRank * 500;
    }

    public void calculateToConsole() {
        final int userRank = new InputRank(rankRecords).getRank();
        final int userStanding = new InputStanding(rankRecords, standingPerRank, userRank).getStanding();
        final int[] userResources = new InputResources(resourceRecords).getResources();
        new OutputHeader(standingCap, masteryRank).buildOutputHeader();
        new OutputRank(rankRecords, syndicateName, standingPerRank, standingCap, userStanding, userRank).buildOutputRank();
        new OutputSacrifices(sacrificeRecords, userRank).buildOutputSacrifices();
        new OutputResources(resourceRecords, userResources, standingCap).buildOutputResources();
        System.out.print(calculatorOutput);
        calculatorOutput = new StringBuilder();
    }

}