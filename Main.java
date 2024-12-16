public class Main {
    public static int 
    masteryRank = 0, 
    standingCap = 16000,
    userInput;
    static String[]
    syndicateOptions = {
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

    static void getMasteryRank() {
        masteryRank = Format.getUserInput(
            "Enter your mastery rank",
            0,
            34
        );
        standingCap += masteryRank * 500;
    }

    static void getSyndicate() {
        Format.printArray(
            syndicateOptions
        );
        Format.printExitProgram();
        userInput = Format.getUserInput(
            "Choose a syndicate",
            0,
            syndicateOptions.length
        );
        switch (userInput) {
            case 0: Format.terminateProgram();
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
        }
    }

    public static void main(String[] args) {
        getMasteryRank();
        while (true) { 
            getSyndicate();
        }
    }
}