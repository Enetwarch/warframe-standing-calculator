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
        {"(-2) Enemy", "(-1) Outcast", "(-) Neutral", "(0) Initiation", "(1) Brave", "(2) Valiant", "(3) Defender", "(4) Protector", "(5) General"},
        {"(-2) Fraud", "(-1) Deceiver", "(-) Neutral", "(0) Initiation", "(1) Principled", "(2) Authentic", "(3) Lawful", "(4) Crusader", "(5) Maxim"},
        {"(-2) Waste", "(-1) Debris", "(-) Neutral", "(0) Initiation", "(1) Competent", "(2) Intriguing", "(3) Intelligent", "(4) Wise", "(5) Genius"},
        {"(-2) Write-Off", "(-1) Liability", "(-) Neutral", "(0) Initiation", "(1) Associate", "(2) Senior Associate", "(3) Executive", "(4) Senior Executive", "(5) Partner"},
        {"(-2) Corrupt", "(-1) Suspect", "(-) Neutral", "(0) Initiation", "(1) Respected", "(2) Honored", "(3) Esteemed", "(4) Revered", "(5) Exalted"},
        {"(-2) Exiled", "(-1) Condemned", "(-) Neutral", "(0) Initiation", "(1) Humane", "(2) Bountiful", "(3) Benevolent", "(4) Pure", "(5) Flawless"}
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
            1, 
            factionSyndicates.length
        );
    }

    static void getRank() {
        for (int i = 0; i < factionSyndicates.length; i++) {
            Format.printArray(factionRankTitles[i]);
            userRank[i] = Format.getUserInput(
                factionSyndicates[i] + " rank", 
                1,
                factionRankTitles[i].length
            );
        }
    }

    static void getStanding() {
        for (int i = 0; i < userStanding.length; i++) {
            userStanding[i] = Format.getUserInput(
                factionSyndicates[i] + " standing",
                standingPerRank[userRank[i - 1]][0],
                standingPerRank[i - 1][1]
            );
        }
    }

    public static void main(String[] args) {
        getFaction();
        getRank();
        getStanding();
    }
}
