package calculator;
import data.Format;
import data.Syndicates;
import java.util.ArrayList;

public class Standard {

    private String syndicateName;
    private String[] rankTitles;
    private String[][] rankSacrificeNames;
    private int[][] rankSacrificeAmount;
    private String[] resourceNames;
    private int[] resourceStanding;
    private int[] resourceOwned;
    private int userRank;
    private int userStanding;
    private int rankMax;
    private int standingMax;
    //////////////////////////////////////////////////////////////////////////////////
    private static int[] standingPerRank = {5000, 22000, 44000, 70000, 99000, 132000};
    private static int standingCap = Syndicates.standingCap;
    private static int rankMin = 0;
    private static int standingMin = 0;
    private static int resourceMin = 0;
    private static int resourceMax = Integer.MAX_VALUE;

    public Standard(String syndicateName, String[] rankTitles, String[][] rankSacrificeNames, int[][] rankSacrificeAmount, String[] resourceNames, int[] resourceStanding) { 
        // Constructor for standard syndicates.
        this.syndicateName = syndicateName;
        this.rankTitles = rankTitles;
        this.rankSacrificeNames = rankSacrificeNames;
        this.rankSacrificeAmount = rankSacrificeAmount;
        this.resourceNames = resourceNames;
        this.resourceStanding = resourceStanding;
        this.resourceOwned = new int[resourceNames.length];
        this.userRank = 0;
        this.userStanding = 0;
        this.rankMax = this.rankTitles.length;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////


    // Input methods
    private static int getRank(String[] rankTitles, String syndicateName, int rankMin, int rankMax) {
        Format.printArray(rankTitles, rankMin);
        int userInput = Format.getUserInput(syndicateName + " rank", rankMin, rankMax);
        return userInput; // Gets the user rank.
    }

    private static int getStanding(String syndicateName, int[] standingPerRank, int userRank, int standingMin, int standingMax) {
        int userInput = Format.getUserInput(syndicateName + " standing", standingMin, standingMax);
        return userInput; // Gets the user standing.
    }

    public static int[] getResources(String[] resourceNames, int resourceMin, int resourceMax) {
        if (resourceNames.length == 0) {
            return new int[]{}; // Returns an empty int array if there are no resources for that particular syndicate.
        }
        int[] resourceOwned = new int[resourceNames.length];
        for (int i = 0; i < resourceNames.length; i++)
        resourceOwned[i] = Format.getUserInput(resourceNames[i] + " owned", resourceMin, resourceMax);
        return resourceOwned; // Asks the user how many of each standing resources they have.
    }


    ///////////////////////////////////////////////////////////////////////////////////////////


    // Output method #1
    private static void analyzeDaysToMax(int userRank, String[] rankTitles, int userStanding) {
        if (userRank == rankTitles.length - 1) {
            System.out.print("You are already max rank in this syndicate.\n");
            return; // Quits rank calculation if already maxed.
        }
        int days = 0;
        while (userRank != rankTitles.length - 1) {
            days += 1;
            // Increases days by 1 for each iteration.
            if (standingPerRank[userRank] > userStanding + standingCap) {
                userStanding += standingCap; // Daily standing cap is added to user standing if it won't reach the rank cap yet.
            } else {
                userStanding = userStanding + standingCap - standingPerRank[userRank];
                userRank += 1; // Rank increases if standing reaches the rank cap. 
            }
        }
        String isPlural = Format.pluralizeDays(days); // Adds an "s" to days if it is more than 1.
        System.out.printf("It will take %d day%s to max out your rank.\n", days, isPlural);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Output method #2
    public static void analyzeResourcesToMax(int userRank, String[] rankTitles, String[][] rankSacrificeNames, int[][] rankSacrificeAmount) {
        if (rankSacrificeNames.length == 0) {
            return; // Returns if there is no sacrifice resources required at all.
        } else if (userRank == rankTitles.length - 1) {
            return; // Returns if the user rank is max.
        } 
        ArrayList<String> sacrificeNames = new ArrayList<>();
        ArrayList<Integer> sacrificeAmount = new ArrayList<>();
        // Creates dynamic arrays for adding in the sacrifice resources and their quantity.
        for (int i = userRank; i < rankSacrificeNames.length; i++) {
            // Loops through each inner array.
            for (int j = 0; j < rankSacrificeNames[i].length; j++) {
                // Loops through the contents of the inner array.
                String sacrificeNameString = rankSacrificeNames[i][j];
                int sacrificeAmountInt = rankSacrificeAmount[i][j];
                // Contents of the inner array in the current iteration.
                if (sacrificeNames.contains(sacrificeNameString)) {
                    int index = sacrificeNames.indexOf(sacrificeNameString);
                    sacrificeAmount.set(index, sacrificeAmount.get(index) + sacrificeAmountInt);
                    // Triggers when the current content of the inner array is already in the dynamic array.
                    // Only increases the integer amount of the content and does not add more elements. 
                } else {
                    sacrificeNames.add(sacrificeNameString);
                    sacrificeAmount.add(sacrificeAmountInt);
                    // Adds an element in each of the dynamic arrays.
                }
            }
        }
        int[] sacrificeAmountArray = new int[sacrificeAmount.size()];
        for (int i = 0; i < sacrificeAmount.size(); i++) {
            sacrificeAmountArray[i] = sacrificeAmount.get(i);
        } // Converts the dynamic int array into a normal int array.
        String[] sacrificeNamesArray = sacrificeNames.toArray(new String[0]);
        // Converts the dynamic String array into a normal String array.
        System.out.print("Here are the resources you need to sacrifice to reach max rank:\n");
        Format.printResourceArray(sacrificeAmountArray, sacrificeNamesArray);
        // Enumerates all the required sacrifices based on the user rank.
    }


    ////////////////////////////////////////////////////////////////////////////////////////


    // Output method #3
    public static void analyzeExcessStanding(int[] resourceOwned, int[] resourceStanding) {
        if (resourceOwned.length == 0) {
            return; // Exits out of the method if there are no resources for that particular syndicate.
        }
        int totalStanding = 0;
        for (int i = 0; i < resourceOwned.length; i++) {
            totalStanding += resourceOwned[i] * resourceStanding[i];
        } // Calculates the total amount of standing based on the standing gain of each resource owned.
        int days = totalStanding / standingCap;
        String isPlural = Format.pluralizeDays(days); // Adds an "s" to days if it is more than 1.
        if (days != 0) {
            System.out.printf("You have %,d total standing from syndicate standing resources that can last for %,d day%s.\n", totalStanding, days, isPlural);
        } else {
            System.out.printf("You have %,d total standing from syndicate standing resources.\n", totalStanding); // 
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Final method
    public void calculateToConsole(){
        this.userRank = getRank(this.rankTitles, this.syndicateName, rankMin, this.rankMax);
        this.standingMax = standingPerRank[userRank]; // Initializes instance variable for the next method.
        this.userStanding = getStanding(this.syndicateName, standingPerRank, this.userRank, standingMin, this.standingMax);
        this.resourceOwned = getResources(this.resourceNames, resourceMin, resourceMax);
        analyzeDaysToMax(this.userRank, this.rankTitles, this.userStanding);
        analyzeResourcesToMax(this.userRank, this.rankTitles, this.rankSacrificeNames, this.rankSacrificeAmount);
        analyzeExcessStanding(this.resourceOwned, this.resourceStanding);
        Format.inputBuffer();
    } // Combines all the methods together.

}