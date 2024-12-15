import java.util.Scanner;
public class Format {
    public static Scanner 
    scanner = new Scanner(System.in);
    public static String 
    inputInstance = "+========================================================================+",
    printInstance = "+------------------------------------------------------------------------+";

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
                %d. %s     
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

    static void inputError(int min, int max) {
        System.out.printf(
            """
            Invalid input. Only accepts numbers from %d to %d

            """
            , min
            , max
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
                    inputError(min, max);
                }
            } catch (Exception e) {
                inputError(min, max);
            }
        }
        endInput();
        return userInput;
    }

    public static void terminateProgram() {
        printMessage(
            """
            Program terminated
            """
        );
        scanner.close();
        System.exit(0);
    }
}
