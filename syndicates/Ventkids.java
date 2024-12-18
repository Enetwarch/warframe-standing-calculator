package syndicates;
import Main;

public class Ventkids {
    static String syndicateName = "Ventkids";
    static int userRank = 0;
    static int userStanding = 0;

    static String[] rankTitles = {
        "Neutral", 
        "Glinty", 
        "Whozit",
        "Proper Felon",
        "Primo",
        "Logical"
    };


    ///////////////////////


    static void getRank() {
        userRank = Main.getRank(
            rankTitles,
            syndicateName
        );
    }

    static void getStanding() {
        userStanding = Main.getStanding(
            syndicateName, 
            Main.standingPerRank, 
            userRank);
    }

    static void getAnalysis() {
        Main.analyzeDaysToMax(
            userRank, 
            rankTitles,
            userStanding);
    }


    ///////////////////////////


    public static void main() {
        getRank();
        getStanding();
        getAnalysis();
    }   
}