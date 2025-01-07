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
    }; // All syndicates after the 1999 update.
    private static final String[] FACTION_OPTIONS = {
        Data.Syndicates.STEEL_MERIDIAN.getSyndicate(),
        Data.Syndicates.ARBITERS_OF_HEXIS.getSyndicate(),
        Data.Syndicates.CEPHALON_SUDA.getSyndicate(),
        Data.Syndicates.THE_PERRIN_SEQUENCE.getSyndicate(),
        Data.Syndicates.RED_VEIL.getSyndicate(),
        Data.Syndicates.NEW_LOKA.getSyndicate()
    }; // All faction syndcates.
    // Planning to improve enum knowledge to sort these arrays out without repetition of code.
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
                case 2 -> Data.conclave.calculateSampleOutput(); // Conclave
                case 3 -> Data.cephalonSimaris.calculateSampleOutput(); // Cephalon Simaris
                case 4 -> Data.ostron.calculateSampleOutput(); // Ostron
                case 5 -> Data.theQuills.calculateSampleOutput(); // The Quills
                case 6 -> Data.solarisunited.calculateSampleOutput(); // Solaris United
                case 7 -> Data.voxSolaris.calculateSampleOutput(); // Vox Solaris
                case 8 -> Data.ventkids.calculateSampleOutput(); // Ventkids
                case 9 -> Data.entrati.calculateSampleOutput(); // Entrati
                case 10 -> Data.necraloid.calculateSampleOutput(); // Necraloid
                case 11 -> Data.theHoldfasts.calculateSampleOutput(); // The Holdfasts
                case 12 -> Data.cavia.calculateSampleOutput(); // Cavia
                case 13 -> Data.theHex.calculateSampleOutput(); // The Hex
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
                case 1 -> Data.steelMeridian.calculateSampleOutput(); // Steel Meridian
                case 2 -> Data.arbitersOfHexis.calculateSampleOutput(); // Arbiters of Hexis
                case 3 -> Data.cephalonSuda.calculateSampleOutput(); // Cephalon Suda
                case 4 -> Data.thePerrinSequence.calculateSampleOutput(); // The Perrin Sequence
                case 5 -> Data.redVeil.calculateSampleOutput(); // Red Veil
                case 6 -> Data.newLoka.calculateSampleOutput(); // New Loka
                case 0 -> { return; } // Breaks out of the loop and method.
            }
        }
    }

    // Temporary method.
    private static void underDevelopment() {
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