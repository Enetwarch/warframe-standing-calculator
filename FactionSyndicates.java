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
    },
    userStanding = {
        -44000,
        -22000,
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
        Format.printArray(factionSyndicates);
        userFaction = Format.getUserInput(
            "Choose a syndicate",
            Format.min,
            factionSyndicates.length
        );
    }

    static void getRank() {
        for (int i = 0; i < factionRankTitles[i].length; i++) {
            userRank[i] = Format.getUserInput(
                factionSyndicates[i] + " rank", 
                Format.min, 
                factionRankTitles[i].length);
        }
    }

    static void getStanding() {
        for (int i = 0; i < userStanding.length; i++) {
            userStanding[i] = Format.getUserInput(
                factionSyndicates[i] + " standing",
                Format.min,
                factionSyndicates.length
            );
        }
    }

    public static void main(String[] args) {
        while (true) {
            getFaction();
            getRank();
            getStanding();
        }
    }
}
