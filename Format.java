import java.util.Scanner;
public class Format {
    public static Scanner 
    scanner = new Scanner(System.in);

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

    static void inputError(int min, int max) {
        System.out.printf(
            """
            Invalid input. Only accepts numbers from %d to %d.
            """
            , min
            , max
        );
        scanner.nextLine();
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

    public static int getUserInput(String message, int min, int max) {
        int userInput = -1;
        while (true) {
            System.out.printf(
                "%s: >> "
                , message
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
        if (userInput == 0) {
            terminateProgram();
        }
        return userInput;
    }

    public static void inputBuffer() {
        System.out.print(
            "Press enter to proceed >> "
        );
        scanner.nextLine();
    }
}