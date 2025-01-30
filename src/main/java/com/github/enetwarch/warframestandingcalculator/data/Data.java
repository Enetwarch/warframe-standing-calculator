package com.github.enetwarch.warframestandingcalculator.data;

public class Data {

    private String syndicateName;
    private Rank[] rankRecord;
    private Sacrifice[] sacrificeRecord;
    private Resource[] resourceRecord;

    public Data(String syndicateName, Rank[] rankRecord, Sacrifice[] sacrificeRecord, Resource[] resourceRecord) {
        this.syndicateName = syndicateName;
        this.rankRecord = rankRecord;
        this.sacrificeRecord = sacrificeRecord;
        this.resourceRecord = resourceRecord;
    }

    public String getSyndicateName() {
        return syndicateName;
    }

    public Rank[] getRankRecord() {
        return rankRecord;
    }

    public Sacrifice[] getSacrificeRecord() {
        return sacrificeRecord;
    }

    public Resource[] getResourceRecord() {
        return resourceRecord;
    }

    private static final String CONCLAVE_SYNDICATE_NAME = Syndicate.CONCLAVE.getSyndicate();
    private static final Rank[] CONCLAVE_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Mistral"),
        new Rank(2, "Whirlwind"),
        new Rank(3, "Tempest"),
        new Rank(4, "Hurricane"),
        new Rank(5, "Typhoon")
    };
    private static final Sacrifice[] CONCLAVE_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Neurode", "Credit"}, new int[] {2, 30000}),
        new Sacrifice(new String[] {"Forma", "Credit"}, new int[] {1, 50000}),
        new Sacrifice(new String[] {"Orokin Reactor", "Credit"}, new int[] {1, 100000}),
        new Sacrifice(new String[] {"Orokin Catalyst", "Credit"}, new int[] {1, 250000}),
        new Sacrifice(new String[] {"Orokin Ducat", "Credit"}, new int[] {100, 500000})
    };
    private static final Resource[] CONCLAVE_RESOURCE_RECORD = {
        // No resources for Conclave
    };

    private static final String OSTRON_SYNDICATE_NAME = Syndicate.OSTRON.getSyndicate();
    private static final Rank[] OSTRON_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Offworlder"),
        new Rank(2, "Visitor"),
        new Rank(3, "Trusted"),
        new Rank(4, "Surah"),
        new Rank(5, "Kin")
    };
    private static final Sacrifice[] OSTRON_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Nistlepod", "Iradite", "Grokdrul", "Credit"}, new int[] {25, 25, 25, 10000}),
        new Sacrifice(new String[] {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, new int[] {10, 40, 60, 25000}),
        new Sacrifice(new String[] {"Cetus Wisp", "Maprico", "Credit"}, new int[] {1, 5, 50000}),
        new Sacrifice(new String[] {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, new int[] {10, 40, 5, 100000}),
        new Sacrifice(new String[] {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}, new int[] {1, 1, 1, 1, 200000})
    };
    private static final Resource[] OSTRON_RESOURCE_RECORD = {
        new Resource("Azurite", 50),
        new Resource("Devar", 50),
        new Resource("Veridos", 75),
        new Resource("Crimzian", 100),
        new Resource("Sentirum", 400),
        new Resource("Nyth", 400)
    };

    private static final String THE_QUILLS_SYNDICATE_NAME = Syndicate.THE_QUILLS.getSyndicate();
    private static final Rank[] THE_QUILLS_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Offworlder"),
        new Rank(2, "Visitor"),
        new Rank(3, "Trusted"),
        new Rank(4, "Surah"),
        new Rank(5, "Kin")
    };
    private static final Sacrifice[] THE_QUILLS_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {10, 30000}),
        new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {20, 50000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {10, 100000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {20, 250000}),
        new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {30, 500000})
    };
    private static final Resource[] THE_QUILLS_RESOURCE_RECORD = {
        new Resource("Intact Sentient Core", 250),
        new Resource("Exceptional Sentient Core", 750),
        new Resource("Flawless Sentient Core", 1500),
        new Resource("Narmer Isoplast", 2000)
    };

    private static final String SOLARIS_UNITED_SYNDICATE_NAME = Syndicate.SOLARIS_UNITED.getSyndicate();
    private static final Rank[] SOLARIS_UNITED_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Outworlder"),
        new Rank(2, "Rapscallion"),
        new Rank(3, "Doer"),
        new Rank(4, "Cove"),
        new Rank(5, "Old Mate")
    };
    private static final Sacrifice[] SOLARIS_UNITED_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Training Debt-Bond", "Credit"}, new int[] {2, 10000}),
        new Sacrifice(new String[] {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {3, 2, 25000}),
        new Sacrifice(new String[] {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {4, 3, 2, 50000}),
        new Sacrifice(new String[] {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"}, new int[] {5, 4, 3, 100000}),
        new Sacrifice(new String[] {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}, new int[] {5, 5, 3, 200000})
    };
    private static final Resource[] SOLARIS_UNITED_RESOURCE_RECORD = {
        new Resource("Training Debt-Bond", 100),
        new Resource("Shelter Debt-Bond", 200),
        new Resource("Medical Debt-Bond", 300),
        new Resource("Advances Debt-Bond", 400),
        new Resource("Familial Debt-Bond", 500)
    };

    private static final String VOX_SOLARIS_SYNDICATE_NAME = Syndicate.VOX_SOLARIS.getSyndicate();
    private static final Rank[] VOX_SOLARIS_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Operative"),
        new Rank(2, "Agent"),
        new Rank(3, "Hand"),
        new Rank(4, "Instrument"),
        new Rank(5, "Shadow")
    };
    private static final Sacrifice[] VOX_SOLARIS_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"}, new int[] {1, 1, 1, 50000}),
        new Sacrifice(new String[] {"Gyromag System", "Vega Toroid", "Credit"}, new int[] {1, 1, 100000}),
        new Sacrifice(new String[] {"Atmo System", "Calda Toroid", "Credit"}, new int[] {1, 1, 250000}),
        new Sacrifice(new String[] {"Repeller System", "Sola Toroid", "Credit"}, new int[] {1, 1, 500000}),
        new Sacrifice(new String[] {"Crisma Toroid", "Credit"}, new int[] {1, 1000000})
    };
    private static final Resource[] VOX_SOLARIS_RESOURCE_RECORD = {
        new Resource("Vega Toroid", 1000),
        new Resource("Calda Toroid", 1000),
        new Resource("Sola Toroid", 1000),
        new Resource("Narmer Isoplast", 2000),
        new Resource("Crisma Toroid", 6000),
        new Resource("Lazulite Toroid", 12000)
    };

    private static final String VENTKIDS_SYNDICATE_NAME = Syndicate.VENTKIDS.getSyndicate();
    private static final Rank[] VENTKIDS_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Operative"),
        new Rank(2, "Agent"),
        new Rank(3, "Hand"),
        new Rank(4, "Instrument"),
        new Rank(5, "Shadow")
    };
    private static final Sacrifice[] VENTKIDS_SACRIFICE_RECORD = {
        // No sacrifices for Ventkids
    };
    private static final Resource[] VENTKIDS_RESOURCE_RECORD = {
        // No resources for Ventkids
    };

    private static final String ENTRATI_SYNDICATE_NAME = Syndicate.ENTRATI.getSyndicate();
    private static final Rank[] ENTRATI_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Stranger"),
        new Rank(2, "Acquaintance"),
        new Rank(3, "Associate"),
        new Rank(4, "Friend"),
        new Rank(5, "Family")
    };
    private static final Sacrifice[] ENTRATI_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Spinal Core Section"}, new int[] {3}),
        new Sacrifice(new String[] {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"}, new int[] {5, 1, 1, 1}),
        new Sacrifice(new String[] {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Seriglass Shard", "Mother Token", "Father Token"}, new int[] {1, 1, 1})
    };
    private static final Resource[] ENTRATI_RESOURCE_RECORD = {
        new Resource("Mother Token", 100),
        new Resource("Father Token", 100),
        new Resource("Daughter Token", 100),
        new Resource("Son Token", 500),
        new Resource("Otak Token", 100),
        new Resource("Grandmother Token", 1500)
    };

    private static final String NECRALOID_SYNDICATE_NAME = Syndicate.NECRALOID.getSyndicate();
    private static final Rank[] NECRALOID_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Clearance: Agnesis"),
        new Rank(2, "Clearance: Modus"),
        new Rank(3, "Clearance: Odima")
    };
    private static final Sacrifice[] NECRALOID_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"}, new int[] {10, 150, 1, 20}),
        new Sacrifice(new String[] {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"}, new int[] {15, 250, 1, 20}),
        new Sacrifice(new String[] {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}, new int[] {15, 350, 1, 20})
    };
    private static final Resource[] NECRALOID_RESOURCE_RECORD = {
        new Resource("Orokin Orientation Matrix", 1000),
        new Resource("Orokin Ballistics Matrix", 2500),
        new Resource("Orokin Animus Matrix", 5000)
    };

    private static final String THE_HOLDFASTS_SYNDICATE_NAME = Syndicate.THE_HOLDFASTS.getSyndicate();
    private static final Rank[] THE_HOLDFASTS_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Fallen"),
        new Rank(2, "Watcher"),
        new Rank(3, "Guardian"),
        new Rank(4, "Seraph"),
        new Rank(5, "Angel")
    };
    private static final Sacrifice[] THE_HOLDFASTS_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, new int[] {5, 2000, 2000, 10000}),
        new Sacrifice(new String[] {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, new int[] {10, 10, 5000, 25000}),
        new Sacrifice(new String[] {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, new int[] {10, 10, 5000, 50000}),
        new Sacrifice(new String[] {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, new int[] {15, 60, 40, 100000}),
        new Sacrifice(new String[] {"Voidplume Pinion", "Thrax Plasm", "Entrati Lanthorn", "Credit"}, new int[] {5, 90, 20, 200000})
    };
    private static final Resource[] THE_HOLDFASTS_RESOURCE_RECORD = {
        new Resource("Voidplume Down", 500),
        new Resource("Voidplume Vane", 1000),
        new Resource("Voidplume Crest", 2000),
        new Resource("Voidplume Quill", 2500),
        new Resource("Voidplume Pinion", 5000)
    };

    private static final String CAVIA_SYNDICATE_NAME = Syndicate.CAVIA.getSyndicate();
    private static final Rank[] CAVIA_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Assistant"),
        new Rank(2, "Researcher"),
        new Rank(3, "Colleague"),
        new Rank(4, "Scholar"),
        new Rank(5, "Illuminate")
    };
    private static final Sacrifice[] CAVIA_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Shrill Voca", "Entrati Obol", "Rubedo", "Credit"}, new int[] {3, 300, 11000, 10000}),
        new Sacrifice(new String[] {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"}, new int[] {5, 60, 12, 8, 25000}),
        new Sacrifice(new String[] {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"}, new int[] {2, 8, 15, 16, 50000}),
        new Sacrifice(new String[] {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"}, new int[] {1, 10, 1500, 5, 100000}),
        new Sacrifice(new String[] {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}, new int[] {10, 25, 10, 32, 200000})
    };
    private static final Resource[] CAVIA_RESOURCE_RECORD = {
        new Resource("Shrill Voca", 500),
        new Resource("Bellow Voca", 1000),
        new Resource("Echo Voca", 2000)
    };

    private static final String THE_HEX_SYNDICATE_NAME = Syndicate.THE_HEX.getSyndicate();
    private static final Rank[] THE_HEX_RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Leftovers"),
        new Rank(2, "Fresh Slice"),
        new Rank(3, "2-For-1"),
        new Rank(4, "Hot & Fresh"),
        new Rank(5, "Pizza Party")
    };
    private static final Sacrifice[] THE_HEX_SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Efervon Sample", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {15, 5, 10000}),
        new Sacrifice(new String[] {"Experimental Arc-Relay", "Entrati Obol", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {5, 12, 25, 25000}),
        new Sacrifice(new String[] {"The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {1, 1, 1, 1, 1, 1, 50000}),
        new Sacrifice(new String[] {"Techrot Chitin", "Necracoil", "Efervon Sample", "Hollar"}, new int[] {25, 25, 40, 100000}),
        new Sacrifice(new String[] {"Techrot Motherboard", "The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {5, 1, 1, 1, 1, 1, 1, 200000})
    };
    private static final Resource[] THE_HEX_RESOURCE_RECORD = {
        new Resource("The Countessa Comic", 750),
        new Resource("On-lyne CD", 750),
        new Resource("Chuggin' Along Sixpack", 750),
        new Resource("Mood Crystal", 750),
        new Resource("Cheddar Crowns Cereal", 750),
        new Resource("35mm Film", 750),
        new Resource("Argon Burger Meal", 1500),
        new Resource("Big Bytes Pizza", 2500)
    };

    public static final Data conclaveData = new Data(CONCLAVE_SYNDICATE_NAME, CONCLAVE_RANK_RECORD, CONCLAVE_SACRIFICE_RECORD, CONCLAVE_RESOURCE_RECORD);
    public static final Data ostronData = new Data(OSTRON_SYNDICATE_NAME, OSTRON_RANK_RECORD, OSTRON_SACRIFICE_RECORD, OSTRON_RESOURCE_RECORD);
    public static final Data theQuillsData = new Data(THE_QUILLS_SYNDICATE_NAME, THE_QUILLS_RANK_RECORD, THE_QUILLS_SACRIFICE_RECORD, THE_QUILLS_RESOURCE_RECORD);
    public static final Data solarisUnitedData = new Data(SOLARIS_UNITED_SYNDICATE_NAME, SOLARIS_UNITED_RANK_RECORD, SOLARIS_UNITED_SACRIFICE_RECORD, SOLARIS_UNITED_RESOURCE_RECORD);
    public static final Data voxSolarisData = new Data(VOX_SOLARIS_SYNDICATE_NAME, VOX_SOLARIS_RANK_RECORD, VOX_SOLARIS_SACRIFICE_RECORD, VOX_SOLARIS_RESOURCE_RECORD);
    public static final Data ventkidsData = new Data(VENTKIDS_SYNDICATE_NAME, VENTKIDS_RANK_RECORD, VENTKIDS_SACRIFICE_RECORD, VENTKIDS_RESOURCE_RECORD);
    public static final Data entratiData = new Data(ENTRATI_SYNDICATE_NAME, ENTRATI_RANK_RECORD, ENTRATI_SACRIFICE_RECORD, ENTRATI_RESOURCE_RECORD);
    public static final Data necraloidData = new Data(NECRALOID_SYNDICATE_NAME, NECRALOID_RANK_RECORD, NECRALOID_SACRIFICE_RECORD, NECRALOID_RESOURCE_RECORD);
    public static final Data theHoldfastsData = new Data(THE_HOLDFASTS_SYNDICATE_NAME, THE_HOLDFASTS_RANK_RECORD, THE_HOLDFASTS_SACRIFICE_RECORD, THE_HOLDFASTS_RESOURCE_RECORD);
    public static final Data caviaData = new Data(CAVIA_SYNDICATE_NAME, CAVIA_RANK_RECORD, CAVIA_SACRIFICE_RECORD, CAVIA_RESOURCE_RECORD);
    public static final Data theHexData = new Data(THE_HEX_SYNDICATE_NAME, THE_HEX_RANK_RECORD, THE_HEX_SACRIFICE_RECORD, THE_HEX_RESOURCE_RECORD);

}