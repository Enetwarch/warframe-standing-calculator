package syndicates;
import Main;

public class TheHoldfasts {
    static String syndicateName = "The Holdfasts";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Fallen",
        "Watcher",
        "Guardian",
        "Seraph",
        "Angel"
    };
    static String[][] rankSacrificeNames = {
        {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"},
        {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"},
        {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"},
        {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"},
        {"Voidplume Pinion", "Thrax PLasm", "Entrati Lanthorn", "Credit"}
    };
    static int[][] rankSacrificeAmount= {
        {5, 2000, 2000, 10000},
        {10, 10, 5000, 25000}, 
        {10, 10, 5000, 50000}, 
        {15, 60, 40, 100000}, 
        {5, 90, 20, 200000}
    };

    static String[] resourceNames = {
        "Voidplume Down", 
        "Voidplume Vane",
        "Voidplume Crest",
        "Voidplume Quill",
        "Voidplume Pinion"
    };
    static int[] resourceStanding = {500, 1000, 2000, 2500, 5000};
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
