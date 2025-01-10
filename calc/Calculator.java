package calc;
import data.Data.Rank;
import data.Data.Resource;
import data.Data.Sacrifice;
import data.Data.Syndicates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Utility;

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
    public Calculator(Syndicates syndicateName, Rank[] rankRecord, Sacrifice[] sacrificeRecord, Resource[] resourceRecord) {
        this.syndicateName = syndicateName.getSyndicate();
        this.rankRecord = rankRecord;
        this.sacrificeRecord = sacrificeRecord;
        this.resourceRecord = resourceRecord;
    }


    ////// INPUT METHODS


    public static void getMasteryRank() {
        masteryRank = Utility.getUserInputInt("Enter your mastery rank", MASTERY_RANK_MIN, MASTERY_RANK_MAX);
        standingCap += masteryRank * 500; // Standing cap starts at 16000 and increases by 500 for each mastery rank.
        System.out.print("\n");
    }

    private static int getRank(Rank[] rankRecord) {
        StringBuilder getRank = new StringBuilder();
        for (Rank rank : rankRecord) {
            int rankNumber = rank.rankNumber();
            String rankTitle = rank.rankTitle();
            getRank.append(String.format("%d %s\n", rankNumber, rankTitle));
        }
        System.out.print(getRank);
        int rankMin = rankRecord[0].rankNumber();
        int rankMax = rankRecord[rankRecord.length - 1].rankNumber();
        int userRank = Utility.getUserInputInt("Enter your rank", rankMin, rankMax);
        System.out.print("\n");
        return userRank;
    }

    private static int getStanding(Rank[] rankRecord, int[][] standingPerRank, int userRank) {
        int[] validStandingRange = standingPerRank[userRank];
        int validStandingMin = validStandingRange[0];
        int validStandingMax = validStandingRange[1];
        String rankTitle = rankRecord[userRank].rankTitle();
        System.out.printf("Rank %d %s: %,d to %,d standing\n", userRank, rankTitle, validStandingMin, validStandingMax);
        int userStanding = Utility.getUserInputInt("Enter your standing", validStandingMin, validStandingMax);
        System.out.print("\n");
        return userStanding;
    }

    private static int[] getResources(Resource[] resourceRecord) {
        if (resourceRecord.length == 0) {
            return new int[] {}; 
        }
        int[] userResource = new int[resourceRecord.length]; 
        boolean proceedOrNot = Utility.getUserInputBoolean("Would you like to enter your standing resources");
        if (!proceedOrNot) {
            System.out.print("\n");
            return userResource;
        }
        int resourceMin = 0;
        int resourceMax = Integer.MAX_VALUE;
        for (int i = 0; i < resourceRecord.length; i++) {
            String resourceName = resourceRecord[i].resourceName();
            int resourceStanding = resourceRecord[i].resourceStanding();
            String message = String.format("%s owned (%,d standing)", resourceName, resourceStanding);
            userResource[i] = Utility.getUserInputInt(message, resourceMin, resourceMax);
        }
        System.out.print("\n");
        return userResource; 
    }


    ////// OUTPUT METHODS


    private static StringBuilder printOutputHeader(int masteryRank, int standingCap) {
        StringBuilder calculatorOutput = new StringBuilder();
        calculatorOutput.append(String.format("Mastery Rank: %d\n", masteryRank));
        calculatorOutput.append(String.format("Daily Standing Cap: %,d\n", standingCap));
        calculatorOutput.append("\n");
        return calculatorOutput;
    }

    private static StringBuilder calculateDaysToMax(StringBuilder calculatorOutput, Rank[] rankRecord, String syndicateName, int userRank, int userStanding, int[][] standingPerRank) {
        String rankTitle = rankRecord[userRank].rankTitle();
        int userRankMaxStanding = standingPerRank[userRank][1];
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
                calculatorOutput.append("Eligible for max rank.\n");
            }
            calculatorOutput.append("\n");
            return calculatorOutput;
        }
        int currentRank = userRank;
        int currentRankStanding = userStanding;
        int currentRankMaxStanding = userRankMaxStanding;
        int daysToMaxRank = 0;
        int standingToMaxRank = currentRankMaxStanding - currentRankStanding;
        while(true) {
            daysToMaxRank += 1; 
            if (currentRankStanding < currentRankMaxStanding) {
                currentRankStanding += standingCap;
            } else {
                currentRank += 1;
                if (currentRank == maxRank) {
                    String pluralizedDay = Utility.pluralizeNoun(daysToMaxRank);
                    calculatorOutput.append(String.format("%,d day%s with %,d standing to max.\n", daysToMaxRank, pluralizedDay, standingToMaxRank));
                    calculatorOutput.append("\n");
                    return calculatorOutput;
                }
                currentRankStanding += standingCap - currentRankMaxStanding;
                currentRankMaxStanding = standingPerRank[currentRank][1];
                standingToMaxRank += currentRankMaxStanding;
            }
        }
    }
    
    private static StringBuilder calculateSacrificesToMax(StringBuilder calculatorOutput, Sacrifice[] sacrificeRecord, int userRank) {
        boolean noSacrifices = sacrificeRecord.length == 0;
        boolean isAlreadyMax = userRank == sacrificeRecord.length; 
        if (noSacrifices || isAlreadyMax) {
            return calculatorOutput;
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
                    // Only adds the value instead of completely replacing it.
                    sacrificeAmount = sacrificesMap.get(sacrificeName) + sacrificeAmount;
                }
                sacrificesMap.put(sacrificeName, sacrificeAmount);
            }
            userRank++;
        }
        List<Map.Entry<String, Integer>> sacrificesList = new ArrayList<>(sacrificesMap.entrySet());
        // Sorts the list in ascending order based on the integer value.
        sacrificesList.sort((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()));
        String pluralizedSacrifice = Utility.pluralizeNoun(sacrificesList.size()).toUpperCase();
        calculatorOutput.append(String.format("REQUIRED SACRIFICE%s\n", pluralizedSacrifice));
        for (Map.Entry<String, Integer> sacrificesMapEntry : sacrificesList) {
            int sacrificeAmount = sacrificesMapEntry.getValue();
            String sacrificeName = sacrificesMapEntry.getKey();
            String pluralizedSacrificeName = Utility.pluralizeNoun(sacrificeAmount);
            calculatorOutput.append(String.format("%,d %s%s\n", sacrificeAmount, sacrificeName, pluralizedSacrificeName));
        }
        calculatorOutput.append("\n");
        return calculatorOutput;
    }

    private static StringBuilder calculateResourcesDays(StringBuilder calculatorOutput, Resource[] resourceRecord, int[] userResource) {
        boolean noResource = resourceRecord.length == 0;
        boolean noUserResource = Utility.arraySumInt(userResource) == 0;
        if (noResource || noUserResource) {
            return calculatorOutput;
        }
        int[] resourceStandingTotal = new int[resourceRecord.length];
        calculatorOutput.append("STANDING RESOURCES\n");
        for (int i = 0; i < resourceRecord.length; i++) {
            String resourceName = resourceRecord[i].resourceName();
            int resourceOwned = userResource[i];
            int resourceStanding = resourceRecord[i].resourceStanding() * resourceOwned;
            resourceStandingTotal[i] = resourceStanding;
            calculatorOutput.append(String.format("%s: %,d owned (%,d standing)\n", resourceName, resourceOwned, resourceStanding));
        }
        int resourceStandingTotalSum = Utility.arraySumInt(resourceStandingTotal);
        int days = resourceStandingTotalSum / standingCap;
        if (days > 1) {
            String pluralizedDay = Utility.pluralizeNoun(days);
            calculatorOutput.append(String.format("Total: %,d standing (%,d day%s)\n", resourceStandingTotalSum, days, pluralizedDay));
        } else {
            calculatorOutput.append(String.format("Total: %,d standing\n", resourceStandingTotalSum));
        }
        calculatorOutput.append("\n");
        return calculatorOutput;
    }


    ////// MAIN METHOD


    // Main instance method
    public void calculateToConsole() {
        this.userRank = getRank(this.rankRecord);
        this.userStanding = getStanding(this.rankRecord, STANDING_PER_RANK, this.userRank);
        this.userResource = getResources(this.resourceRecord);
        this.calculatorOutput = printOutputHeader(masteryRank, standingCap);
        this.calculatorOutput = calculateDaysToMax(this.calculatorOutput, this.rankRecord, this.syndicateName, this.userRank, this.userStanding, STANDING_PER_RANK);
        this.calculatorOutput = calculateSacrificesToMax(this.calculatorOutput, this.sacrificeRecord, this.userRank);
        this.calculatorOutput = calculateResourcesDays(this.calculatorOutput, this.resourceRecord, this.userResource);
        System.out.print(this.calculatorOutput);
        Utility.inputBuffer();
    }

}