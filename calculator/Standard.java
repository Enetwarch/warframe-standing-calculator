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
    private static int[] standingPerRank;
    private static int standingCap;

    public Standard(
        String syndicateName, 
        String[] rankTitles, 
        String[][] rankSacrificeNames, 
        int[][] rankSacrificeAmount, 
        String[] resourceNames, 
        int[] resourceStanding
        ) {
        this.syndicateName = syndicateName;
        this.rankTitles = rankTitles;
        this.rankSacrificeNames = rankSacrificeNames;
        this.rankSacrificeAmount = rankSacrificeAmount;
        this.resourceNames = resourceNames;
        this.resourceStanding = resourceStanding;
        this.resourceOwned = new int[resourceNames.length];
        this.userRank = 0;
        this.userStanding = 0;
        Standard.standingPerRank = new int[]{5000, 22000, 44000, 70000, 99000, 132000};
        Standard.standingCap = Syndicates.standingCap;
    }


    ///////////////////////////

    private static void initializeMinMax() {
        int getRankMin = 0;
        int getRankMax = rankTitles.length;
        int g
    }


    private static int getRank(
        String[] rankTitles, 
        String syndicateName
        ) {
        Format.printArray(
            rankTitles,
            getRankMin
        );
        int userInput = Format.getUserInput(
            syndicateName + " rank",
            getRankMin,
            getRankMax
        );
        return userInput;
    }

    private static int getStanding(
        String syndicateName, 
        int[] standingPerRank, 
        int userRank
        ) {
        int userInput = Format.getUserInput(
            syndicateName + " standing",
            0,
            standingPerRank[userRank]
        );
        return userInput;
    }

    public static int[] getResources(String[] resourceNames) {
        if (resourceNames.length == 0) {
            return new int[]{};
        }
        int[] resourceOwned = new int[resourceNames.length];
        for (int i = 0; i < resourceNames.length; i++)
        resourceOwned[i] = Format.getUserInput(
            resourceNames[i] + " owned",
            0,
            Integer.MAX_VALUE
        );
        return resourceOwned;
    }

    private static void analyzeDaysToMax(
        int userRank, 
        String[] rankTitles, 
        int userStanding
        ) {
        int days = 0;
        if (userRank == rankTitles.length) {
            System.out.printf(
                """
                You are already max rank in this syndicate.     
                """
            );
            return;
        }
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

    private static void analyzeResourcesToMax(
        int userRank, 
        String[] rankTitles, 
        String[][] rankSacrificeNames, 
        int[][] rankSacrificeAmount
        ) {
        if (rankSacrificeNames.length == 0) {
            return;
        } else if (userRank == 5) {
            return;
        }
        ArrayList<String> sacrificeNames = new ArrayList<>();
        ArrayList<Integer> sacrificeAmount = new ArrayList<>();
        if (userRank == rankTitles.length) {
            return;
        }
        for (int i = userRank; i < rankSacrificeNames.length; i++) {
            for (int j = 0; j < rankSacrificeNames[i].length; j++) {
                String sacrificeNameString = rankSacrificeNames[i][j];
                int sacrificeAmountInt = rankSacrificeAmount[i][j];
                if (sacrificeNames.contains(sacrificeNameString)) {
                    int index = sacrificeNames.indexOf(sacrificeNameString);
                    sacrificeAmount.set(index, sacrificeAmount.get(index) + sacrificeAmountInt);
                } else {
                    sacrificeNames.add(sacrificeNameString);
                    sacrificeAmount.add(sacrificeAmountInt);
                }
            }
        }
        int[] sacrificeAmountArray = new int[sacrificeAmount.size()];
        for (int i = 0; i < sacrificeAmount.size(); i++) {
            sacrificeAmountArray[i] = sacrificeAmount.get(i);
        }
        String[] sacrificeNamesArray = sacrificeNames.toArray(new String[0]);
        System.out.print(
            """
            Here are the resources you need to sacrifice to reach max rank:     
            """
        );
        Format.printResourceArray(
            sacrificeAmountArray,
            sacrificeNamesArray
        );
    }

    private static void analyzeExcessStanding(
        int[] resourceOwned, 
        int[] resourceStanding
        ) {
        if (resourceOwned.length == 0) {
            return;
        }
        int totalStanding = 0;
        for (int i = 0; i < resourceOwned.length; i++) {
            totalStanding += resourceOwned[i] * resourceStanding[i];
        }
        int days = totalStanding / standingCap;
        String isPlural = Format.pluralizeDays(days);
        if (days != 0) {
            System.out.printf(
                """
                You have %,d total standing from syndicate standing resources that can last for %,d day%s.     
                """
                , totalStanding
                , days
                , isPlural
            );
        } else {
            System.out.printf(
                """
                You have %,d total standing from syndicate standing resources.  
                """
                , totalStanding
            );
        }
    }

    public static void getAnalysis(
        int userRank, 
        String[] rankTitles, 
        int userStanding, 
        String[][] rankSacrificeNames, 
        int[][] rankSacrificeAmount, 
        int[] resourceOwned, 
        int[] resourceStanding
        ) {
        analyzeDaysToMax( 
            userRank,
            rankTitles,
            userStanding
        );
        analyzeResourcesToMax(
            userRank,
            rankTitles,
            rankSacrificeNames,
            rankSacrificeAmount
        );
        analyzeExcessStanding(
            resourceOwned,
            resourceStanding
        );
        Format.inputBuffer();
    }


    /////////////////////////////////


    public void calculateToConsole(){
        this.userRank = getRank(
            this.rankTitles, 
            this.syndicateName
        );
        this.userStanding = getStanding(
            this.syndicateName,
            standingPerRank,
            this.userRank
        );
        this.resourceOwned = getResources(
            this.resourceNames
        );
        getAnalysis(
            this.userRank,
            this.rankTitles,
            this.userStanding,
            this.rankSacrificeNames,
            this.rankSacrificeAmount,
            this.resourceOwned,
            this.resourceStanding
        );
    }

}