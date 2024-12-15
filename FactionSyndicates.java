public class FactionSyndicates {

    static String[] 
    factionSyndicates = {
        "Steel Meridian", 
        "Arbiters of Hexis", 
        "Cephalon Suda", 
        "The Perrin Sequence", 
        "Red Veil", 
        "New Loka"
    };
    static double[][]
    alliedOpposedEnemy = {
        {1.00, 0, 0, -1.00, 0.50, -0.50},
        {0, 1.00, 0.50, -0.50, -1.00, 0},
        {0, .50, 1.00, 0, -0.50, -1.00},
        {-1.00, -0.50, 0, 1.00, 0, 0.50},
        {0.50, -1.00, -0.50, 0, 1.00, 0},
        {-0.50, 0, -1.00, 0.50, 0, 1.00}
    };

    static void chooseFactionSyndicate() {
        System.out.printf(
            """
            %s
            Choose a faction syndicate
            1. Steel Meridian
            2. Arbiters of Hexis
            3. Cephalon Suda
            4. The Perrin Sequence
            5. Red Veil
            6. New Loka
            %s

            """
            , Main.newPrintInstance
            , Main.newPrintInstance
        );
    }

    static void getUserInput() {
        while (true) { 
            System.out.printf(
                "%s\nSelect the faction you chose: >> "
                , Main.newInputInstance
            );
            try {
                int userFaction = Main.scanner.nextInt();
                if (userFaction >= 1 && userFaction <= 6) {
                    break;
                } else {
                    Main.inputError();
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    static void 

    public static void main(String[] args) {
        while (true) {
            chooseFactionSyndicate();
            getUserInput();

        }
    }
}
