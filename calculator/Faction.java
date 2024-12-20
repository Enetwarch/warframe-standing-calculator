package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import calculator.Standard;
import data.Syndicates;
import data.Format;

public class Faction {

    private String syndicateName;
    private String[] rankTitles;
    private String[][] rankSacrificeNames;
    private int[][] rankSacrificeAmount;
    private String[] resourceNames;
    private int[] resourceStanding;
    private int[] resourceOwned;
    private int userRank;
    private int userStanding;
    private double standingMultiplier;
    ///////////////////////////////////////
    private static int[][] standingPerRank = {{-44000, 0}, {-22000, 0}, {-5000, 5000}, {0, 5000}, {0, 22000}, {0, 44000}, {0, 70000}, {0, 99000}, {0, 132000}};
    private static String[] rankNumbers = {"-2", "-1", "-", "0", "1", "2", "3", "4", "5"};
    private static int standingCap = Syndicates.standingCap;
    private static String[] factionSyndicateList = {"Steel Meridian", "Arbiters of Hexis", "Cephalon Suda", "The Perrin Sequence", "Red Veil", "New Loka"};
    private static double[][] alliedOpposedEnemy = {{1.00, 0, 0, -1.00, 0.50, -0.50}, {0, 1.00, 0.50, -0.50, -1.00, 0}, {0, 0.50, 1.00, 0, -0.50, -1.00}, {-1.00, -0.50, 0, 1.00, 0, 0.50}, {0.50, -1.00, -0.50, 0, 1.00, 0}, {-0.50, 0, -1.00, 0.50, 0, 1.00}};
    private static int userFaction = -1;
    private static int calculateFaction;

    public Faction(String syndicateName, String[] rankTitles, String[][] rankSacrificeNames, int[][] rankSacrificeAmount, String[] resourceNames, int[] resourceStanding) {
        this.syndicateName = syndicateName;
        this.rankTitles = rankTitles;
        this.rankSacrificeNames = rankSacrificeNames;
        this.rankSacrificeAmount = rankSacrificeAmount;
        this.resourceNames = resourceNames;
        this.resourceStanding = resourceStanding;
        this.resourceOwned = new int[resourceNames.length];
        this.userRank = 2;
        this.userStanding = 0;
        this.standingMultiplier = 0;
        Faction.calculateFaction = -1;
    }


    /////////////////////////////////
    

    private static int getFaction() {
        Format.printArray(factionSyndicateList);
        int userInput = Format.getUserInput(
            "Select the syndicate you have pledged to",
            1,
            factionSyndicateList.length
        );
        return userInput;
    }

    private static double calculateStandingMultiplier() {
        return alliedOpposedEnemy[userFaction][calculateFaction];
    }

    private static void printArray(String[] rankNumbers, String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf(
                """
                %s. %s     
                """
                , rankNumbers
                , list[i]
            );
        }
    }


    ///////////////////////////


    private static int getRank(
        String[] rankTitles, 
        String syndicateName
        ) {
        printArray(
            rankNumbers,
            rankTitles
        );
        List<String> validRanks = Arrays.asList(rankNumbers); 
        String userInput = Format.scanner.nextLine();
        while (true) {
            if (validRanks.contains(userInput)) {
                return validRanks.indexOf(userInput);
            } else {
                System.out.print(
                    """
                    Invalid input. Only accepts numbers from -2 to 5. Enter "-" if Neutral.
                    """
                );
            }
        }
    }

    private static int getStanding(
        String syndicateName, 
        int[][] standingPerRank, 
        int userRank
        ) {
        int userInput = Format.getUserInput(
            syndicateName + " standing",
            standingPerRank[userRank][0],
            standingPerRank[userRank][1]
        );
        return userInput;
    }


    ///////////////////////////////////////////////


    private static int checkMultiplier(standingMultiplier) {
        if (standingMultiplier == 0) {
            printNeutralStandingGain();
            return 0;
        } else if (standingMultiplier > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private static void printNeutralStandingGain() {
        System.out.printf(
            """
            You are pledged to %s, which does not affect %s standing.
            """
            , factionSyndicateList[userFaction]
            , factionSyndicateList[calculateFaction]
        );
    }

    private static void printStandingGain(double standingMultiplier) {
        String positiveOrNegative;
        if (standingMultiplier > 0) {
            positiveOrNegative = "positively";
        } else {
            positiveOrNegative = "negatively";
        }
        System.out.printf(
            """
            You are pledged to %s, which %s affects your standing with %s by %f%.     
            """
            , factionSyndicateList[userFaction]
            , positiveOrNegative
            , factionSyndicateList[calculateFaction]
            , standingMultiplier * 100
        );
    }


    
    /////////////////////////////////////


    private static void analyzeDaysToMax(
        int userRank, 
        String[] rankTitles, 
        int userStanding,
        int userFaction,
        int calculateFaction,
        double standingMultipler
        ) {
        int days = 0;
        if (userRank == rankTitles.length) {
            System.out.print(
                """
                You are already max rank in this syndicate.     
                """
            );
            return;
        }
        standingCap *= (standingMultiplier)
        while (userRank != rankTitles.length) {
            days += 1;
            if (standingPerRank[userRank] > userStanding + standingCap) {
                userStanding += standingCap;
            } else {
                userStanding = userStanding + standingCap - standingPerRank[userRank];
                userRank += 1;
            }
        }
        String isPlural = Format.pluralizeDays(days);
        System.out.printf(
            """
            It will take %d day%s to max out your rank with %,d leftover standing.     
            """
            , days
            , isPlural
            , userStanding
        );
    }

    private static void getAnalysis() {
    }



    /////////////////////////////////


    public void calculateToConsole(){
        this.standingMultiplier = calculateStandingMultiplier();
        this.userRank = getRank(
            this.rankTitles, 
            this.syndicateName
        );
        this.userStanding = getStanding(
            this.syndicateName,
            standingPerRank,
            this.userRank
        );
        this.resourceOwned = Standard.getResources(
            this.resourceNames
        );
        int positiveOrNegative = checkMultiplier(this.standingMultiplier);
        
    }

    
    ////////////////////////////////////////


    public static void factionSyndicates() {
        userFaction = getFaction() - 1;
        while (true) {
            Format.printArray(factionSyndicateList);
            Format.printSyndicateSelect();
            calculateFaction = Format.getUserInput(
                "Choose a faction syndicate",
                0,
                factionSyndicateList.length
            );
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
                    return;
            }
        }
    }

}