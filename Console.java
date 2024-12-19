import calculator.Faction;
import data.Format;
import data.Syndicates;

public class Console {

    static String[] syndicateOptions = {
        "Faction Syndicates",
        "Conclave",
        "Cephalon Simaris",
        "Ostron",
        "The Quills",
        "Solaris United",
        "Vox Solaris",
        "Ventkids",
        "Entrati",
        "Necraloid",
        "The Holdfasts",
        "Cavia"
    };


    ////////////////////////////


    static void getSyndicate() {
        Format.printArray(
            syndicateOptions,
            1    
        );
        Format.printExitProgram();
        int userInput = Format.getUserInput(
            "Choose a syndicate",
            0,
            syndicateOptions.length
        );
        switch (userInput) {
            case 1: 
                Faction.factionSyndicates();
                break;
            case 2: 
                Syndicates.conclave.calculateToConsole();
                break;
            case 3: 
                Syndicates.cephalonSimaris.calculateToConsole();
                break;
            case 4: 
                Syndicates.ostron.calculateToConsole();
                break;
            case 5:
                Syndicates.theQuills.calculateToConsole();
                break;
            case 6: 
                Syndicates.solarisUnited.calculateToConsole();
                break;
            case 7: 
                Syndicates.voxSolaris.calculateToConsole();
                break;
            case 8: 
                Syndicates.ventkids.calculateToConsole();
                break;
            case 9: 
                Syndicates.entrati.calculateToConsole();
                break;
            case 10: 
                Syndicates.necraloid.calculateToConsole();
                break;
            case 11: 
                Syndicates.theHoldfasts.calculateToConsole();
                break;
            case 12:
                Syndicates.cavia.calculateToConsole();
                break;
            case 0: 
                Format.terminateProgram();
                break;
        }
    }


    ////////////////////////////////////////


    public static void main(String[] args) {
        Syndicates.getMasteryRank();
        Syndicates.makeSyndicates();
        while (true) { 
            getSyndicate();
        }
    }

}