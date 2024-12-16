import java.util.Scanner;
public class Format {
    public static Scanner 
    scanner = new Scanner(System.in);
    public static int
    min = 0;

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
        System.out.printf(
            """
            0. Exit Program
            """
        );
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
        if (userInput == 0) {
            terminateProgram();
        }
        System.out.printf(
            """
            %s
            """
            , ""
        );
        return userInput;
    }
}