package data;
import java.util.Scanner;

public class Format {

    public static Scanner scanner = new Scanner(System.in);


    //////////////////////////////


    public static void inputError(
        int min, 
        int max
        ) {
        System.out.printf(
            """
            Invalid input. Only accepts numbers from %d to %d.
            """
            , min
            , max
        );
    }
    
    public static int getUserInput(
        String message, 
        int min, 
        int max
        ) {
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
                    scanner.nextLine();
                    inputError(min, max);
                }
            } catch (Exception e) {
                scanner.nextLine();
                inputError(min, max);
            }
        }
        scanner.nextLine();
        return userInput;
    }

    public static void inputBuffer() {
        System.out.print(
            "Press enter to proceed >> "
        );
        scanner.nextLine();
    }


    //////////////////////////////////
    

    public static void pluralizeNames(
        int[] amount, 
        String[] name
        ) {
        for (int i = 0; i < name.length; i++) {
            if (amount[i] > 1) {
                name[i] = name[i] + "s";
            }
        }
    }
    
    public static String pluralizeDays(int days) {
        if (days > 1) {
            return "s";
        } else {
            return "";
        }
    }


    //////////////////////////////////////////////

    
    public static void printArray(String[] list, int min) {
        for (int i = 0; i < list.length; i++) {
            System.out.printf(
                """
                %d. %s     
                """
                , i + min
                , list[i]
            );
        }
    }

    public static void printResourceArray(
        int[] amount, 
        String[] name
        ) {
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

}