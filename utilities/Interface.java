package utilities;

public record Interface(int input, String output, Runnable runnable) {

    public Interface {
        if (input < 0) {
            throw new IllegalArgumentException("Invalid user input");
        }
    }

    public static void printInterface(Interface[] interfaceArray) {
        StringBuilder printInterface = new StringBuilder();
        for (Interface interfaceElement : interfaceArray) {
            int input = interfaceElement.input;
            String output = interfaceElement.output;
            printInterface.append(String.format("%d %s%n", input, output));
        }
        System.out.print(printInterface);
    }

    public static void inputRunnable(Interface[] interfaceArray, int userInput) {
        for (Interface interfaceElement : interfaceArray) {
            int input = interfaceElement.input;
            if (input == userInput) {
                interfaceElement.runnable().run();
                break;
            }
        }
    }

}