package calculator;
import data.Format;
import data.Syndicates;

public class OneRank {
    private String syndicateName;
    private int maxStanding;
    private int userStanding;
    private static int standingCap;

    public OneRank(
        String syndicateName,
        int maxStanding
        ) {
        this.syndicateName = syndicateName;
        this.maxStanding = maxStanding;
        this.userStanding = 0;
        OneRank.standingCap = Syndicates.standingCap;
    }


    ///////////////////////////////


    private static int getStanding(
        String syndicateName, 
        int maxStanding
        ) {
        int userInput = Format.getUserInput(
            syndicateName + " standing",
            0,
            maxStanding
        );
        return userInput;
    }

    private static void analyzeDaysToMax(
        int userStanding, 
        int maxStanding
        ) {
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
        String isPlural = Format.pluralizeDays(days);
        System.out.printf(
            """
            It will take %d day%s to max out your standing with %,d leftover standing.     
            """
            , days
            , isPlural
            , userStanding - maxStanding
        );
    }

    private static void getAnalysis(
        int userStanding, 
        int maxStanding
        ) {
        analyzeDaysToMax(
            userStanding,
            maxStanding
        );
        Format.inputBuffer();
    }


    //////////////////////////////////


    public void calculateToConsole() {
        this.userStanding = getStanding(
            this.syndicateName, 
            this.maxStanding
            );
        getAnalysis(
            this.userStanding,
            this.maxStanding
        );
    }

}