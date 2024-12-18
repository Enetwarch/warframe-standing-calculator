import java.util.ArrayList;

public class Necraloid {
    static String syndicateName = "Necraloid";
    static int userRank = 0;
    static int userStanding = 0;
    static int[] standingPerRank = {5000, 22000, 44000, 70000};

    static String[] rankTitles = {
        "Neutral", 
        "Clearance: Agnesis",
        "Clearance: Modus",
        "Clearance: Odima"
    };
    static String[][] rankSacrificeNames = {
        {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"},
        {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"},
        {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}
    };
    static int[][] rankSacrificeAmount= {
        {10, 150, 1, 20},
        {15, 250, 1, 20},
        {15, 350, 1, 20}
    };

    static String[] resourceNames = {
        "Orokin Orientation Matrix",
        "Orokin Ballistics Matrix",
        "Orokin Animus Matrix"
    };
    static int[] resourceStanding = {1000, 2500, 5000};
    static int[] resourceOwned = {0, 0, 0};


    ///////////////////////


    static void getRank() {
        userRank = Main.getRank(
            rankTitles,
            syndicateName
        );
    }

    static void getStanding() {
        userStanding = Main.getStanding(
            syndicateName, 
            standingPerRank, 
            userRank);
    }

    static void getResources() {
        resourceOwned = Main.getResources(resourceNames);
    }

    static void analyzeDaysToMax(int userRank, int userStanding) {
        int days = 0;
        if (userRank == 3) {
            System.out.printf(
                """
                You are already max rank in this syndicate.     
                """
            );
            return;
        }
        while (userRank != 3) {
            days += 1;
            if (standingPerRank[userRank] >= userStanding + Main.standingCap) {
                userStanding += Main.standingCap;
            } else {
                userStanding = userStanding + Main.standingCap - standingPerRank[userRank];
                userRank += 1;
            }
        }
        System.out.printf(
            """
            It will take %d days to max out your rank with %,d leftover standing.     
            """
            , days
            , userStanding
        );
    }

    static void analyzeResourcesToMax(int userRank, String[][] rankSacrificeNames, int[][] rankSacrificeAmount) {
        ArrayList<String> sacrificeNames = new ArrayList<>();
        ArrayList<Integer> sacrificeAmount = new ArrayList<>();
        if (userRank == 3) {
            return;
        }
        for (int i = 0; i < rankSacrificeNames.length; i++) {
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
        Main.printResourceArray(
            sacrificeAmountArray,
            sacrificeNamesArray
        );
    }

    static void getAnalysis() {
        analyzeDaysToMax(
            userRank,
            userStanding
        );
        analyzeResourcesToMax(
            userRank,
            rankSacrificeNames,
            rankSacrificeAmount
        );
        Main.analyzeExcessStanding(
            resourceOwned,
            resourceStanding
        );
        Main.inputBuffer();
    }


    ///////////////////////////


    public static void main() {
        getRank();
        getStanding();
        getResources();
        getAnalysis();
    }
}