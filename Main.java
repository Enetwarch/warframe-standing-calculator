import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String 
    inputInstance = "+========================================================================+",
    printInstance = "+------------------------------------------------------------------------+";
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

    static void startPrint() {
        System.out.printf(
            """
            %s        
            """
            , printInstance
        );
    }

    static void endPrint() {
        System.out.printf(
            """
            %s

            """
            , printInstance
        );
    }

    public static void printMessage(String message) {
        startPrint();
        System.out.print(
            message
        );
        endPrint();
    }

    public static void printArray(String[] list) {
        startPrint();
        for (int i = 0; i < list.length; i++) {
            System.out.printf(
                """
                %d %s     
                """
                , i + 1
                , list[i]
            );
        }
        endPrint();
    }

    static void startInput() {
        System.out.printf(
            """
            %s        
            """
            , inputInstance
        );
    }

    static void endInput() {
        System.out.print(
            """
                    
            """
        );
    }

    static void inputError() {
        System.out.print(
            """
            Invalid input.

            """
        );
        scanner.nextLine();
    }

    public static int getUserInput(String message, int min, int max) {
        int userInput = -1;
        while (true) {
            startInput();
            System.out.printf(
                "%s: >> %s"
                , message
                , ""
            );
            try {
                userInput = scanner.nextInt();
                if (userInput >= min && userInput <= max) {
                    break;
                } else {
                    inputError();
                }
            } catch (Exception e) {
                inputError();
            }
        }
        endInput();
        return userInput;
    }

    static void welcomeMessage() {
        printMessage(
            """
            Welcome to Warframe Standing Calculator! This is where it will display
            the amount of days it takes to reach a particular rank, the grinding
            needed for the materials required, and the days your excess standing
            materials will last for. Do note that this was made in November 2024,
            which is before the Warframe 1999 update. 
            """
        );
    }

    static void getMasteryRank() {
        masteryRank = getUserInput(
            "Enter your mastery rank (Accepts ranks 0 to 34)",
            0, 34
        );
        standingCap += masteryRank * 500;
    }

    static void syndicateOptions() {
        printArray(syndicateOptions);
    }

    static void getSyndicate() {
        userInput = getUserInput(
            "Choose a syndicate (0 to 12)",
            0, 12
        );
        switch (userInput) {
            case 0: 
                System.out.print("Program terminated."); 
                scanner.close();
                System.exit(0);
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
        welcomeMessage();
        getMasteryRank();
        while (true) { 
            syndicateOptions();
            getSyndicate();
        }
    }
}