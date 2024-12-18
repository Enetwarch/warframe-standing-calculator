import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static int masteryRank = 0;
    public static int standingCap = 16000;

    public static int[] rankNumbers = {0, 1, 2, 3, 4, 5};
    public static int[] standingPerRank = {5000, 22000, 44000, 70000, 99000, 132000};

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





    public static void inputError(int min, int max) {
        System.out.printf(
            """
            Invalid input. Only accepts numbers from %d to %d.
            """
            , min
            , max
        );
    }

    public static int getUserInput(String message, int min, int max) {
        int userInput = -1;
        while (true) {
            try {
                System.out.printf(
                    "%s: >> "
                    , message
                );
                userInput = scanner.nextInt();
                if (userInput >= min && userInput <= max) {
                    break;
                } else {
                    inputError(min, max);
                }
            } catch (Exception e) {
                inputError(min, max);
            }
        }
        return userInput;
    }





    public static void printArray(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf(
                """
                %d. %s     
                """
                , i + 1
                , list[i]
            );
        }
    }

    public static void printRankArray(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf(
                """
                %d. %s     
                """
                , i
                , list[i]
            );
        }
    }

    public static void pluralizeNames(int[] amount, String[] name) {
        for (int i = 0; i < name.length; i++) {
            if (amount[i] > 1) {
                name[i] = name[i] + "s";
            }
        }
    }

    public static void printResourceArray(int[] amount, String[] name) {
        pluralizeNames(
            amount,
            name    
        );
        for (int i = 0; i < name.length; i++) {
            System.out.printf(
                """
                - %,d %s
                """
                , amount[i]
                , name[i]
            );
        }
    }





    public static void printExitProgram() {
        System.out.print(
            """
            0. Exit Program     
            """
        );
    }

    public static void terminateProgram() {
        System.out.print(
            """
            Program terminated.
            """
        );
        scanner.close();
        System.exit(0);
    }


    


    public static int getRank(String[] rankTitles, String syndicateName) {
        printRankArray(rankTitles);
        int userInput = getUserInput(
            syndicateName + " rank",
            0,
            rankTitles.length
        );
        return userInput;
    }

    public static int getStanding(String syndicateName, int[] standingPerRank, int userRank) {
        int userInput = getUserInput(
            syndicateName + " standing",
            0,
            standingPerRank[userRank]
        );
        return userInput;
    }

    public static int[] getResources(String[] resourceNames) {
        int[] resourceOwned = new int[resourceNames.length];
        for (int i = 0; i < resourceNames.length; i++)
        resourceOwned[i] = Main.getUserInput(
            resourceNames[i] + " owned",
            0,
            Integer.MAX_VALUE
        );
        return resourceOwned;
    }

    public static void analyzeDaysToMax(int userRank, int userStanding) {
        int days = 0;
        if (userRank == 5) {
            System.out.printf(
                """
                You are already max rank in this syndicate.     
                """
            );
            return;
        }
        while (userRank != 5) {
            days += 1;
            if (standingPerRank[userRank] >= userStanding + standingCap) {
                userStanding += standingCap;
            } else {
                userStanding = userStanding + standingCap - standingPerRank[userRank];
                userRank += 1;
            }
        }
        System.out.printf(
            """
            It will take %d days to max out your rank with %,d leftover standing.     
            """
            , days
            , userStanding
        );
    }

    public static void analyzeResourcesToMax(int userRank, String[][] rankSacrificeNames, int[][] rankSacrificeAmount) {
        ArrayList<String> sacrificeNames = new ArrayList<>();
        ArrayList<Integer> sacrificeAmount = new ArrayList<>();
        if (userRank == 5) {
            return;
        }
        for (int i = 0; i < rankSacrificeNames.length; i++) {
            for (int j = 0; j < rankSacrificeNames[i].length; j++) {
                String sacrificeNameString = rankSacrificeNames[i][j];
                int sacrificeAmountInt = rankSacrificeAmount[i][j];
                if (sacrificeNames.contains(sacrificeNameString)) {
                    int index = sacrificeNames.indexOf(sacrificeNameString);
                    sacrificeAmount.set(index, sacrificeAmount.get(index) + sacrificeAmountInt);
                } else {
                    sacrificeNames.add(sacrificeNameString);
                    sacrificeAmount.add(sacrificeAmountInt);
                }
            }
        }
        int[] sacrificeAmountArray = new int[sacrificeAmount.size()];
        for (int i = 0; i < sacrificeAmount.size(); i++) {
            sacrificeAmountArray[i] = sacrificeAmount.get(i);
        }
        String[] sacrificeNamesArray = sacrificeNames.toArray(new String[0]);
        System.out.print(
            """
            Here are the resources you need to sacrifice to reach max rank:     
            """
        );
        printResourceArray(
            sacrificeAmountArray,
            sacrificeNamesArray
        );
    }

    public static void analyzeExcessStanding(int[] resourceOwned, int[] resourceStanding) {
        int totalStanding = 0;
        for (int i = 0; i < resourceOwned.length; i++) {
            totalStanding += resourceOwned[i] * resourceStanding[i];
        }
        int days = totalStanding / standingCap;
        System.out.printf(
            """
            You have %,d total standing from syndicate standing resources that can last for %d days.     
            """
            , totalStanding
            , days
        );
    }

    public static void inputBuffer() {
        System.out.print(
            "Press enter to proceed >> "
        );
        scanner.nextLine();
    }

    public static void getAnalysis(int userRank, int userStanding, String[][] rankSacrificeNames, int[][] rankSacrificeAmount, int[] resourceOwned, int[] resourceStanding) {
        analyzeDaysToMax( 
            userRank,
            userStanding
        );
        analyzeResourcesToMax(
            userRank,
            rankSacrificeNames,
            rankSacrificeAmount
        );
        analyzeExcessStanding(
            resourceOwned,
            resourceStanding
        );
        inputBuffer();
    }





    static void getMasteryRank() {
        masteryRank = getUserInput(
            "Enter your mastery rank",
            0,
            34
        );
        standingCap += masteryRank * 500;
    }

    static void getSyndicate() {
        printArray(syndicateOptions);
        printExitProgram();
        int userInput = getUserInput(
            "Choose a syndicate",
            0,
            syndicateOptions.length
        );
        switch (userInput) {
            case 1: 
                break;
            case 2: 
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
                VoxSolaris.main();
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
                terminateProgram();
        }
    }

    public static void main(String[] args) {
        getMasteryRank();
        while (true) { 
            getSyndicate();
        }
    }
}