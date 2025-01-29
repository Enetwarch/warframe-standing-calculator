package com.github.enetwarch.warframestandingcalculator.calc;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.data.Resource;
import com.github.enetwarch.warframestandingcalculator.data.Sacrifice;
import com.github.enetwarch.warframestandingcalculator.data.Syndicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class Calculator {

    // Mastery Rank
    private static int masteryRank = -1;
    private static int standingCap = 16000;
    private static final int MASTERY_RANK_MIN = 0;
    private static final int MASTERY_RANK_MAX = 34;
    private static final int[][] STANDING_PER_RANK = {
        {0, 5000}, // Neutral
        {0, 22000}, // Rank 1
        {0, 44000}, // Rank 2
        {0, 70000}, // Rank 3
        {0, 99000}, // Rank 4
        {0, 132000} // Rank 5
    };

    private final String syndicateName;
    private final Rank[] rankRecord;
    private final Sacrifice[] sacrificeRecord;
    private final Resource[] resourceRecord;
    private int userRank;
    private int userStanding;
    private int[] userResource;
    private StringBuilder calculatorOutput;
    public Calculator(Syndicate syndicateName, Rank[] rankRecord, Sacrifice[] sacrificeRecord, Resource[] resourceRecord) {
        this.syndicateName = syndicateName.getSyndicate();
        this.rankRecord = rankRecord;
        this.sacrificeRecord = sacrificeRecord;
        this.resourceRecord = resourceRecord;
    }


    ////// INPUT METHODS


    public static void getMasteryRank() {
        masteryRank = Input.getUserInputInt("Enter your mastery rank", MASTERY_RANK_MIN, MASTERY_RANK_MAX);
        standingCap += masteryRank * 500; // Standing cap starts at 16000 and increases by 500 for each mastery rank.
        System.out.print("\n");
    }

    private void getRank() {
        StringBuilder getRank = new StringBuilder();
        for (Rank rank : rankRecord) {
            // Creates a list of all ranks in the syndicate.
            int rankNumber = rank.rankNumber();
            String rankTitle = rank.rankTitle();
            getRank.append(String.format("%d %s\n", rankNumber, rankTitle));
        }
        System.out.print(getRank);
        int rankMin = rankRecord[0].rankNumber();
        int rankMax = rankRecord[rankRecord.length - 1].rankNumber();
        userRank = Input.getUserInputInt("Enter your rank", rankMin, rankMax);
        System.out.print("\n");
    }

    private void getStanding() {
        int[] validStandingRange = STANDING_PER_RANK[userRank];
        int validStandingMin = validStandingRange[0];
        int validStandingMax = validStandingRange[1];
        String rankTitle = rankRecord[userRank].rankTitle();
        System.out.printf("Rank %d %s: %,d to %,d standing\n", userRank, rankTitle, validStandingMin, validStandingMax);
        userStanding = Input.getUserInputInt("Enter your standing", validStandingMin, validStandingMax);
        System.out.print("\n");
    }

    private void getResources() {
        userResource = new int[resourceRecord.length]; 
        if (userResource.length == 0) {
            return;
        }
        boolean proceedOrNot = Input.getUserInputBoolean("Would you like to enter your standing resources");
        if (!proceedOrNot) {
            System.out.print("\n");
            return;
        }
        int resourceMin = 0;
        int resourceMax = Integer.MAX_VALUE;
        for (int i = 0; i < resourceRecord.length; i++) {
            // Collects resource owned by the user for each resource in the syndicate.
            String resourceName = resourceRecord[i].resourceName();
            int resourceStanding = resourceRecord[i].resourceStanding();
            String message = String.format("%s owned (%,d standing)", resourceName, resourceStanding);
            userResource[i] = Input.getUserInputInt(message, resourceMin, resourceMax);
        }
        System.out.print("\n");
    }


    ////// OUTPUT METHODS


    private void buildOutputHeader() {
        calculatorOutput = new StringBuilder();
        calculatorOutput.append(String.format("Mastery Rank: %d\n", masteryRank));
        calculatorOutput.append(String.format("Daily Standing Cap: %,d\n", standingCap));
        calculatorOutput.append("\n");
    }

    private void calculateDaysToMax() {
        String rankTitle = rankRecord[userRank].rankTitle();
        int userRankMaxStanding = STANDING_PER_RANK[userRank][1];
        calculatorOutput.append(String.format("%s\n".toUpperCase(), syndicateName));
        calculatorOutput.append(String.format("Rank: %d %s\n", userRank, rankTitle));
        calculatorOutput.append(String.format("Standing: %,d out of %,d\n", userStanding, userRankMaxStanding));
        int maxRank = rankRecord.length - 1;
        boolean isAlreadyMax = userRank == maxRank;
        boolean edgeCase = userRank == maxRank - 1 && userStanding == userRankMaxStanding;
        if (isAlreadyMax || edgeCase) {
            if (isAlreadyMax) {
                calculatorOutput.append("Already max rank.\n");
            } else {
                // Edge case where the user is 1 rank away from max, but already has max standing.
                calculatorOutput.append("Eligible for max rank.\n");
            }
            calculatorOutput.append("\n");
            return;
        }
        int currentRank = userRank;
        int currentRankStanding = userStanding;
        int currentRankMaxStanding = userRankMaxStanding;
        int daysToMaxRank = 0;
        int standingToMaxRank = currentRankMaxStanding - currentRankStanding;
        while(true) {
            if (currentRankStanding < currentRankMaxStanding) {
                currentRankStanding += standingCap;
            } else {
                // Increases rank, resets standing while still adding daily standing gains, and sets new max standing.
                currentRank += 1;
                if (currentRank == maxRank) {
                    String pluralizedDay = Output.pluralizeNoun(daysToMaxRank);
                    calculatorOutput.append(String.format("%,d day%s with %,d standing to max.\n", daysToMaxRank, pluralizedDay, standingToMaxRank));
                    calculatorOutput.append("\n");
                    return;
                }
                currentRankStanding += standingCap - currentRankMaxStanding;
                currentRankMaxStanding = STANDING_PER_RANK[currentRank][1];
                // Tallies total standing from starting user rank to max rank.
                standingToMaxRank += currentRankMaxStanding; 
            }
            daysToMaxRank += 1;
        }
    }
    
    private void calculateSacrificesToMax() {
        boolean noSacrifices = sacrificeRecord.length == 0;
        boolean isAlreadyMax = userRank == sacrificeRecord.length; 
        if (noSacrifices || isAlreadyMax) {
            return;
        }
        Map<String, Integer> sacrificesMap = new HashMap<>();
        while(userRank < sacrificeRecord.length) {
            // This whole loop gets all the sacrifice resources based from the user rank and stores it all in a map.
            int[] sacrificeAmountArray = sacrificeRecord[userRank].sacrificeAmount();
            String[] sacrificeNameArray = sacrificeRecord[userRank].sacrificeName();
            for (int i = 0; i < sacrificeNameArray.length; i++) {
                int sacrificeAmount = sacrificeAmountArray[i];
                String sacrificeName = sacrificeNameArray[i];
                if (sacrificesMap.containsKey(sacrificeName)) {
                    // Only adds the value on the map instead of completely replacing it.
                    sacrificeAmount = sacrificesMap.get(sacrificeName) + sacrificeAmount;
                }
                sacrificesMap.put(sacrificeName, sacrificeAmount);
            }
            userRank++;
        }
        List<Map.Entry<String, Integer>> sacrificesList = new ArrayList<>(sacrificesMap.entrySet());
        // Sorts the list in ascending order based on the integer value.
        sacrificesList.sort((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()));
        String pluralizedSacrifice = Output.pluralizeNoun(sacrificesList.size()).toUpperCase();
        calculatorOutput.append(String.format("REQUIRED SACRIFICE%s\n", pluralizedSacrifice));
        for (Map.Entry<String, Integer> sacrificesMapEntry : sacrificesList) {
            // Creates a list of sacrifices and amount needed.
            int sacrificeAmount = sacrificesMapEntry.getValue();
            String sacrificeName = sacrificesMapEntry.getKey();
            String pluralizedSacrificeName = Output.pluralizeNoun(sacrificeAmount);
            calculatorOutput.append(String.format("%,d %s%s\n", sacrificeAmount, sacrificeName, pluralizedSacrificeName));
        }
        calculatorOutput.append("\n");
    }

    private void calculateResourcesDays() {
        boolean noResource = userResource.length == 0;
        boolean noUserResource = Output.arraySumInt(userResource) == 0;
        if (noResource || noUserResource) {
            return;
        }
        int resourceStandingTotal = 0;
        calculatorOutput.append("STANDING RESOURCES\n");
        for (int i = 0; i < resourceRecord.length; i++) {
            // Creates a list of resources, amount owned, and total standing it gives.
            String resourceName = resourceRecord[i].resourceName();
            int resourceOwned = userResource[i];
            int resourceStanding = resourceRecord[i].resourceStanding() * resourceOwned;
            resourceStandingTotal += resourceStanding; // Adds all standings to determine days.
            calculatorOutput.append(String.format("%s: %,d owned (%,d standing)\n", resourceName, resourceOwned, resourceStanding));
        }
        int days = resourceStandingTotal / standingCap;
        if (days > 1) {
            String pluralizedDay = Output.pluralizeNoun(days);
            calculatorOutput.append(String.format("Total: %,d standing (%,d day%s)\n", resourceStandingTotal, days, pluralizedDay));
        } else {
            // Too little total standing to determine days.
            calculatorOutput.append(String.format("Total: %,d standing\n", resourceStandingTotal));
        }
        calculatorOutput.append("\n");
    }


    ////// MAIN METHOD


    // com.github.enetwarch.warframestandingcalculator.Main instance method
    public void calculateToConsole() {
        getRank();
        getStanding();
        getResources();
        buildOutputHeader();
        calculateDaysToMax();
        calculateSacrificesToMax();
        calculateResourcesDays();
        System.out.print(calculatorOutput);
        Input.inputBuffer();
    }

}