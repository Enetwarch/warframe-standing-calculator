import calc.Calculator;
import data.Data;
import util.Utility;

public class Main {

    private static final String[] SYNDICATE_OPTIONS = {
        Data.Syndicates.FACTION_SYNDICATES.getSyndicate(),
        Data.Syndicates.CONCLAVE.getSyndicate(),
        Data.Syndicates.CEPHALON_SIMARIS.getSyndicate(),
        Data.Syndicates.OSTRON.getSyndicate(),
        Data.Syndicates.THE_QUILLS.getSyndicate(),
        Data.Syndicates.SOLARIS_UNITED.getSyndicate(),
        Data.Syndicates.VOX_SOLARIS.getSyndicate(),
        Data.Syndicates.VENTKIDS.getSyndicate(),
        Data.Syndicates.ENTRATI.getSyndicate(),
        Data.Syndicates.NECRALOID.getSyndicate(),
        Data.Syndicates.THE_HOLDFASTS.getSyndicate(),
        Data.Syndicates.CAVIA.getSyndicate(),
        Data.Syndicates.THE_HEX.getSyndicate()
    }; // All syndicates post-1999 update.
    private static final String[] FACTION_OPTIONS = {
        Data.Syndicates.STEEL_MERIDIAN.getSyndicate(),
        Data.Syndicates.ARBITERS_OF_HEXIS.getSyndicate(),
        Data.Syndicates.CEPHALON_SUDA.getSyndicate(),
        Data.Syndicates.THE_PERRIN_SEQUENCE.getSyndicate(),
        Data.Syndicates.RED_VEIL.getSyndicate(),
        Data.Syndicates.NEW_LOKA.getSyndicate()
    };
    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = SYNDICATE_OPTIONS.length;
    private static final int FACTION_OPTIONS_MIN = 0;
    private static final int FACTION_OPTIONS_MAX = FACTION_OPTIONS.length;


    ////// MENU METHODS


    // Syndicate menu
    private static void getSyndicateOption() {
        while (true) {
            Utility.printNumberedArray(SYNDICATE_OPTIONS);
            System.out.print("[0] Exit Program\n");
            int userInput = Utility.getUserInputInt("Choose a syndicate to calculate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> getFactionOption(); // Faction Syndicates
                case 2 -> Data.conclave.calculateToConsole(); // Conclave
                case 3 -> Data.cephalonSimaris.calculateToConsole(); // Cephalon Simaris
                case 4 -> Data.ostron.calculateToConsole(); // Ostron
                case 5 -> Data.theQuills.calculateToConsole(); // The Quills
                case 6 -> Data.solarisunited.calculateToConsole(); // Solaris United
                case 7 -> Data.voxSolaris.calculateToConsole(); // Vox Solaris
                case 8 -> Data.ventkids.calculateToConsole(); // Ventkids
                case 9 -> Data.entrati.calculateToConsole(); // Entrati
                case 10 -> Data.necraloid.calculateToConsole(); // Necraloid
                case 11 -> Data.theHoldfasts.calculateToConsole(); // The Holdfasts
                case 12 -> Data.cavia.calculateToConsole(); // Cavia
                case 13 -> Data.theHex.calculateToConsole(); // The Hex
                case 0 -> terminateProgram(); // Terminate Program
            }
        }
    }

    // Faction menu
    private static void getFactionOption() {
        Utility.printNumberedArray(FACTION_OPTIONS);
        Calculator.getPledgedFaction();
        while (true) {
            Utility.printNumberedArray(FACTION_OPTIONS);
            System.out.print("[0] Return\n");
            int userInput = Utility.getUserInputInt("Choose a faction to calculate", FACTION_OPTIONS_MIN, FACTION_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> Data.steelMeridian.calculateToConsole(); // Steel Meridian
                case 2 -> Data.arbitersOfHexis.calculateToConsole(); // Arbiters of Hexis
                case 3 -> Data.cephalonSuda.calculateToConsole(); // Cephalon Suda
                case 4 -> Data.thePerrinSequence.calculateToConsole(); // The Perrin Sequence
                case 5 -> Data.redVeil.calculateToConsole(); // Red Veil
                case 6 -> Data.newLoka.calculateToConsole(); // New Loka
                case 0 -> { return; } // Breaks out of the loop and method.
            }
        }
    }

    public static void terminateProgram() {
        System.out.print(
            """
            Thank you for using Warframe Standing Calculator!
            Code by: Enetwarch     
            """
        );
        Utility.scanner.close();
        System.exit(0);
    }


    ////// MAIN


    public static void main(String[] args) {
        Calculator.getMasteryRank();
        getSyndicateOption();
        getFactionOption();
    }

}