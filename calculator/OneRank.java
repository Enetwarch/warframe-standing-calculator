package calculator;
import data.Format;
import data.Syndicates;

public class OneRank {
    private String syndicateName;
    private int maxStanding;
    private int userStanding;
    private static int standingCap = Syndicates.standingCap;
    private static int standingMin = 0;
    // Only works around standing, no other data.
    public OneRank(String syndicateName, int maxStanding) {
        // Constructor for OneRank objects.
        this.syndicateName = syndicateName;
        this.maxStanding = maxStanding;
        this.userStanding = 0;
    }


    ///////////////////////////////////////////////////////////////////////


    // Input method
    private static int getStanding(String syndicateName, int maxStanding) {
        int userInput = Format.getUserInput(syndicateName + " standing", standingMin, maxStanding);
        return userInput;
    }

    // Output method
    private static void analyzeDaysToMax(int userStanding, int maxStanding) {
        if (userStanding == maxStanding) {
            System.out.print("You are already at max standing.\n"); 
            // Stops any further calculations since standing is already maxed.
            return; // Stops the method.
        }
        int days = 0;
        while (userStanding < maxStanding) {
            // Keeps incrementing the days until user standing is past max standing.
            days += 1;
            userStanding += standingCap;
        }
        String isPlural = Format.pluralizeDays(days); // Adds "s" to day if it is more than 1.
        System.out.printf("It will take %d day%s to max out your standing with %,d leftover standing.\n", days, isPlural, userStanding - maxStanding); 
        // Outputs the days it takes to reach max standing.
    }


    //////////////////////////////////


    // Final method
    public void calculateToConsole() {
        this.userStanding = getStanding(this.syndicateName, this.maxStanding);
        analyzeDaysToMax(this.userStanding, this.maxStanding);
        Format.inputBuffer();
    } // Combines all the methods into one.

}