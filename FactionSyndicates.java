public class FactionSyndicates {
    static int 
    userFaction;
    static int[]
    userRank = {
        0,
        0,
        0,
        0,
        0,
        0
    };
    static String[] 
    factionSyndicates = {
        "Steel Meridian", 
        "Arbiters of Hexis", 
        "Cephalon Suda", 
        "The Perrin Sequence", 
        "Red Veil", 
        "New Loka"
    };
    static String[][]
    factionRankTitles = {
        {"Enemy", "Outcast", "Neutral", "Initiation", "Brave", "Valiant", "Defender", "Protector", "General"},
        {"Fraud", "Deceiver", "Neutral", "Initiation", "Principled", "Authentic", "Lawful", "Crusader", "Maxim"},
        {"Waste", "Debris", "Neutral", "Initiation", "Competent", "Intriguing", "Intelligent", "Wise", "Genius"},
        {"Write-Off", "Liability", "Neutral", "Initiation", "Associate", "Senior Associate", "Executive", "Partner"},
        {"Corrupt", "Suspect", "Neutral", "Initiation", "Respected", "Honored", "Esteemed", "Revered", "Exalted"},
        {"Exiled", "Condemned", "Neutral", "Initiation", "Humane", "Bountiful", "Benevolent", "Pure", "Flawless"}
    };
    static double[][]
    alliedOpposedEnemy = {
        {1.00, 0, 0, -1.00, 0.50, -0.50},
        {0, 1.00, 0.50, -0.50, -1.00, 0},
        {0, .50, 1.00, 0, -0.50, -1.00},
        {-1.00, -0.50, 0, 1.00, 0, 0.50},
        {0.50, -1.00, -0.50, 0, 1.00, 0},
        {-0.50, 0, -1.00, 0.50, 0, 1.00}
    };
    static int[][]
    standingPerRank = {
        {-44000, 0},
        {-22000, 0},
        {-5000, 5000},
        {0, 5000},
        {0, 22000},
        {0, 44000},
        {0, 70000},
        {0, 99000},
        {0, 132000}
    };

    static void getFaction() {
        Main.printArray(factionSyndicates);
        userFaction = Main.getUserInput(
            "Choose a syndicate", 1, 6
        );
    }

    static void getRank() {
        for (int i = 0; i < factionSyndicates[0].length; i++) {
            Main.printArray(factionRankTitles[i]);
            userRank[i] = Main.getUserInput(
                factionSyndicates[i] + "rank: ", 
                1, 8);
        }
    }

    public static void main(String[] args) {
        while (true) {
            getFaction();
            getRank();
        }
    }
}
