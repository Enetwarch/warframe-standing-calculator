package syndicates;
import Main;

public class Cavia {
    static String syndicateName = "Cavia";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Assistant",
        "Researcher",
        "Colleague",
        "Scholar",
        "Illuminate"
    };
    static String[][] rankSacrificeNames = {
        {"Shrill Voca", "Entrati Obols", "Rubedo", "Credit"},
        {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"},
        {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"},
        {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"},
        {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {3, 300, 11000, 10000},
        {5, 60, 12, 8, 25000},
        {2, 8, 15, 16, 50000}, 
        {1, 10, 1500, 5, 100000}, 
        {10, 25, 10, 32, 200000}
    };

    static String[] resourceNames = {
        "Shrill Voca",
        "Bellow Voca",
        "Echo Voca"
    };
    static int[] resourceStanding = {500, 1000, 2000};
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
