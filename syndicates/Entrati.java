package syndicates;
import Main;

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

    static String[] resourceNames = {
        "Mother Token", 
        "Father Token", 
        "Daughter Token", 
        "Son Token", 
        "Otak Token", 
        "Grandmother Token"
    };
    static int[] resourceStanding = {100, 100, 100, 500, 100, 1500};
    static int[] resourceOwned = {0, 0, 0, 0, 0, 0};


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