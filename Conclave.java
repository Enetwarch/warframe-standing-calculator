package warframe-standing-calculator.syndicates;
public class Conclave {
    static String syndicateName = "Conclave";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Mistral",
        "Whirlwind",
        "Tempest",
        "Hurricane",
        "Typhoon"
    };
    static String[][] rankSacrificeNames = {
        {"Plastid", "Credit"},
        {"Neurode", "Credit"},
        {"Forma", "Credit"},
        {"Orokin Reactor", "Credit"},
        {"Orokin Catalyst", "Credit"},
        {"Orokin Ducat", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {100, 10000},
        {2, 30000},
        {1, 50000},
        {1, 100000},
        {1, 250000},
        {100, 500000}
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
            rankTitles,
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
