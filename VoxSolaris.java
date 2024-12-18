public class VoxSolaris {
    static String syndicateName = "Vox Solaris";
    static int userRank = 0;
    static int userStanding = 0;
    static int[] toroidOwned = {0, 0, 0, 0, 0, 0};

    static String[] rankTitles = {"Neutral", "Operative", "Agent", "Hand", "Instrument", "Shadow"};
    static String[][] rankSacrificeNames = {
        {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"},
        {"Gyromag System", "Vega Toroid", "Credit"},
        {"Atmo System", "Calda Toroid", "Credit"},
        {"Repeller System", "Sola Toroid", "Credit"},
        {"Crisma Toroid", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {1, 1, 1, 50000},
        {1, 1, 100000}, 
        {1, 1, 250000}, 
        {1, 1, 500000}, 
        {1, 1000000}
    };

    static String[] toroidNames = {"Vega Toroid", "Calda Toroid", "Sola Toroid", "Narmer Isoplast", "Crisma Toroid", "Lazulite Toroid"};
    static int[] toroidStanding = {1000, 1000, 1000, 2000, 6000, 12000};

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
        toroidOwned = Main.getResources(toroidNames);
    }

    static void getAnalysis() {
        Main.getAnalysis(
            userRank,
            userStanding,
            rankSacrificeNames,
            rankSacrificeAmount,
            toroidOwned,
            toroidStanding
        );
    }

    public static void main() {
        getRank();
        getStanding();
        getToroids();
        getAnalysis();
    }
}