package syndicates;
import Main;

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
        {},
        {},
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