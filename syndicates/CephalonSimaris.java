package syndicates;
import Main;

public class CephalonSimaris {
    static String syndicateName = "Cephalon Simaris";
    static int userStanding = 0;
    static int maxStanding = 125000;


    //////////////////////////////////
    
    static void getStandingNeutral() {
        userStanding = Main.getStandingNeutral(
            syndicateName,
            maxStanding
        );
    }

    static void getAnalysisNeutral() {
        Main.getAnalysisNeutral(
            userStanding,
            maxStanding
        );
    }


    ///////////////////////////


    public static void main() {
        getStandingNeutral();
        getAnalysisNeutral();
    }   
}
