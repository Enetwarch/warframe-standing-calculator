package calc;
import data.Data.Rank;
import data.Data.Resource;
import data.Data.Sacrifice;
import data.Data.Syndicates;
import java.util.Arrays;
import util.Utility;

public class Calculator {

    // Mastery Rank
    private static int masteryRank = -1;
    private static int standingCap = 16000;
    private static final int MASTERY_RANK_MIN = 0;
    private static final int MASTERY_RANK_MAX = 34;

    // Faction Syndicates
    private static int pledgedFaction = -1;
    private static double[] standingMultiplier = {0, 0, 0, 0, 0, 0};
    private static final double[][] STANDING_MULTIPLIER_LIST = {
        {1.00, 0, 0, -1.00, 0.50, -0.50}, // Steel Meridian
        {0, 1.00, 0.50, -0.50, -1.00, 0}, // Arbiters of Hexis
        {0, 0.50, 1.00, 0, -0.50, -1.00}, // Cephalon Suda
        {-1.00, -0.50, 0, 1.00, 0, 0.50}, // The Perrin Sequence
        {0.50, -1.00, -0.50, 0, 1.00, 0}, // Red Veil
        {-0.50, 0, -1.00, 0.50, 0, 1.00} // New Loka
    };
    private static final int PLEDGED_FACTION_MIN = 1;
    private static final int PLEDGED_FACTION_MAX = STANDING_MULTIPLIER_LIST.length;

    // Standing per ranks
    private static final int[][] ONE_RANK_SYNDICATE_STANDING_PER_RANK = {
        {0, 125000} // Neutral
    };
    private static final int[][] STANDARD_SYNDICATE_STANDING_PER_RANK = {
        {0, 5000}, // Neutral
        {0, 22000}, // Rank 1
        {0, 44000}, // Rank 2
        {0, 70000}, // Rank 3
        {0, 99000}, // Rank 4
        {0, 132000} // Rank 5
    };
    private static final int[][] FACTION_SYNDICATE_STANDING_PER_RANK = {
        {-44000, 0}, // Rank -2
        {-22000, 0}, // Rank -1
        {-5000, 5000}, // Neutral
        {0, 5000}, // Rank 0
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
    private int[][] standingPerRank;
    private int userRank;
    private int userStanding;
    private int[] userResource;
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

    public static void getPledgedFaction() {
        pledgedFaction = Utility.getUserInputInt("Enter pledged faction", PLEDGED_FACTION_MIN, PLEDGED_FACTION_MAX);
        int pledgedFactionIndex = pledgedFaction - 1;
        standingMultiplier = STANDING_MULTIPLIER_LIST[pledgedFactionIndex];
        System.out.print("\n"); 
    }

    private static int[][] getStandingPerRank(Rank[] rankRecord) {
        int totalRanks = rankRecord.length;
        if (totalRanks >= 2 && totalRanks <= 6) {
            return STANDARD_SYNDICATE_STANDING_PER_RANK;
        } else if (totalRanks == 9) {
            return FACTION_SYNDICATE_STANDING_PER_RANK;
        } else {
            return ONE_RANK_SYNDICATE_STANDING_PER_RANK;
        }
    }

    private static int getRank(Rank[] rankRecord) {
        if (rankRecord.length == 1) {
            return 0;
        }
        String[] validRanks = new String[rankRecord.length];
        for (int i = 0; i < rankRecord.length; i++) {
            String rankNumber = rankRecord[i].rankNumber();
            String rankTitle = rankRecord[i].rankTitle();
            System.out.printf("[%s] %s\n", rankNumber, rankTitle);
            validRanks[i] = rankNumber;
        }
        String userInput = Utility.getUserInputString("Enter your rank", validRanks);
        int userRank = Arrays.asList(validRanks).indexOf(userInput);
        System.out.print("\n");
        return userRank;
    }

    private static int getStanding(Rank[] rankRecord, int[][] standingPerRank, int userRank) {
        int[] validStandingRange = standingPerRank[userRank];
        int validStandingMin = validStandingRange[0];
        int validStandingMax = validStandingRange[1];
        String rankNumber = rankRecord[userRank].rankNumber();
        String rankTitle = rankRecord[userRank].rankTitle();
        System.out.printf("Rank [%s] %s: %,d to %,d standing\n", rankNumber, rankTitle, validStandingMin, validStandingMax);
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


    private static void printOutputHeader(int masteryRank, int standingCap, String syndicateName) {
        StringBuilder outputHeader = new StringBuilder();
        outputHeader.append(String.format("Mastery Rank: %d\n", masteryRank));
        outputHeader.append(String.format("Daily Standing Cap: %,d\n", standingCap));
        outputHeader.append(String.format("Syndicate output for %s\n", syndicateName));
        outputHeader.append("\n");
        System.out.print(outputHeader);
    }

    private static void calculateDaysToMax(Rank[] rankRecord, int userRank, int userStanding, int[][] standingPerRank) {
        String rankNumber = rankRecord[userRank].rankNumber();
        String rankTitle = rankRecord[userRank].rankTitle();
        int userRankMaxStanding = standingPerRank[userRank][1];
        StringBuilder daysToMax = new StringBuilder();
        daysToMax.append(String.format("Rank: [%s] %s\n", rankNumber, rankTitle));
        daysToMax.append(String.format("Standing: %,d out of %,d\n", userStanding, userRankMaxStanding));
        int maxRank = rankRecord.length - 1;
        boolean isAlreadyMax = userRank == maxRank;
        boolean edgeCase = userRank == maxRank - 1 && userStanding == userRankMaxStanding;
        if (isAlreadyMax || edgeCase) {
            if (isAlreadyMax) {
                daysToMax.append("You are already max rank.\n");
            } else {
                daysToMax.append("You are already eligible for max rank.\n");
            }
            daysToMax.append("\n");
            System.out.print(daysToMax);
            return;
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
                    daysToMax.append(String.format("It will take %d day%s with %,d standing to reach max rank\n", daysToMaxRank, pluralizedDay, standingToMaxRank));
                    daysToMax.append("\n");
                    System.out.print(daysToMax);
                    return;
                }
                currentRankStanding += standingCap - currentRankMaxStanding;
                currentRankMaxStanding = standingPerRank[currentRank][1];
                standingToMaxRank += currentRankStanding;
            }
        }
    }


    ////// MAIN METHOD


    // Main instance method
    public void calculateToConsole() {
        this.standingPerRank = getStandingPerRank(this.rankRecord);
        this.userRank = getRank(this.rankRecord);
        this.userStanding = getStanding(this.rankRecord, this.standingPerRank, this.userRank);
        this.userResource = getResources(this.resourceRecord);
        printOutputHeader(masteryRank, standingCap, this.syndicateName);
        calculateDaysToMax(this.rankRecord, this.userRank, this.userStanding, this.standingPerRank);
        Utility.inputBuffer();
    }

}