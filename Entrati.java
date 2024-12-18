public class Entrati {
    static String syndicateName = "Entrati";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Stranger", 
        "Acquaintance", 
        "Associate", 
        "Friend", 
        "Family"
    };
    static String[][] rankSacrificeNames = {
        {"Spinal Core Section"},
        {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"},
        {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"},
        {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"},
        {"Seriglass Shard", "Mother Token", "Father Token"}
    };
    static int[][] rankSacrificeAmount= {
        {3},
        {1, 1, 1, 1},
        {5, 1, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1}
    };

    static String[] tokenNames = {
        "Mother Token", 
        "Father Token", 
        "Daughter Token", 
        "Son Token", 
        "Otak Token", 
        "Grandmother Token"
    };
    static int[] tokenStanding = {100, 100, 100, 500, 100, 1500};
    static int[] tokenOwned = {0, 0, 0, 0, 0, 0};


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
        tokenOwned = Main.getResources(tokenNames);
    }

    static void getAnalysis() {
        Main.getAnalysis(
            userRank,
            userStanding,
            rankSacrificeNames,
            rankSacrificeAmount,
            tokenOwned,
            tokenStanding
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