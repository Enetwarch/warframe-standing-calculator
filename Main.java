import calc.Calculator;
import data.Conclave;
import data.Ostron;
import data.TheQuills;
import data.SolarisUnited;
import data.VoxSolaris;
import data.Ventkids;
import data.Entrati;
import data.Necraloid;
import data.TheHoldfasts;
import data.Cavia;
import data.TheHex;
import data.Syndicate;
import utilities.Output;
import utilities.Input;

public class Main {

    private static final Calculator conclave = new Calculator(Conclave.SYNDICATE_NAME, Conclave.RANK_RECORD, Conclave.SACRIFICE_RECORD, Conclave.RESOURCE_RECORD);
    private static final Calculator ostron = new Calculator(Ostron.SYNDICATE_NAME, Ostron.RANK_RECORD, Ostron.SACRIFICE_RECORD, Ostron.RESOURCE_RECORD);
    private static final Calculator theQuills = new Calculator(TheQuills.SYNDICATE_NAME, TheQuills.RANK_RECORD, TheQuills.SACRIFICE_RECORD, TheQuills.RESOURCE_RECORD);
    private static final Calculator solarisUnited = new Calculator(SolarisUnited.SYNDICATE_NAME, SolarisUnited.RANK_RECORD, SolarisUnited.SACRIFICE_RECORD, SolarisUnited.RESOURCE_RECORD);
    private static final Calculator voxSolaris = new Calculator(VoxSolaris.SYNDICATE_NAME, VoxSolaris.RANK_RECORD, VoxSolaris.SACRIFICE_RECORD, VoxSolaris.RESOURCE_RECORD);
    private static final Calculator ventkids = new Calculator(Ventkids.SYNDICATE_NAME, Ventkids.RANK_RECORD, Ventkids.SACRIFICE_RECORD, Ventkids.RESOURCE_RECORD);
    private static final Calculator entrati = new Calculator(Entrati.SYNDICATE_NAME, Entrati.RANK_RECORD, Entrati.SACRIFICE_RECORD, Entrati.RESOURCE_RECORD);
    private static final Calculator necraloid = new Calculator(Necraloid.SYNDICATE_NAME, Necraloid.RANK_RECORD, Necraloid.SACRIFICE_RECORD, Necraloid.RESOURCE_RECORD);
    private static final Calculator theHoldfasts = new Calculator(TheHoldfasts.SYNDICATE_NAME, TheHoldfasts.RANK_RECORD, TheHoldfasts.SACRIFICE_RECORD, TheHoldfasts.RESOURCE_RECORD);
    private static final Calculator cavia = new Calculator(Cavia.SYNDICATE_NAME, Cavia.RANK_RECORD, Cavia.SACRIFICE_RECORD, Cavia.RESOURCE_RECORD);
    private static final Calculator theHex = new Calculator(TheHex.SYNDICATE_NAME, TheHex.RANK_RECORD, TheHex.SACRIFICE_RECORD, TheHex.RESOURCE_RECORD);

    private static final String[] SYNDICATE_OPTIONS = {
        Syndicate.CONCLAVE.getSyndicate(),
        Syndicate.OSTRON.getSyndicate(),
        Syndicate.THE_QUILLS.getSyndicate(),
        Syndicate.SOLARIS_UNITED.getSyndicate(),
        Syndicate.VOX_SOLARIS.getSyndicate(),
        Syndicate.VENTKIDS.getSyndicate(),
        Syndicate.ENTRATI.getSyndicate(),
        Syndicate.NECRALOID.getSyndicate(),
        Syndicate.THE_HOLDFASTS.getSyndicate(),
        Syndicate.CAVIA.getSyndicate(),
        Syndicate.THE_HEX.getSyndicate()
    };
    
    private static final int SYNDICATE_OPTIONS_MIN = 0;
    private static final int SYNDICATE_OPTIONS_MAX = SYNDICATE_OPTIONS.length;

    private static void getSyndicateOption() {
        while (true) {
            Output.printNumberedArray(SYNDICATE_OPTIONS);
            System.out.print("0 Exit Program\n");
            int userInput = Input.getUserInputInt("Choose a syndicate to calculate", SYNDICATE_OPTIONS_MIN, SYNDICATE_OPTIONS_MAX);
            System.out.print("\n");
            switch (userInput) {
                case 1 -> conclave.calculateToConsole(); // Conclave
                case 2 -> ostron.calculateToConsole(); // Ostron
                case 3 -> theQuills.calculateToConsole(); // The Quills
                case 4-> solarisUnited.calculateToConsole(); // Solaris United
                case 5 -> voxSolaris.calculateToConsole(); // Vox Solaris
                case 6 -> ventkids.calculateToConsole(); // Ventkids
                case 7 -> entrati.calculateToConsole(); // Entrati
                case 8 -> necraloid.calculateToConsole(); // Necraloid
                case 9 -> theHoldfasts.calculateToConsole(); // The Holdfasts
                case 10 -> cavia.calculateToConsole(); // Cavia
                case 11 -> theHex.calculateToConsole(); // The Hex
                case 0 -> terminateProgram(); // Terminate Program
            }
        }
    }

    private static void terminateProgram() {
        StringBuilder terminateProgram = new StringBuilder();
        terminateProgram.append("Warframe Standing Calculator\n");
        terminateProgram.append("Code by: Enetwarch\n");
        System.out.print(terminateProgram);
        Input.scanner.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        Calculator.getMasteryRank();
        getSyndicateOption();
    }

}