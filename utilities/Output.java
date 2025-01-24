package utilities;

public class Output {

    public static String EXIT_PROGRAM = "Exit Program";

    public static String pluralizeNoun(int amount) {
        if (amount != 1) {
            return "s";
        } else {
            return "";
        }
    }

    public static void printNumberedArray(String[] array) {
        StringBuilder numberedArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            numberedArray.append(String.format("%d %s%n", i + 1, array[i]));
        }
        System.out.print(numberedArray);
    }

    public static int arraySumInt(int[] array) {
        int arraySum = 0;
        for (int number : array) {
            arraySum += number;
        }
        return arraySum;
    }

    public static void terminateProgram() {
        StringBuilder terminateProgram = new StringBuilder();
        terminateProgram.append(String.format("Warframe Standing Calculator%n"));
        terminateProgram.append(String.format("Code by: Enetwarch%n"));
        System.out.print(terminateProgram);
        Input.scanner.close();
        System.exit(0);
    }

}