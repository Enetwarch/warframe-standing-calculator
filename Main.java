
import java.io.ObjectStreamConstants;
import javax.xml.stream.events.EntityDeclaration;

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
            case 1: FactionSyndicates.main();
            case 2: Conclave.main();
            case 3: CephalonSimaris.main();
            case 4: Ostron.main();
            case 5: TheQuills.main();
            case 6: SolarisUnited.main();
            case 7: VoxSolaris.main();
            case 8: Ventkids.main();
            case 9: Entrati.main();
            case 10: Necraloid.main();
            case 11: TheHoldfasts.main();
            case 12: Cavia.main();
        }
    }

    public static void main(String[] args) {
        getMasteryRank();
        while (true) { 
            getSyndicate();
        }
    }
}