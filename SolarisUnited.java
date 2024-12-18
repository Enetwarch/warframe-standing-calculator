public class SolarisUnited {
    static String syndicateName = "Solaris United";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Outworlder",
        "Rapscallion",
        "Doer",
        "Cove",
        "Old Mate"
    };
    static String[][] rankSacrificeNames = {
        {"Training Debt-Bond", "Credit"},
        {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"},
        {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"},
        {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"},
        {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {2, 10000},
        {3, 2, 25000},
        {4, 3, 2, 50000},
        {5, 4, 3, 100000},
        {5, 5, 3, 200000}
    };

    static String[] resourceNames = {
        "Training Debt-Bond",
        "Shelter Debt-Bond",
        "Medical Debt-Bond",
        "Advances Debt-Bond",
        "Familial Debt-Bond"
    };
    static int[] resourceStanding = {100, 200, 300, 400, 500};
    static int[] resourceOwned = {0, 0, 0, 0, 0};


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
            Main.standingPerRank, 
            userRank);
    }

    static void getResources() {
        resourceOwned = Main.getResources(resourceNames);
    }

    static void getAnalysis() {
        Main.getAnalysis(
            userRank,
            userStanding,
            rankSacrificeNames,
            rankSacrificeAmount,
            resourceOwned,
            resourceStanding
        );
    }


    ///////////////////////////


    public static void main() {
        getRank();
        getStanding();
        getResources();
        getAnalysis();
    }   
}
