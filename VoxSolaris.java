public class VoxSolaris {
    static String syndicateName = "Vox Solaris";

    static String[] toroidNames = {"Vega Toroid", "Calda Toroid", "Sola Toroid", "Narmer Isoplast", "Crisma Toorid", "Lazulite Toroid"};
    static int[] toroidStanding = {1000, 1000, 1000, 2000, 6000, 12000};
    static int[] toroidOwned = {0, 0, 0, 0, 0, 0};

    static String[] rankTitles = {"Neutral", "Operative", "Agent", "Hand", "Instrument", "Shadow"};
    static int[] standingPerRank = {5000, 22000, 44000, 70000, 99000, 132000};
    static String[][] rankSacrificesNames = {
        {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"},
        {"Gyromag System", "Vega Toroid", "Credit"},
        {"Atmo System", "Calda Toroid", "Credit"},
        {"Repeller System", "Sola Toroid", "Credit"},
        {"Crisma Toroid", "Credit"}
    };
    static int[][] rankSacrificesAmount= {{1, 1, 1, 50000}, {1, 1, 100000}, {1, 1, 250000}, {1, 1, 500000}, {1, 1000000}};

    static int userRank = 0;
    static int userStanding = 0;

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

    static void getToroids() {

    }

    static void getAnalysis() {

    }

    static void analyzeDaysToMax() {

    }

    static void analyzeResourcesToMax() {

    }

    static void analyzeExcessStanding() {

    }

    public static void main(String[] args) {
        getRank();
        getStanding();
        getToroids();
        while (true) { 
            getAnalysis();
        }
    }
}