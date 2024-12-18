public class Ostron {
    static String syndicateName = "Vox Solaris";
    static int userRank = 0;
    static int userStanding = 0;
    static int[] toroidOwned = {0, 0, 0, 0, 0, 0};

    static String[] rankTitles = {"Neutral", "Operative", "Agent", "Hand", "Instrument", "Shadow"};
    static String[][] rankSacrificeNames = {
        {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"},
        {"Gyromag System", "Vega Toroid", "Credit"},
        {"Atmo System", "Calda Toroid", "Credit"},
        {"Repeller System", "Sola Toroid", "Credit"},
        {"Crisma Toroid", "Credit"}
    };
    static int[][] rankSacrificeAmount= {{1, 1, 1, 50000}, {1, 1, 100000}, {1, 1, 250000}, {1, 1, 500000}, {1, 1000000}};

    static String[] toroidNames = {"Vega Toroid", "Calda Toroid", "Sola Toroid", "Narmer Isoplast", "Crisma Toroid", "Lazulite Toroid"};
    static int[] toroidStanding = {1000, 1000, 1000, 2000, 6000, 12000};
   
}