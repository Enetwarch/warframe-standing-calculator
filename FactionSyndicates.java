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
    },
    standingPerMedallion = {
        500,
        1000,
        5000
    };
    static int[][]
    userMedallion = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    },
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
    static double[][]
    alliedOpposedEnemy = {
        {1.00, 0, 0, -1.00, 0.50, -0.50},
        {0, 1.00, 0.50, -0.50, -1.00, 0},
        {0, .50, 1.00, 0, -0.50, -1.00},
        {-1.00, -0.50, 0, 1.00, 0, 0.50},
        {0.50, -1.00, -0.50, 0, 1.00, 0},
        {-0.50, 0, -1.00, 0.50, 0, 1.00}
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
    },
    syndicateMedallions = {
        {"(500 standing) Insignia", "(1,000 standing) Defender Insignia", "(5,000 standing) General Insignia"},
        {"(500 standing) Medallion", "(1,000 standing) Lawful Medallion", "(5,000 standing) Maxim Medallion"},
        {"(500 standing) Datum", "(1,000 standing) Intriguing Datum", "(5,000 standing) Genius Datum"},
        {"(500 standing) Quittance", "(1,000 standing) Executive Quittance", "(5,000 standing) Partner Quittance"},
        {"(500 standing) Mark", "(1,000 standing) Honored Mark", "(5,000) Exalted Mark"},
        {"(500 standing) Seed", "(1,000 standing) Bountiful Seed", "(5,000 standing) Flawless Seed"}
    },
    resourcesPerRank = {
        {"1 Orokin Catalyst", "1 Forma", "1000 Salvages", "2 Morphics", "1 Forma", "1 Orokin Catalyst", "2 Aya", "3 Aya"},
        {"1 Orokin Reactor", "1 Forma", "500 Alloy Plate", "2 Gallium", "1 Forma", "1 Orokin Reactor", "2 Aya", "3 Aya"},
        {"1 Orokin Catalyst", "1 Forma", "500 Circuit", "2 Control Module", "1 Forma", "1 Orokin Catalyst", "2 Aya", "3 Aya"},
        {"1 Orokin Reactor", "1 Forma", "100 Polymer Bundle", "2 Detonite Ampule", "1 Forma", "1 Orokin Reactor", "2 Aya", "3 Aya"},
        {"1 Orokin Catalyst", "1 Forma", "500 Alloy Plate", "2 Gallium", "1 Forma", "1 Orokin Catalyst", "2 Aya", "3 Aya"},
        {"1 Orokin Reactor", "1 Forma", "1000 Ferrite", "2 Fieldron Sample", "1 Forma", "1 Orokin Reactor", "2 Aya", "3 Aya"}
    };

    static void getFaction() {
        Format.printArray(factionSyndicates);
        userFaction = Format.getUserInput(
            "Choose a syndicate",
            1, 
            factionSyndicates.length
        );
    }

    static void getRank(int i) {
        Format.printArray(factionRankTitles[i]);
        userRank[i] = Format.getUserInput(
            factionSyndicates[i] + " rank", 
            1,
            factionRankTitles[i].length
        );
    }

    static void getStanding(int i) {
        userStanding[i] = Format.getUserInput(
            factionSyndicates[i] + " standing",
            standingPerRank[userRank[i] - 1][0],
            standingPerRank[userRank[i] - 1][1]
        );
    }

    static void getMedallions(int i) {
        for (int j = 0; j < syndicateMedallions[i].length; j++) {
            userMedallion[i][j] = Format.getUserInput(
                "(" + standingPerMedallion[j] + " standing) " + syndicateMedallions[i][j] + " owned",
                0,
                Integer.MAX_VALUE
            );
        }
    }

    static void getUserSyndicateInfo(int i) {
        getRank(i);
        getStanding(i);
        getMedallions(i);
    }

    static void calculateDaysToMax(int i) {
        int days = 0;
    }

    static void analyzeSyndicate(int i) {
        getUserSyndicateInfo(i);
    }

    static void analyzeSteelMeridian() {
        analyzeSyndicate(0);
    }

    static void analyzeArbitersOfHexis() {
        analyzeSyndicate(1);
    }

    static void analyzeCephalonSuda() {
        analyzeSyndicate (2);
    }

    static void analyzeThePerrinSequence() {
        analyzeSyndicate(3);
    }

    static void analyzeRedVeil() {
        analyzeSyndicate(4);
    }

    static void analyzeNewLoka() {
        analyzeSyndicate(5);
    }

    static void getAnalysis() {
        Format.printArray(factionSyndicates);
        Format.printSyndicateSelect();
        int userInput = Format.getUserInput(
            "Choose a syndicate to analyze",
            0,
            factionSyndicates.length
        );
        switch (userInput) {
            case 0: 
                break;
            case 1: 
                analyzeSteelMeridian();
                break;
            case 2: 
                analyzeArbitersOfHexis();
                break;
            case 3: 
                analyzeCephalonSuda();
                break;
            case 4: 
                analyzeThePerrinSequence();
                break;
            case 5: 
                analyzeRedVeil();
                break;
            case 6: 
                analyzeNewLoka();
                break;
        }
    }

    public static void main(String[] args) {
        getFaction();
        while (true) { 
            getAnalysis();
            break;
        }
    }
}
