import data.Data;
import util.Utility;
public class Main {
    private static final String[] SYNDICATE_OPTIONS = {
        Data.FACTION_SYNDICATES,
        Data.CONCLAVE,
        Data.CEPHALON_SIMARIS,
        Data.OSTRON,
        Data.THE_QUILLS,
        Data.SOLARIS_UNITED,
        Data.VOX_SOLARIS,
        Data.VENTKIDS,
        Data.ENTRATI,
        Data.NECRALOID,
        Data.THE_HOLDFASTS,
        Data.CAVIA,
        Data.THE_HEX
    }; // All syndicates after the 1999 update.
    private static final String[] FACTION_OPTIONS = {
        Data.STEEL_MERIDIAN,
        Data.ARBITERS_OF_HEXIS,
        Data.CEPHALON_SUDA,
        Data.THE_PERRIN_SEQUENCE,
        Data.RED_VEIL,
        Data.NEW_LOKA
    }; // All faction syndcates.
    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = SYNDICATE_OPTIONS.length;
    private static final int FACTION_OPTIONS_MIN = 0;
    private static final int FACTION_OPTIONS_MAX = FACTION_OPTIONS.length;
    // Constant min and max values for typesafety and maintainability for integer inputs.

    //////////////////////////////////////////
    /// MENU METHODS

    // Syndicate menu
    private static void getSyndicateOption() {
        while (true) {
            Utility.printNumberedArray(SYNDICATE_OPTIONS);
            System.out.print("[0] Exit Program\n");
            int userInput = Utility.getUserInputInt("Choose a syndicate to calculate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> getFactionOption(); // Faction Syndicates
                case 2 -> underDevelopment(); // Conclave
                case 3 -> underDevelopment(); // Cephalon Simaris
                case 4 -> underDevelopment(); // Ostron
                case 5 -> underDevelopment(); // The Quills
                case 6 -> underDevelopment(); // Solaris United
                case 7 -> underDevelopment(); // Vox Solaris
                case 8 -> underDevelopment(); // Ventkids
                case 9 -> underDevelopment(); // Entrati
                case 10 -> underDevelopment(); // Necraloid
                case 11 -> underDevelopment(); // The Holdfasts
                case 12 -> underDevelopment(); // Cavia
                case 13 -> underDevelopment(); // The Hex
                case 0 -> Utility.terminateProgram(); // Terminate Program
            }
        }
    }

    // Faction menu
    private static void getFactionOption() {
        while (true) {
            Utility.printNumberedArray(FACTION_OPTIONS); 
            System.out.print("[0] Return\n");
            int userInput = Utility.getUserInputInt("Choose a faction to calculate", FACTION_OPTIONS_MIN, FACTION_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> underDevelopment(); // Steel Meridian
                case 2 -> underDevelopment(); // Arbiters of Hexis
                case 3 -> underDevelopment(); // Cephalon Suda
                case 4 -> underDevelopment(); // The Perrin Sequence
                case 5 -> underDevelopment(); // Red Veil
                case 6 -> underDevelopment(); // New Loka
                case 0 -> { return; } // Breaks out of the loop and method.
            }
        }
    }

    // Temporary method.
    private static void underDevelopment () {
        // Used to check if the switch case works.
        System.out.print("Feature under development.\n");
        Utility.inputBuffer();
    }

    ////////////////////////////////////////
    /// MAIN

    public static void main(String[] args) {
        getSyndicateOption();
        getFactionOption();
    }

}