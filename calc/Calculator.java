package calc;
import data.Data;
import util.Utility;
import data.Data.Syndicates;
import data.Data.Rank;
import data.Data.Sacrifice;
import data.Data.Resource;

public class Calculator {

    private final String syndicateName;
    private final Rank[] rankRecord;
    private final Sacrifice[] sacrificeRecord;
    private final Resource[] resourceRecord;
    public Calculator(Syndicates syndicateName, Rank[] rankRecord, Sacrifice[] sacrificeRecord, Resource[] resourceRecord) {
        this.syndicateName = syndicateName.getSyndicate();
        this.rankRecord = rankRecord;
        this.sacrificeRecord = sacrificeRecord;
        this.resourceRecord = resourceRecord;
    }

    public void calculateSampleOutput() {
        // Testing method for data structure integrity.
        System.out.printf("Syndicate Name: %s\n\n", this.syndicateName);
        System.out.print("Rank Record:\n");
        for (Rank rankRecord : this.rankRecord) {
            System.out.printf("[%s] %s\n", rankRecord.rankNumber(), rankRecord.rankTitle());
        }
        System.out.print("\n");
        System.out.print("Sacrifice Record:\n");
        for (Sacrifice sacrificeRecord : this.sacrificeRecord) {
            for (int i = 0; i < sacrificeRecord.sacrificeName().length; i++) {
                System.out.printf("[%d] %s\n", sacrificeRecord.sacrificeAmount()[i], sacrificeRecord.sacrificeName()[i]);
            }
        }
        System.out.print("\n");
        System.out.print("Resource Record:\n");
        for (Resource resourceRecord : this.resourceRecord) {
            System.out.printf("[%d] %s\n", resourceRecord.resourceStanding(), resourceRecord.resourceName());
        }
        System.out.print("\n");
        Utility.inputBuffer();
    }

}