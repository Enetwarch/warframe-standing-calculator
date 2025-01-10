package data;
import calc.Calculator;

public class Data {

    public enum Syndicates {
        CONCLAVE("Conclave"),
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
        private final String syndicateName;
        private Syndicates(String syndicateName) {
            this.syndicateName = syndicateName;
        }
        public String getSyndicate() {
            return syndicateName;
        }
    }

    public record Rank(int rankNumber, String rankTitle) {} // Ranks
    public record Sacrifice(String[] sacrificeName, int[] sacrificeAmount) {} // Sacrifice resources
    public record Resource(String resourceName, int resourceStanding) {} // Standing resources


    ////// SYNDICATE DATA


    // Conclave
    private static final Syndicates conclaveSyndicateName = Syndicates.CONCLAVE;
    private static final Rank[] conclaveRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Mistral"),
        new Rank(2, "Whirlwind"),
        new Rank(3, "Tempest"),
        new Rank(4, "Hurricane"),
        new Rank(5, "Typhoon")
    };
    private static final Sacrifice[] conclaveSacrificeRecord = {
        new Sacrifice(new String[] {"Neurode", "Credit"}, new int[] {2, 30000}),
        new Sacrifice(new String[] {"Forma", "Credit"}, new int[] {1, 50000}),
        new Sacrifice(new String[] {"Orokin Reactor", "Credit"}, new int[] {1, 100000}),
        new Sacrifice(new String[] {"Orokin Catalyst", "Credit"}, new int[] {1, 250000}),
        new Sacrifice(new String[] {"Orokin Ducat", "Credit"}, new int[] {100, 500000})
    };
    private static final Resource[] conclaveResourceRecord = {}; // No resources for Conclave
    public static final Calculator conclave = new Calculator(conclaveSyndicateName, conclaveRankRecord, conclaveSacrificeRecord, conclaveResourceRecord);



    // Ostron
    private static final Syndicates ostronSyndicateName = Syndicates.OSTRON;
    private static final Rank[] ostronRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Offworlder"),
        new Rank(2, "Visitor"),
        new Rank(3, "Trusted"),
        new Rank(4, "Surah"),
        new Rank(5, "Kin")        
    };
    private static final Sacrifice[] ostronSacrificeRecord = {
        new Sacrifice(new String[] {"Nistlepod", "Iradite", "Grokdrul", "Credit"}, new int[] {25, 25, 25, 10000}),
        new Sacrifice(new String[] {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, new int[] {10, 40, 60, 25000}),
        new Sacrifice(new String[] {"Cetus Wisp", "Maprico", "Credit"}, new int[] {1, 5, 50000}),
        new Sacrifice(new String[] {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, new int[] {10, 40, 5, 100000}),
        new Sacrifice(new String[] {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}, new int[] {1, 1, 1, 1, 200000})
    };
    private static final Resource[] ostronResourceRecord = {
        new Resource("Azurite", 50),
        new Resource("Devar", 50),
        new Resource("Veridos", 75),
        new Resource("Crimzian", 100),
        new Resource("Sentirum", 400),
        new Resource("Nyth", 400)
    };
    public static final Calculator ostron = new Calculator(ostronSyndicateName, ostronRankRecord, ostronSacrificeRecord, ostronResourceRecord);



    // The Quills
    private static final Syndicates theQuillsSyndicateName = Syndicates.THE_QUILLS;
    private static final Rank[] theQuillsRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Offworlder"),
        new Rank(2, "Visitor"),
        new Rank(3, "Trusted"),
        new Rank(4, "Surah"),
        new Rank(5, "Kin")
    };
    private static final Sacrifice[] theQuillsSacrificeRecord = {
        new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {10, 30000}),
        new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {20, 50000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {10, 100000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {20, 250000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {30, 500000})
    };
    private static final Resource[] theQuillsResourceRecord = {
        new Resource("Intact Sentient Core", 250),
        new Resource("Exceptional Sentient Core", 750),
        new Resource("Flawless Sentient Core", 1500),
        new Resource("Narmer Isoplast", 2000)
    };
    public static final Calculator theQuills = new Calculator(theQuillsSyndicateName, theQuillsRankRecord, theQuillsSacrificeRecord, theQuillsResourceRecord);



    // Solaris United
    private static final Syndicates solarisUnitedSyndicateName = Syndicates.SOLARIS_UNITED;
    private static final Rank[] solarisUnitedRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Outworlder"),
        new Rank(2, "Rapscallion"),
        new Rank(3, "Doer"),
        new Rank(4, "Cove"),
        new Rank(5, "Old Mate")        
    };
    private static Sacrifice[] solarisUnitedSacrificeRecord = {
        new Sacrifice(new String[] {"Training Debt-Bond", "Credit"}, new int[] {2, 10000}),
        new Sacrifice(new String[] {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {3, 2, 25000}),
        new Sacrifice(new String[] {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {4, 3, 2, 50000}),
        new Sacrifice(new String[] {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"}, new int[] {5, 4, 3, 100000}),
        new Sacrifice(new String[] {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}, new int[] {5, 5, 3, 200000})
    };
    private static Resource[] solarisUnitedResourceRecord = {
        new Resource("Training Debt-Bond", 100),
        new Resource("Shelter Debt-Bond", 200),
        new Resource("Medical Debt-Bond", 300),
        new Resource("Advances Debt-Bond", 400),
        new Resource("Familial Debt-Bond", 500)
    };
    public static final Calculator solarisunited = new Calculator(solarisUnitedSyndicateName, solarisUnitedRankRecord, solarisUnitedSacrificeRecord, solarisUnitedResourceRecord);



    // Vox Solaris
    private static final Syndicates voxSolarisSyndicateName = Syndicates.VOX_SOLARIS;
    private static final Rank[] voxSolarisRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Operative"),
        new Rank(2, "Agent"),
        new Rank(3, "Hand"),
        new Rank(4, "Instrument"),
        new Rank(5, "Shadow")        
    };
    private static final Sacrifice[] voxSolarisSacrificeRecord = {
        new Sacrifice(new String[] {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"}, new int[] {1, 1, 1, 50000}),
        new Sacrifice(new String[] {"Gyromag System", "Vega Toroid", "Credit"}, new int[] {1, 1, 100000}),
        new Sacrifice(new String[] {"Atmo System", "Calda Toroid", "Credit"}, new int[] {1, 1, 250000}),
        new Sacrifice(new String[] {"Repeller System", "Sola Toroid", "Credit"}, new int[] {1, 1, 500000}),
        new Sacrifice(new String[] {"Crisma Toroid", "Credit"}, new int[] {1, 1000000})
    };
    private static final Resource[] voxSolarisResourceRecord = {
        new Resource("Vega Toroid", 1000),
        new Resource("Calda Toroid", 1000),
        new Resource("Sola Toroid", 1000),
        new Resource("Narmer Isoplast", 2000),
        new Resource("Crisma Toroid", 6000),
        new Resource("Lazulite Toroid", 12000)
    };
    public static final Calculator voxSolaris = new Calculator(voxSolarisSyndicateName, voxSolarisRankRecord, voxSolarisSacrificeRecord, voxSolarisResourceRecord);



    // Ventkids
    private static final Syndicates ventkidsSyndicateName = Syndicates.VENTKIDS;
    private static final Rank[] ventkidsRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Operative"),
        new Rank(2, "Agent"),
        new Rank(3, "Hand"),
        new Rank(4, "Instrument"),
        new Rank(5, "Shadow")        
    };
    private static final Sacrifice[] ventkidsSacrificeRecord = {}; // No sacrifices for Ventkids
    private static final Resource[] ventkidsResourceRecord = {}; // No resources for Ventkids
    public static final Calculator ventkids = new Calculator(ventkidsSyndicateName, ventkidsRankRecord, ventkidsSacrificeRecord, ventkidsResourceRecord);



    // Entrati
    private static final Syndicates entratiSyndicateName = Syndicates.ENTRATI;
    private static final Rank[] entratiRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Stranger"),
        new Rank(2, "Acquaintance"),
        new Rank(3, "Associate"),
        new Rank(4, "Friend"),
        new Rank(5, "Family")        
    };
    private static final Sacrifice[] entratiSacrificeRecord = {
        new Sacrifice(new String[] {"Spinal Core Section"}, new int[] {3}),
        new Sacrifice(new String[] {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"}, new int[] {5, 1, 1, 1}),
        new Sacrifice(new String[] {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Seriglass Shard", "Mother Token", "Father Token"}, new int[] {1, 1, 1})
    };
    private static final Resource[] entratiResourceRecord = {
        new Resource("Mother Token", 100),
        new Resource("Father Token", 100),
        new Resource("Daughter Token", 100),
        new Resource("Son Token", 500),
        new Resource("Otak Token", 100),
        new Resource("Grandmother Token", 1500)
    };
    public static final Calculator entrati = new Calculator(entratiSyndicateName, entratiRankRecord, entratiSacrificeRecord, entratiResourceRecord);



    // Necraloid
    private static final Syndicates necraloidSyndicateName = Syndicates.NECRALOID;
    private static final Rank[] necraloidRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Clearance: Agnesis"),
        new Rank(2, "Clearance: Modus"),
        new Rank(3, "Clearance: Odima")        
    };
    private static final Sacrifice[] necraloidSacrificeRecord = {
        new Sacrifice(new String[] {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"}, new int[] {10, 150, 1, 20}),
        new Sacrifice(new String[] {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"}, new int[] {15, 250, 1, 20}),
        new Sacrifice(new String[] {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}, new int[] {15, 350, 1, 20})
    };
    private static final Resource[] necraloidResourceRecord = {
        new Resource("Orokin Orientation Matrix", 1000),
        new Resource("Orokin Ballistics Matrix", 2500),
        new Resource("Orokin Animus Matrix", 5000)
    };
    public static final Calculator necraloid = new Calculator(necraloidSyndicateName, necraloidRankRecord, necraloidSacrificeRecord, necraloidResourceRecord);



    // The Holdfasts
    private static final Syndicates theHoldfastsSyndicateName = Syndicates.THE_HOLDFASTS;
    private static final Rank[] theHoldfastsRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Fallen"),
        new Rank(2, "Watcher"),
        new Rank(3, "Guardian"),
        new Rank(4, "Seraph"),
        new Rank(5, "Angel")        
    };
    private static final Sacrifice[] theHoldfastsSacrificeRecord = {
        new Sacrifice(new String[] {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, new int[] {5, 2000, 2000, 10000}),
        new Sacrifice(new String[] {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, new int[] {10, 10, 5000, 25000}),
        new Sacrifice(new String[] {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, new int[] {10, 10, 5000, 50000}),
        new Sacrifice(new String[] {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, new int[] {15, 60, 40, 100000}),
        new Sacrifice(new String[] {"Voidplume Pinion", "Thrax Plasm", "Entrati Lanthorn", "Credit"}, new int[] {5, 90, 20, 200000})
    };
    private static final Resource[] theHoldfastsResourceRecord = {
        new Resource("Voidplume Down", 500),
        new Resource("Voidplume Vane", 1000),
        new Resource("Voidplume Crest", 2000),
        new Resource("Voidplume Quill", 2500),
        new Resource("Voidplume Pinion", 5000)
    };
    public static final Calculator theHoldfasts = new Calculator(theHoldfastsSyndicateName, theHoldfastsRankRecord, theHoldfastsSacrificeRecord, theHoldfastsResourceRecord);



    // Cavia
    private static final Syndicates caviaSyndicateName = Syndicates.CAVIA;
    private static final Rank[] caviaRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Assistant"),
        new Rank(2, "Researcher"),
        new Rank(3, "Colleague"),
        new Rank(4, "Scholar"),
        new Rank(5, "Illuminate")        
    };
    private static final Sacrifice[] caviaSacrificeRecord = {
        new Sacrifice(new String[] {"Shrill Voca", "Entrati Obols", "Rubedo", "Credit"}, new int[] {3, 300, 11000, 10000}),
        new Sacrifice(new String[] {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"}, new int[] {5, 60, 12, 8, 25000}),
        new Sacrifice(new String[] {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"}, new int[] {2, 8, 15, 16, 50000}),
        new Sacrifice(new String[] {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"}, new int[] {1, 10, 1500, 5, 100000}),
        new Sacrifice(new String[] {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}, new int[] {10, 25, 10, 32, 200000})
    };
    private static final Resource[] caviaResourceRecord = {
        new Resource("Shrill Voca", 500),
        new Resource("Bellow Voca", 1000),
        new Resource("Echo Voca", 2000)
    };
    public static final Calculator cavia = new Calculator(caviaSyndicateName, caviaRankRecord, caviaSacrificeRecord, caviaResourceRecord);



    // The Hex
    private static final Syndicates theHexSyndicateName = Syndicates.THE_HEX;
    private static final Rank[] theHexRankRecord = {
        new Rank(0, "Neutral"),
        new Rank(1, "Leftovers"),
        new Rank(2, "Fresh Slice"),
        new Rank(3, "2-For-1"),
        new Rank(4, "Hot & Fresh"),
        new Rank(5, "Pizza Party")        
    };
    private static final Sacrifice[] theHexSacrificeRecord = {
        new Sacrifice(new String[] {"Efervon Sample", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {15, 5, 10000}),
        new Sacrifice(new String[] {"Experimental Arc-Relay", "Entrati Obol", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {5, 12, 25, 25000}),
        new Sacrifice(new String[] {"The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {1, 1, 1, 1, 1, 1, 50000}),
        new Sacrifice(new String[] {"Techrot Chitin", "Necracoil", "Efervon Sample", "Hollar"}, new int[] {25, 25, 40, 100000}),
        new Sacrifice(new String[] {"Techrot Motherboard", "The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {5, 1, 1, 1, 1, 1, 1, 200000})
    };
    private static final Resource[] theHexResourceRecord = {
        new Resource("The Countessa Comic", 750),
        new Resource("On-lyne CD", 750),
        new Resource("Chuggin' Along Sixpack", 750),
        new Resource("Mood Crystal", 750),
        new Resource("Cheddar Crowns Cereal", 750),
        new Resource("35mm Film", 750),
        new Resource("Argon Burger Meal", 1500),
        new Resource("Big Bytes Pizza", 2500)
    };
    public static final Calculator theHex = new Calculator(theHexSyndicateName, theHexRankRecord, theHexSacrificeRecord, theHexResourceRecord);

}