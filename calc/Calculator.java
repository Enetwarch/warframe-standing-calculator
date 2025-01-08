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
    private static int MASTERY_RANK_MIN = 0;
    private static int MASTERY_RANK_MAX = 34;
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
    private static int PLEDGED_FACTION_MIN = 1;
    private static int PLEDGED_FACTION_MAX = STANDING_MULTIPLIER_LIST.length;
    // Standing per ranks
    private static final int[][] ONE_RANK_SYNDICATE_STANDING_PER_RANK = {
        // For syndicates with one rank only.
        // So far, only cephalon simaris has this standing range.
        {0, 125000} // Neutral
    };
    private static final int[][] STANDARD_SYNDICATE_STANDING_PER_RANK = {
        // For standard syndicates that have more than one rank up to 6 ranks.
        // Necraloid syndicate can use this even though it only has 4 ranks.
        {0, 5000}, // Neutral
        {0, 22000}, // Rank 1
        {0, 44000}, // Rank 2
        {0, 70000}, // Rank 3
        {0, 99000}, // Rank 4
        {0, 132000} // Rank 5
    };
    private static final int[][] FACTION_SYNDICATE_STANDING_PER_RANK = {
        // For faction syndicates that have negative standing.
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
    ///////////////////////////////////
    private final String syndicateName;
    private final Rank[] rankRecord;
    private final Sacrifice[] sacrificeRecord;
    private final Resource[] resourceRecord;
    private int[][] standingPerRank;
    private int userRank;
    private int userStanding;
    private int[] userResource;
    public Calculator(Syndicates syndicateName, Rank[] rankRecord, Sacrifice[] sacrificeRecord, Resource[] resourceRecord) {
        // Constructor for syndicate data.
        this.syndicateName = syndicateName.getSyndicate();
        this.rankRecord = rankRecord;
        this.sacrificeRecord = sacrificeRecord;
        this.resourceRecord = resourceRecord;
    }

    /////////////////////////////////////
    /// INPUT METHODS

    public static void getMasteryRank() {
        // Gets the user mastery rank.
        masteryRank = Utility.getUserInputInt("Enter your mastery rank", MASTERY_RANK_MIN, MASTERY_RANK_MAX);
        standingCap += masteryRank * 500; // Standing cap starts at 16000 and increases by 500 for each mastery rank.
        System.out.print("\n"); // Prints an empty line.
    }

    public static void getPledgedFaction() {
        // Gets the faction the user is pledged to.
        // Only gets called whent the user chooses [1] Faction Syndicates.
        pledgedFaction = Utility.getUserInputInt("Enter pledged faction", PLEDGED_FACTION_MIN, PLEDGED_FACTION_MAX);
        standingMultiplier = STANDING_MULTIPLIER_LIST[pledgedFaction - 1]; // Sets standing cap based on faction syndicate interaction.
        System.out.print("\n"); // Prints an empty line.
    }

    private static int[][] getStandingPerRank(Rank[] rankRecord) {
        int totalRanks = rankRecord.length;
        if (totalRanks >= 2 && totalRanks <= 6) {
            // Anything between 2 to 6 total ranks.
            return STANDARD_SYNDICATE_STANDING_PER_RANK;
        } else if (totalRanks == 9) {
            // Anything that has 9 ranks, which includes negative ranks.
            return FACTION_SYNDICATE_STANDING_PER_RANK;
        } else {
            // Rarest syndicate type.
            return ONE_RANK_SYNDICATE_STANDING_PER_RANK;
        }
    }

    private static int getRank(Rank[] rankRecord) {
        if (rankRecord.length == 1) {
            return 0; // Automatically returns 0 for syndicates that only have one rank.
        }
        String[] validRanks = new String[rankRecord.length];
        for (int i = 0; i < rankRecord.length; i++) {
            // Simultaneously prints the ranks and stores all rankNumbers inside validRanks for input validation.
            System.out.printf("[%s] %s\n", rankRecord[i].rankNumber(), rankRecord[i].rankTitle());
            validRanks[i] = rankRecord[i].rankNumber();
        }
        String userInput = Utility.getUserInputString("Enter your rank", validRanks);
        // Gets user string input, input validation included.
        int userRank = Arrays.asList(validRanks).indexOf(userInput);
        // Gets the index of the user input from the validRanks array.
        System.out.print("\n");
        return userRank; // Returns the user rank.
    }

    private static int getStanding(Rank[] rankRecord, int[][] standingPerRank, int userRank) {
        int[] validStandingRange = standingPerRank[userRank];
        int validStandingMin = validStandingRange[0];
        int validStandingMax = validStandingRange[1];
        // Values for valid standing inputs.
        String rankNumber = rankRecord[userRank].rankNumber();
        String rankTitle = rankRecord[userRank].rankNumber();
        // Rank title and name for printing purposes.
        System.out.printf("Rank [%s] %s: %,d to %,d standing\n", rankNumber, rankTitle, validStandingMin, validStandingMax);
        int userStanding = Utility.getUserInputInt("Enter your standing", validStandingMin, validStandingMax);
        // Prints a user prompt and asks for their input regardling their standing.
        System.out.print("\n");
        return userStanding;
    }

    private static int[] getResources(Resource[] resourceRecord) {
        if (resourceRecord.length == 0) {
            return new int[] {}; // Automatically returns an empty array if the syndicate does not have standing resources.
        }
        int[] userResource = new int[resourceRecord.length]; // Makes an array as long as the types of standing resources.
        boolean proceedOrNot = Utility.getUserInputBoolean("Would you like to enter your standing resources");
        if (!proceedOrNot) {
            // Occurs if the user does not wish to proceed with inputting resources.
            System.out.print("\n");
            return userResource; // Returns an array with an all 0 value by default due to int array initialization.
        }
        int resourceMin = 0;
        int resourceMax = Integer.MAX_VALUE;
        for (int i = 0; i < resourceRecord.length; i++) {
            String resourceName = resourceRecord[i].resourceName();
            int resourceStanding = resourceRecord[i].resourceStanding();
            String message = String.format("%s owned (%,d)", resourceName, resourceStanding);
            userResource[i] = Utility.getUserInputInt(message, resourceMin, resourceMax);
            // Prints each resource name and asks the user how much of it they own.
        }
        System.out.print("\n");
        return userResource; // Returns an array that contains all the user's input.
    }

    private static void printSampleOutput(String syndicateName, int userRank, Rank[] rankRecord, int userStanding, int[][] standingPerRank, Resource[] resourceRecord, int[] userResource) {
        System.out.printf(
            """
            %s
            Rank: %d (%s)
            Standing: %d out of %d

            Resources:
            """
            , syndicateName
            , userRank
            , rankRecord[userRank].rankTitle()
            , userStanding
            , standingPerRank[0][1]
        );
        for (int i = 0; i < resourceRecord.length; i++) {
            String resourceName = resourceRecord[i].resourceName();
            int resourceStanding = resourceRecord[i].resourceStanding();
            int resourceOwned = userResource[i];
            System.out.printf("%s owned (%d standing): %d\n", resourceName, resourceStanding, resourceOwned);
        }
        System.out.print("\n");
    }

    //////////////////////////////////
    /// FINAL METHOD

    // Final instance method
    public void calculateToConsole() {
        // Combination of all input and output methods.
        this.standingPerRank = getStandingPerRank(this.rankRecord);
        this.userRank = getRank(this.rankRecord);
        this.userStanding = getStanding(this.rankRecord, this.standingPerRank, this.userRank);
        this.userResource = getResources(this.resourceRecord);
        printSampleOutput(this.syndicateName, this.userRank, this.rankRecord, this.userStanding, this.standingPerRank, this.resourceRecord, this.userResource);
        Utility.inputBuffer();
    }

}