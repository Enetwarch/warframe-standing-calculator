package syndicates;
import Main;

public class TheQuills {
    static String syndicateName = "The Quills";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Mote", 
        "Observer", 
        "Adherent", 
        "Instrument", 
        "Architect"
    };
    static String[][] rankSacrificeNames = {
        {"Intact Sentient Core", "Credit"},
        {"Intact Sentient Core", "Credit"},
        {"Eidolon Shard", "Credit"},
        {"Eidolon Shard", "Credit"},
        {"Eidolon Shard", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {10, 30000},
        {20, 50000},
        {10, 100000},
        {20, 250000},
        {30, 500000}
    };

    static String[] resourceNames = {
        "Intact Sentient Core", 
        "Exceptional Sentient Core", 
        "Flawless Sentient Core", 
        "Narmer Isoplast"
    };
    static int[] resourceStanding = {250, 750, 1500, 2000};
    static int[] resourceOwned = {0, 0, 0, 0};


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
