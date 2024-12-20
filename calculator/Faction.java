package calculator;
import data.Format;
import data.Syndicates;
import java.util.Arrays;
import java.util.List;

public class Faction {

    private String syndicateName;
    private String[] rankTitles;
    private String[][] rankSacrificeNames;
    private int[][] rankSacrificeAmount;
    private String[] resourceNames;
    private int[] resourceOwned;
    private int userRank;
    private int userStanding;
    private double standingMultiplier;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int[][] standingPerRank = {{-44000, 0}, {-22000, 0}, {-5000, 5000}, {0, 5000}, {0, 22000}, {0, 44000}, {0, 70000}, {0, 99000}, {0, 132000}};
    private static String[] rankNumbers = {"-2", "-1", "-", "0", "1", "2", "3", "4", "5"};
    private static int standingCap = Syndicates.standingCap;
    private static String[] factionSyndicateList = {"Steel Meridian", "Arbiters of Hexis", "Cephalon Suda", "The Perrin Sequence", "Red Veil", "New Loka"};
    private static int factionSyndicateMin = 1;
    private static double[][] alliedOpposedEnemy = {{1.00, 0, 0, -1.00, 0.50, -0.50}, {0, 1.00, 0.50, -0.50, -1.00, 0}, {0, 0.50, 1.00, 0, -0.50, -1.00}, {-1.00, -0.50, 0, 1.00, 0, 0.50}, {0.50, -1.00, -0.50, 0, 1.00, 0}, {-0.50, 0, -1.00, 0.50, 0, 1.00}};
    private static int userFaction = -1;
    private static int calculateFaction = -1;
    private static int factionMin = 1;
    private static int factionMax = factionSyndicateList.length - 1;
    private static int[] resourceStanding = {500, 1000, 5000}; // All faction syndicate medallions have the same standing gain, only different names.
    private static int resourceMin = 0;
    private static int resourceMax = Integer.MAX_VALUE;

    public Faction(String syndicateName, String[] rankTitles, String[][] rankSacrificeNames, int[][] rankSacrificeAmount, String[] resourceNames) {
        // Constructor for faction syndicates.
        this.syndicateName = syndicateName;
        this.rankTitles = rankTitles;
        this.rankSacrificeNames = rankSacrificeNames;
        this.rankSacrificeAmount = rankSacrificeAmount;
        this.resourceNames = resourceNames;
        this.resourceOwned = new int[resourceNames.length];
        this.userRank = 2;
        this.userStanding = 0;
        this.standingMultiplier = 0;
    }


    /////////////////////////////////
    

    // Faction and standing calculation methods.
    private static int getFaction() {
        Format.printArray(factionSyndicateList, factionSyndicateMin);
        int userInput = Format.getUserInput("Select the syndicate you have pledged to", factionMin, factionMax);
        return userInput - 1; // Collects the pledged faction of the user to find the standing multipliers for each faction.
    }

    private static double calculateStandingMultiplier() {
        return alliedOpposedEnemy[userFaction][calculateFaction];
    } // Selects the inner array and double that corresponds to the pledged faction and selected faction up for calculation.


    /////////////////////////////////////////////////////////////////////


