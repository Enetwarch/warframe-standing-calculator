import calc.Calculator;
import data.Data;
import util.Utility;

public class Main {

    private static final String[] SYNDICATE_OPTIONS = {
        Data.Syndicates.CONCLAVE.getSyndicate(),
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
    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = SYNDICATE_OPTIONS.length;


    ////// MENU METHODS


    // Syndicate menu
    private static void getSyndicateOption() {
        while (true) {
            Utility.printNumberedArray(SYNDICATE_OPTIONS);
            System.out.print("[0] Exit Program\n");
            int userInput = Utility.getUserInputInt("Choose a syndicate to calculate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> Data.conclave.calculateToConsole(); // Conclave
                case 2 -> Data.ostron.calculateToConsole(); // Ostron
                case 3 -> Data.theQuills.calculateToConsole(); // The Quills
                case 4-> Data.solarisunited.calculateToConsole(); // Solaris United
                case 5 -> Data.voxSolaris.calculateToConsole(); // Vox Solaris
                case 6 -> Data.ventkids.calculateToConsole(); // Ventkids
                case 7 -> Data.entrati.calculateToConsole(); // Entrati
                case 8 -> Data.necraloid.calculateToConsole(); // Necraloid
                case 9 -> Data.theHoldfasts.calculateToConsole(); // The Holdfasts
                case 10 -> Data.cavia.calculateToConsole(); // Cavia
                case 11 -> Data.theHex.calculateToConsole(); // The Hex
                case 0 -> terminateProgram(); // Terminate Program
            }
        }
    }

    public static void terminateProgram() {
        StringBuilder terminateProgram = new StringBuilder();
        terminateProgram.append("Warframe Standing Calculator\n");
        terminateProgram.append("Code by: Enetwarch\n");
        System.out.print(terminateProgram);
        Utility.scanner.close();
        System.exit(0);
    }


    ////// MAIN


    public static void main(String[] args) {
        Calculator.getMasteryRank();
        getSyndicateOption();
    }

}