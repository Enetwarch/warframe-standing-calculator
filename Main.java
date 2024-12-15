import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String 
    newInputInstance = "+========================================================================+",
    newPrintInstance = "+------------------------------------------------------------------------+";
    public static int 
    masteryRank = 0, 
    standingCap = 16000;

    public static void mrInputError() {
        System.out.print(
        """
        Invalid input.
        Please enter a valid mastery rank from 0 to 34.
        Press enter to proceed.
        """
        );
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void uiInputError() {
        System.out.print(
        """
        Invalid input.
        Please enter a valid option from 0 to 12.
        Press enter to proceed.
        """
        );
        scanner.nextLine();
        scanner.nextLine();
    }

    static void welcomeMessage() {
        System.out.printf(
        """
        %s
        Welcome to Warframe Standing Calculator! This is where it will display
        the amount of days it takes to reach a particular rank, the grinding
        needed for the materials needed, and the days your excess standing
        materials will last for. Do note that this was made in November 2024,
        which is before the Warframe 1999 update.
        %s

        """
        , newPrintInstance
        , newPrintInstance
        );
    }

    static void getMasteryRank() {
        while (true) { 
            System.out.printf(
            "%s\nPlease enter your master rank: >> "
            , newInputInstance
            );
            try {
                masteryRank = scanner.nextInt(); 
                if (masteryRank >= 0 && masteryRank <= 34) {
                    System.out.print("\n");
                    break;
                } else {
                    mrInputError();
                }
            } catch (Exception e) {
                mrInputError();
            }
        }
        standingCap += masteryRank * 500;
    }

    static void syndicateOptions() {
        System.out.printf(
        """
        %s
        Choose a syndicate
        1. Faction Syndicates
        2. Conclave
        3. Cephalon Simaris
        4. Ostron
        5. The Quills
        6. Solaris United
        7. Vox Solaris
        8. Ventkids
        9. Entrati
        10. Necraloid
        11. The Holdfasts
        12. Cavia
        0. Exit
        %s

        """
        , newPrintInstance
        , newPrintInstance
        );
    }
    
    static int getUserInput() {
        int userInput;
        while (true) {
            System.out.printf(
            "%s\nChoose the number of the syndicate: >> "
            , newInputInstance
            );
            try {
                userInput = scanner.nextInt();
                if (userInput >= 0 && userInput <= 12) {
                    break;
                } else {
                    uiInputError();
                }
            } catch (Exception e) {
                uiInputError();
            }
        }
        return userInput;
    }

    static void syndicateSelect(int userInput) {
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
            int userInput = getUserInput();
            syndicateSelect(userInput);
        }
    }
}