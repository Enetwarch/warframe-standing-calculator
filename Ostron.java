public class Ostron {
    static String syndicateName = "Ostron";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Offworlder",
        "Visitor",
        "Trusted",
        "Surah",
        "Kin"
    };
    static String[][] rankSacrificeNames = {
        {"Nistlepod", "Iradite", "Grokdrul", "Credit"},
        {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"},
        {"Cetus Wisp", "Maprico", "Credit"},
        {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"},
        {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {25, 25, 25, 10000},
        {10, 40, 60, 25000},
        {1, 5, 50000},
        {10, 40, 5, 100000},
        {1, 1, 1, 1, 200000}
    };

    static String[] oreNames = {
        "Azurite",
        "Devar", 
        "Veridos", 
        "Crimzian", 
        "Sentirum", 
        "Nyth"
    };
    static int[] oreStanding = {50, 50, 75, 100, 400, 400};
    static int[] oreOwned = {0, 0, 0, 0, 0};


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

    static void getToroids() {
        oreOwned = Main.getResources(oreNames);
    }

    static void getAnalysis() {
        Main.getAnalysis(
            userRank,
            userStanding,
            rankSacrificeNames,
            rankSacrificeAmount,
            oreOwned,
            oreStanding
        );
    }


    ///////////////////////////


    public static void main() {
        getRank();
        getStanding();
        getToroids();
        getAnalysis();
    }
}