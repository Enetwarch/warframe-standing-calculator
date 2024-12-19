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
        Format.printArray(syndicateOptions);
        Format.printExitProgram();
        int userInput = Format.getUserInput(
            "Choose a syndicate",
            0,
            syndicateOptions.length
        );
        switch (userInput) {
            case 1: 

                break;
            case 2: 
                Syndicates.cephalonSimaris.calculateToConsole();
                break;
            case 3: 

                break;
            case 4: 

                break;
            case 5:

                break;
            case 6: 

                break;
            case 7: 

                break;
            case 8: 

                break;
            case 9: 

                break;
            case 10: 

                break;
            case 11: 

                break;
            case 12:

                break;
            case 0: 
                Format.terminateProgram();
                break;
        }
    }


    ////////////////////////////////////////


    public static void main(String[] args) {
        Syndicates.getMasteryRank();
        while (true) { 
            getSyndicate();
        }
    }

}