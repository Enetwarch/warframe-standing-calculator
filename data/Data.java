package data;
public class Data {
    public enum Syndicates {
        FACTION_SYNDICATES("Faction Syndicates"),
        STEEL_MERIDIAN("Steel Meridian"),
        ARBITERS_OF_HEXIS("Arbiters of Hexis"),
        CEPHALON_SUDA("Cephalon Suda"),
        THE_PERRIN_SEQUENCE("The Perrin Sequence"),
        RED_VEIL("Red Veil"),
        NEW_LOKA("New Loka"),
        CONCLAVE("Conclave"),
        CEPHALON_SIMARIS("Cephalon Simaris"),
        OSTRON("Ostron"),
        THE_QUILLS("The Quills"),
        SOLARIS_UNITED("Solaris United"),
        VOX_SOLARIS("Vox Solaris"),
        VENTKIDS("Ventkids"),
        ENTRATI("Entrati"),
        NECRALOID("Necraloid"),
        THE_HOLDFASTS("The Holdfasts"),
        CAVIA("Cavia"),
        THE_HEX("The Hex");
        // All syndicate names set to constant for type safety reasons.
        private final String syndicateName; // Initializes all these enum variables as syndicateName variable.
        private Syndicates(String syndicateName) {
            // Constructor for this enum.
            this.syndicateName = syndicateName;
        }
        public String getSyndicate() {
            // Returner method to return the syndicate
            return syndicateName;
        }
    }

}