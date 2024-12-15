public class FactionSyndicates {
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

    static void chooseFactionSyndicate() {
        Main.printArray(factionSyndicates);
    }

    static void getFaction() {
        while (true) { 
            Main.startInput(
                "Choose a faction (1 to 6): >> "
            );
            try {
                int userFaction = Main.scanner.nextInt();
                if (userFaction >= 1 && userFaction <= 6) {
                    break;
                } else {
                    Main.inputError();
                }
            } catch (Exception e) {
                Main.inputError();
            }
        }
    }



    static void getRank() {
        Main.getUserInput(
            "", 0, 0);
    }

    public static void main(String[] args) {
        while (true) {
            chooseFactionSyndicate();
            getFaction();
            
        }
    }
}
