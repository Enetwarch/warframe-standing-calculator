import calculator.Faction;
import data.Format;
import data.Syndicates;

public class Console {

    private static String[] syndicateOptions = {
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


    ////////////////////////////////////


    // Selection list for choosing what to calculate.
    private static void getSyndicate() {
        Format.printArray(syndicateOptions,1); // Prints the contents of syndicate options in a listed numbered form.
        Format.printExitProgram(); // Prints out a 0. Exit Program as the last item in the list.
        int userInput = Format.getUserInput("Choose a syndicate",0,syndicateOptions.length); // Asks user to choose a syndicate based on the number.
        switch (userInput) { // Chooses the syndicate based on the user input.
            case 1: 
                Faction.factionSyndicates();
                break; // Faction Syndicates uses Faction calculations.
            case 2: 
                Syndicates.conclave.calculateToConsole();
                break; // Conclave syndicate uses Standard calculations.
            case 3: 
                Syndicates.cephalonSimaris.calculateToConsole();
                break; // Cephalon Simaris syndicate uses OneRank calculations.
            case 4: 
                Syndicates.ostron.calculateToConsole();
                break; // Ostron syndicate uses Standard calculations.
            case 5:
                Syndicates.theQuills.calculateToConsole();
                break; // The Quills syndicate uses Standard calculations.
            case 6: 
                Syndicates.solarisUnited.calculateToConsole();
                break; // Solaris United syndicate uses Standard calculations.
            case 7: 
                Syndicates.voxSolaris.calculateToConsole();
                break; // Vox Solaris syndicate uses Standard calculations.
            case 8: 
                Syndicates.ventkids.calculateToConsole();
                break; // Ventkids syndicate uses Standard calculations.
            case 9: 
                Syndicates.entrati.calculateToConsole();
                break; // Entrati syndicate uses Standard calculations.
            case 10: 
                Syndicates.necraloid.calculateToConsole();
                break; // Necraloid syndicate uses Standard calculations.
            case 11: 
                Syndicates.theHoldfasts.calculateToConsole();
                break; // The Holdfasts syndicate uses Standard calculations.
            case 12:
                Syndicates.cavia.calculateToConsole();
                break; // Cavia syndicate uses Standard calculations.
            case 0: 
                Format.terminateProgram(); // Terminates program.
        } // The break;s prevent the program from "falling" through the switch case structure.
    }


    ////////////////////////////////////////


    // Main
    public static void main(String[] args) {
        Syndicates.getMasteryRank(); // Gets the mastery rank of the user.
        Syndicates.makeSyndicates(); // Initializes the objects to take into account the changes in mastery rank and standing cap.
        while (true) { 
            getSyndicate(); // 
        }
    }

}