import factions.FactionSyndicates;
import java.util.ArrayList;
import java.util.Scanner;
import syndicates.Cavia;
import syndicates.CephalonSimaris;
import syndicates.Conclave;
import syndicates.Entrati;
import syndicates.Necraloid;
import syndicates.Ostron;
import syndicates.SolarisUnited;
import syndicates.TheHoldfasts;
import syndicates.TheQuills;
import syndicates.Ventkids;
import syndicates.VoxSolaris;

public class Main {
    static FactionSyndicates factionsSyndicates = new FactionSyndicates();
    static Conclave conclave = new Conclave();
    static CephalonSimaris cephalonSimaris = new CephalonSimaris();
    static Ostron ostron = new Ostron();
    static TheQuills theQuills = new TheQuills();
    static SolarisUnited solarisUnited = new SolarisUnited();
    static VoxSolaris voxSolaris = new VoxSolaris();
    static Ventkids ventkids = new Ventkids();
    static Entrati entrati = new Entrati();
    static Necraloid necraloid = new Necraloid();
    static TheHoldfasts theHoldfasts = new TheHoldfasts();
    static Cavia cavia = new Cavia();

    public static Scanner scanner = new Scanner(System.in);

    public static int masteryRank = 0;
    public static int standingCap = 16000;
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


    /////////////////////////////////////////////////

    
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

    
    //////////////////////////////////////////////

    
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


    ///////////////////////////////////////


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


    //////////////////////////////////////////////////////////////////////


    public static int getRank(String[] rankTitles, String syndicateName) {
        printRankArray(rankTitles);
        int userInput = getUserInput(
            syndicateName + " rank",
            0,
            rankTitles.length - 1
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

    public static String pluralizeDays(int days) {
        if (days > 1) {
            return "s";
        } else {
            return "";
        }
    }

    public static void analyzeDaysToMax(int userRank, String[] rankTitles, int userStanding) {
        int days = 0;
        if (userRank == rankTitles.length) {
            System.out.printf(
                """
                You are already max rank in this syndicate.     
                """
            );
            return;
        }
        while (userRank != rankTitles.length) {
            days += 1;
            if (standingPerRank[userRank] > userStanding + standingCap) {
                userStanding += standingCap;
            } else {
                userStanding = userStanding + standingCap - standingPerRank[userRank];
                userRank += 1;
            }
        }
        String isPlural = pluralizeDays(days);
        System.out.printf(
            """
            It will take %d day%s to max out your rank with %,d leftover standing.     
            """
            , days
            , isPlural
            , userStanding
        );
    }

    public static void analyzeResourcesToMax(int userRank, String[] rankTitles, String[][] rankSacrificeNames, int[][] rankSacrificeAmount) {
        ArrayList<String> sacrificeNames = new ArrayList<>();
        ArrayList<Integer> sacrificeAmount = new ArrayList<>();
        if (userRank == rankTitles.length) {
            return;
        }
        for (int i = userRank; i < rankSacrificeNames.length; i++) {
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
        String isPlural = pluralizeDays(days);
        System.out.printf(
            """
            You have %,d total standing from syndicate standing resources that can last for %,d day%s.     
            """
            , totalStanding
            , days
            , isPlural
        );
    }

    public static void inputBuffer() {
        scanner.nextLine();
        System.out.print(
            "Press enter to proceed >> "
        );
        scanner.nextLine();
    }

    public static void getAnalysis(int userRank, String[] rankTitles, int userStanding, String[][] rankSacrificeNames, int[][] rankSacrificeAmount, int[] resourceOwned, int[] resourceStanding) {
        analyzeDaysToMax( 
            userRank,
            rankTitles,
            userStanding
        );
        analyzeResourcesToMax(
            userRank,
            rankTitles,
            rankSacrificeNames,
            rankSacrificeAmount
        );
        analyzeExcessStanding(
            resourceOwned,
            resourceStanding
        );
        inputBuffer();
    }


    /////////////////////////////////////////////////////////////////////////////


    public static int getStandingNeutral(String syndicateName, int maxStanding) {
        int userInput = getUserInput(
            syndicateName + " standing",
            0,
            maxStanding
        );
        return userInput;
    }

    public static void analyzeDaysToMaxNeutral(int userStanding, int maxStanding) {
        if (userStanding == maxStanding) {
            System.out.printf(
                """
                You are already at max standing. 
                """  
            );
            return;
        }
        int days = 0;
        while (userStanding < maxStanding) {
            days += 1;
            userStanding += standingCap;
        }
        String isPlural = pluralizeDays(days);
        System.out.printf(
            """
            It will take %d day%s to max out your standing with %,d leftover standing.     
            """
            , days
            , isPlural
            , userStanding - maxStanding
        );
    }

    public static void getAnalysisNeutral(int userStanding, int maxStanding) {
        analyzeDaysToMaxNeutral(
            userStanding,
            maxStanding
        );
        inputBuffer();
    }


    //////////////////////////////
     
     
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
                factionsSyndicates.main();
                break;
            case 2: 
                conclave.main();
                break;
            case 3: 
                cephalonSimaris.main();
                break;
            case 4: 
                ostron.main();
                break;
            case 5:
                theQuills.main();
                break;
            case 6: 
                solarisUnited.main();
                break;
            case 7: 
                voxSolaris.main();
                break;
            case 8: 
                ventkids.main();
                break;
            case 9: 
                entrati.main();
                break;
            case 10: 
                necraloid.main();
                break;
            case 11: 
                theHoldfasts.main();
                break;
            case 12:
                cavia.main();
                break;
            case 0: 
                terminateProgram();
        }
    }


    ////////////////////////////////////////


    public static void main(String[] args) {
        getMasteryRank();
        while (true) { 
            getSyndicate();
        }
    }
}