    // Custom printArray() function.
    private static void printArray(String[] rankNumbers, String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%s. %s\n", rankNumbers[i], list[i]);
        } // A different printArray() function from Format.java that takes in String as the numbers instead of integer.
    } // This is because faction syndicates have a Neutral rank, which isn't counted as a number.
    // Here are the rank numbers: "-2", "-1", "-" <<-- Neutral , "0", "1", "2", "3", "4", "5"

    private static void printStandingGain(double standingMultiplier) {
        String positiveOrNegative;
        if (standingMultiplier > 0) {
            positiveOrNegative = "positively";
        } else {
            positiveOrNegative = "negatively";
        }
        System.out.printf("You are pledged to %s, which %s affects your standing with %s by %f%.\n", factionSyndicateList[userFaction], factionSyndicateList[calculateFaction]);
    } // Used for printing negative or positive standing as well as the percentage of standing gain. 
    // Will be used after checkMultiplier() in analyzeStanding().

    private static void printNeutralStandingGain() {
        System.out.printf("You are pledged to %s, which does not affect %s standing.\n", factionSyndicateList[userFaction], factionSyndicateList[calculateFaction]);
    } // Called by checkMultiplier() if the standings in the syndicate will not change.


    ///////////////////////////////////////////////////////////////////////


    // Input methods.
    private static int getRank(String[] rankTitles, String syndicateName) {
        printArray(rankNumbers, rankTitles);
        List<String> validRanks = Arrays.asList(rankNumbers); 
        // Makes a list of all valid ranks for input validation.
        String userInput = Format.scanner.nextLine();
        while (true) { // Stays in the loop until the user inputs a valid input.
            if (validRanks.contains(userInput)) {
                return validRanks.indexOf(userInput);
            } else { // Accepts user input if their input is any element in the validRanks list.
                System.out.print("Invalid input. Only accepts numbers from -2 to 5. Enter \"-\" if Neutral.\n");
            } // Prompts the user to type in an appropriate value/String.
        }
    }

    private static int getStanding(String syndicateName, int[][] standingPerRank, int userRank) {
        int userInput = Format.getUserInput(syndicateName + " standing", standingPerRank[userRank][0], standingPerRank[userRank][1]);
        return userInput; // Gets the user standing while taking into account the user rank.
    }   

    // The getResources() method from calculator.Standard works perfectly fine for faction syndicates.


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // Output method #1
    private static void analyzeDaysToMax(double standingMultiplier, int userRank, String[] rankTitles, int userStanding, int userFaction, int calculateFaction) {
        if (standingMultiplier == 0) {
            printNeutralStandingGain();
            return; // Neutral standing will not run analyzeDaysToMax() 
        } else if (standingMultiplier > 0) {
            if (userRank == rankTitles.length - 1) {
                System.out.print("You are already max rank in this syndicate.\n");
                return; // Quits rank calculation if already maxed.
            }
            printStandingGain(standingMultiplier);
            calculateDaysToMaxOrLow(userRank, rankTitles, userStanding, userFaction, calculateFaction, standingMultiplier, true);
            // Positive standing gain
        } else if (standingMultiplier < 0) {
            if (userRank == rankTitles.length - 1) {
                System.out.print("You are already max rank in this syndicate.\n");
                // Prompts the user that the syndicate is already max rank, but also prints the negative multiplier.
                // Proceeds with the calculation regardless
            } else if ((userRank == 0) && (userStanding == standingPerRank[userRank][0])) {
                System.out.print("You are already at the lowest rank and standing in this syndicate.\n");
                return; // Returns if the printed statement is true.
            } 
            printStandingGain(standingMultiplier);
            calculateDaysToMaxOrLow(userRank, rankTitles, userStanding, userFaction, calculateFaction, standingMultiplier, false);
            // Negative standing gain
        }
    } // Used for determining the action of analyzeStanding();

    // Output method #1.1
    private static void calculateDaysToMaxOrLow(int userRank, String[] rankTitles, int userStanding, int userFaction, int calculateFaction, double standingMultiplier, boolean positiveOrNegative) {
        int days = 0;
        standingCap *= standingMultiplier; // Multiplies the value of standing cap by 1, 0.5, -0.5, or -1 depending on the faction pledged and faction to calculate.
        if (positiveOrNegative) {
            while (userRank != rankTitles.length - 1) {
                days += 1; // Days increments by 1 each iteration.
                if (standingPerRank[userRank][1] > userStanding + standingCap) {
                    userStanding += standingCap; // User standing increases
                    // Occurs majority of the time.
                } else {
                    userStanding = userStanding + standingCap - standingPerRank[userRank][1]; // User standing resets while still taking into account the excess increase.
                    userRank += 1; // User rank goes up.
                } // Occurs only if user standing has reached the max standing for that rank.
            } // Normal calculate days to max rank calculation. The inverse of these operations will lead to lowest rank calculation.
            // Does not calculate any further after reaching the max rank.
            String isPlural = Format.pluralizeDays(days);
            System.out.printf("It will take %d day%s to max out your rank.\n", days, isPlural);
        // Positive standing gain
        } else {
            while ((userRank != 0) || (userStanding > standingPerRank[0][0])) {
                days += 1; // Days increments by 1 each iteration.
                if (standingPerRank[userRank][0] < userStanding - standingCap) {
                    userStanding -= standingCap; // Decreases the user standing until it reaches the lowest possible standing on that specified rank.
                } else {
                    userStanding = userStanding - standingCap + standingPerRank[userRank][1]; 
                    userRank -= 1; 
                } // Occurs if the user standing is lower than the lowest possible standing on that rank.
            } // Complete inverse of the operations in the calculate days to max rank calculation.
            // Unlike the positive variant, this calculates all the way until you reach the lowest standing as well.
            String isPlural = Format.pluralizeDays(days);
            System.out.printf("It will take %d day%s to reach the lowest rank and standing.\n", days, isPlural);
        // Negative standing gain
        }
    } // Determines which calculation to use depending on the boolean value of positiveOrNegative from analyzeDaysToMax().
    // Calculates days to reach max rank xor lowest rank.

    // Output method #2
    // The analyzeResourcesToMax() method from calculator.Standard works perfectly fine for faction syndicates.

    // Output method #3
    // The analyzeExcessStanding() method from calculator.Standard works perfectly fine for faction syndicates.


    /////////////////////////////////


    // Final method
    public void calculateToConsole() {
        this.standingMultiplier = calculateStandingMultiplier();
        this.userRank = getRank(this.rankTitles, this.syndicateName);
        this.userStanding = getStanding(this.syndicateName, standingPerRank, this.userRank);
        this.resourceOwned = Standard.getResources(this.resourceNames, resourceMin, resourceMax);
        analyzeDaysToMax(this.standingMultiplier, this.userRank, this.rankTitles, this.userStanding, userFaction, calculateFaction);
        Standard.analyzeResourcesToMax(this.userRank, this.rankTitles, this.rankSacrificeNames, this.rankSacrificeAmount);
        Standard.analyzeExcessStanding(this.resourceOwned, resourceStanding);
        Format.inputBuffer();
    } // Combines all the methods together into one big method.

    
    ////////////////////////////////////////


    public static void factionSyndicates() {
        userFaction = getFaction();
        while (true) {
            Format.printArray(factionSyndicateList, factionSyndicateMin);
            Format.printSyndicateSelect();
            int userInput = Format.getUserInput("Choose a faction syndicate to calculate",0, factionSyndicateList.length);
            int calculateFaction = userInput - 1;
            Syndicates.makeFactions(); // Only initializes objects now in order to take into account the changes in standing multipliers.
            switch (userInput) {
                case 1:
                    Syndicates.steelMeridian.calculateToConsole();
                    break;
                case 2:
                    Syndicates.arbitersOfHexis.calculateToConsole();
                    break;
                case 3:
                    Syndicates.cephalonSuda.calculateToConsole();
                    break;
                case 4:
                    Syndicates.thePerrinSequence.calculateToConsole();
                    break;
                case 5:
                    Syndicates.redVeil.calculateToConsole();
                    break;
                case 6:
                    Syndicates.newLoka.calculateToConsole();
                    break;
                case 0:
                    return; // Returns back to Console.java
            }
        }
    }

}