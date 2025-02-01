package com.github.enetwarch.warframestandingcalculator.data;

public class Data {

    private String syndicateName;
    private Rank[] rankRecords;
    private Sacrifice[] sacrificeRecords;
    private Resource[] resourceRecords;

    public Data(String syndicateName, Rank[] rankRecords, Sacrifice[] sacrificeRecords, Resource[] resourceRecords) {
        this.syndicateName = syndicateName;
        this.rankRecords = rankRecords;
        this.sacrificeRecords = sacrificeRecords;
        this.resourceRecords = resourceRecords;
    }

    public String getSyndicateName() {
        return syndicateName;
    }

    public Rank[] getRankRecord() {
        return rankRecords;
    }

    public Sacrifice[] getSacrificeRecord() {
        return sacrificeRecords;
    }

    public Resource[] getResourceRecord() {
        return resourceRecords;
    }

    public static Data getConclaveData() {
        String conclaveSyndicateName = getConclaveSyndicateName();
        Rank[] conclaveRankRecords = getConclaveRankRecords();
        Sacrifice[] conclaveSacrificeRecords = getConclaveSacrificeRecords();
        Resource[] conclaveResourceRecords = getConclaveResourceRecords();
        return new Data(conclaveSyndicateName, conclaveRankRecords, conclaveSacrificeRecords, conclaveResourceRecords);
    }

    public static Data getOstronData() {
        String ostronSyndicateName = getOstronSyndicateName();
        Rank[] ostronRankRecords = getOstronRankRecords();
        Sacrifice[] ostronSacrificeRecords = getOstronSacrificeRecords();
        Resource[] ostronResourceRecords = getOstronResourceRecords();
        return new Data(ostronSyndicateName, ostronRankRecords, ostronSacrificeRecords, ostronResourceRecords);
    }

    public static Data getTheQuillsData() {
        String theQuillsSyndicateName = getTheQuillsSyndicateName();
        Rank[] theQuillsRankRecords = getTheQuillsRankRecords();
        Sacrifice[] theQuillsSacrificeRecords = getTheQuillsSacrificeRecords();
        Resource[] theQuillsResourceRecords = getTheQuillsResourceRecords();
        return new Data(theQuillsSyndicateName, theQuillsRankRecords, theQuillsSacrificeRecords, theQuillsResourceRecords);
    }

    public static Data getSolarisUnitedData() {
        String solarisUnitedSyndicateName = getSolarisUnitedSyndicateName();
        Rank[] solarisUnitedRankRecords = getSolarisUnitedRankRecords();
        Sacrifice[] solarisUnitedSacrificeRecords = getSolarisUnitedSacrificeRecords();
        Resource[] solarisUnitedResourceRecords = getSolarisUnitedResourceRecords();
        return new Data(solarisUnitedSyndicateName, solarisUnitedRankRecords, solarisUnitedSacrificeRecords, solarisUnitedResourceRecords);
    }

    public static Data getVoxSolarisData() {
        String voxSolarisSyndicateName = getVoxSolarisSyndicateName();
        Rank[] voxSolarisRankRecords = getVoxSolarisRankRecords();
        Sacrifice[] voxSolarisSacrificeRecords = getVoxSolarisSacrificeRecords();
        Resource[] voxSolarisResourceRecords = getVoxSolarisResourceRecords();
        return new Data(voxSolarisSyndicateName, voxSolarisRankRecords, voxSolarisSacrificeRecords, voxSolarisResourceRecords);
    }

    public static Data getVentkidsData() {
        String ventkidsSyndicateName = getVentkidsSyndicateName();
        Rank[] ventkidsRankRecords = getVentkidsRankRecords();
        Sacrifice[] ventkidsSacrificeRecords = getVentkidsSacrificeRecords();
        Resource[] ventkidsResourceRecords = getVentkidsResourceRecords();
        return new Data(ventkidsSyndicateName, ventkidsRankRecords, ventkidsSacrificeRecords, ventkidsResourceRecords);
    }

    public static Data getEntratiData() {
        String entratiSyndicateName = getEntratiSyndicateName();
        Rank[] entratiRankRecords = getEntratiRankRecords();
        Sacrifice[] entratiSacrificeRecords = getEntratiSacrificeRecords();
        Resource[] entratiResourceRecords = getEntratiResourceRecords();
        return new Data(entratiSyndicateName, entratiRankRecords, entratiSacrificeRecords, entratiResourceRecords);
    }

    public static Data getNecraloidData() {
        String necraloidSyndicateName = getNecraloidSyndicateName();
        Rank[] necraloidRankRecords = getNecraloidRankRecords();
        Sacrifice[] necraloidSacrificeRecords = getNecraloidSacrificeRecords();
        Resource[] necraloidResourceRecords = getNecraloidResourceRecords();
        return new Data(necraloidSyndicateName, necraloidRankRecords, necraloidSacrificeRecords, necraloidResourceRecords);
    }

    public static Data getTheHoldfastsData() {
        String theHoldfastsSyndicateName = getTheHoldfastsSyndicateName();
        Rank[] theHoldfastsRankRecords = getTheHoldfastsRankRecords();
        Sacrifice[] theHoldfastsSacrificeRecords = getTheHoldfastsSacrificeRecords();
        Resource[] theHoldfastsResourceRecords = getTheHoldfastsResourceRecords();
        return new Data(theHoldfastsSyndicateName, theHoldfastsRankRecords, theHoldfastsSacrificeRecords, theHoldfastsResourceRecords);
    }

    public static Data getCaviaData() {
        String caviaSyndicateName = getCaviaSyndicateName();
        Rank[] caviaRankRecords = getCaviaRankRecords();
        Sacrifice[] caviaSacrificeRecords = getCaviaSacrificeRecords();
        Resource[] caviaResourceRecords = getCaviaResourceRecords();
        return new Data(caviaSyndicateName, caviaRankRecords, caviaSacrificeRecords, caviaResourceRecords);
    }

    public static Data getTheHexData() {
        String theHexSyndicateName = getTheHexSyndicateName();
        Rank[] theHexRankRecords = getTheHexRankRecords();
        Sacrifice[] theHexSacrificeRecords = getTheHexSacrificeRecords();
        Resource[] theHexResourceRecords = getTheHexResourceRecords();
        return new Data(theHexSyndicateName, theHexRankRecords, theHexSacrificeRecords, theHexResourceRecords);
    }

    private static String getConclaveSyndicateName() {
        return Syndicate.CONCLAVE.getSyndicate();
    }

    private static Rank[] getConclaveRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Mistral"),
            new Rank(2, "Whirlwind"),
            new Rank(3, "Tempest"),
            new Rank(4, "Hurricane"),
            new Rank(5, "Typhoon")
        };
    }

    private static Sacrifice[] getConclaveSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Neurode", "Credit"}, new int[] {2, 30000}),
            new Sacrifice(new String[] {"Forma", "Credit"}, new int[] {1, 50000}),
            new Sacrifice(new String[] {"Orokin Reactor", "Credit"}, new int[] {1, 100000}),
            new Sacrifice(new String[] {"Orokin Catalyst", "Credit"}, new int[] {1, 250000}),
            new Sacrifice(new String[] {"Orokin Ducat", "Credit"}, new int[] {100, 500000})
        };
    }

    private static Resource[] getConclaveResourceRecords() {
        return new Resource[] {
            // No resources for Conclave
        };
    }

    private static String getOstronSyndicateName() {
        return Syndicate.OSTRON.getSyndicate();
    }

    private static Rank[] getOstronRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Offworlder"),
            new Rank(2, "Visitor"),
            new Rank(3, "Trusted"),
            new Rank(4, "Surah"),
            new Rank(5, "Kin")
        };
    }

    private static Sacrifice[] getOstronSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Nistlepod", "Iradite", "Grokdrul", "Credit"}, new int[] {25, 25, 25, 10000}),
            new Sacrifice(new String[] {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, new int[] {10, 40, 60, 25000}),
            new Sacrifice(new String[] {"Cetus Wisp", "Maprico", "Credit"}, new int[] {1, 5, 50000}),
            new Sacrifice(new String[] {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, new int[] {10, 40, 5, 100000}),
            new Sacrifice(new String[] {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}, new int[] {1, 1, 1, 1, 200000})
        };
    }

    private static Resource[] getOstronResourceRecords() {
        return new Resource[] {
            new Resource("Azurite", 50),
            new Resource("Devar", 50),
            new Resource("Veridos", 75),
            new Resource("Crimzian", 100),
            new Resource("Sentirum", 400),
            new Resource("Nyth", 400)
        };
    }

    private static String getTheQuillsSyndicateName() {
        return Syndicate.THE_QUILLS.getSyndicate();
    }

    private static Rank[] getTheQuillsRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Offworlder"),
            new Rank(2, "Visitor"),
            new Rank(3, "Trusted"),
            new Rank(4, "Surah"),
            new Rank(5, "Kin")
        };
    }

    private static Sacrifice[] getTheQuillsSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {10, 30000}),
            new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {20, 50000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {10, 100000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {20, 250000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {30, 500000})
        };
    }

    private static Resource[] getTheQuillsResourceRecords() {
        return new Resource[] {
            new Resource("Intact Sentient Core", 250),
            new Resource("Exceptional Sentient Core", 750),
            new Resource("Flawless Sentient Core", 1500),
            new Resource("Narmer Isoplast", 2000)
        };
    }

    private static String getSolarisUnitedSyndicateName() {
        return Syndicate.SOLARIS_UNITED.getSyndicate();
    }

    private static Rank[] getSolarisUnitedRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Outworlder"),
            new Rank(2, "Rapscallion"),
            new Rank(3, "Doer"),
            new Rank(4, "Cove"),
            new Rank(5, "Old Mate")
        };
    }

    private static Sacrifice[] getSolarisUnitedSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Training Debt-Bond", "Credit"}, new int[] {2, 10000}),
            new Sacrifice(new String[] {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {3, 2, 25000}),
            new Sacrifice(new String[] {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {4, 3, 2, 50000}),
            new Sacrifice(new String[] {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"}, new int[] {5, 4, 3, 100000}),
            new Sacrifice(new String[] {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}, new int[] {5, 5, 3, 200000})
        };
    }

    private static Resource[] getSolarisUnitedResourceRecords() {
        return new Resource[] {
            new Resource("Training Debt-Bond", 100),
            new Resource("Shelter Debt-Bond", 200),
            new Resource("Medical Debt-Bond", 300),
            new Resource("Advances Debt-Bond", 400),
            new Resource("Familial Debt-Bond", 500)
        };
    }

    private static String getVoxSolarisSyndicateName() {
        return Syndicate.VOX_SOLARIS.getSyndicate();
    }

    private static Rank[] getVoxSolarisRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Operative"),
            new Rank(2, "Agent"),
            new Rank(3, "Hand"),
            new Rank(4, "Instrument"),
            new Rank(5, "Shadow")
        };
    }

    private static Sacrifice[] getVoxSolarisSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"}, new int[] {1, 1, 1, 50000}),
            new Sacrifice(new String[] {"Gyromag System", "Vega Toroid", "Credit"}, new int[] {1, 1, 100000}),
            new Sacrifice(new String[] {"Atmo System", "Calda Toroid", "Credit"}, new int[] {1, 1, 250000}),
            new Sacrifice(new String[] {"Repeller System", "Sola Toroid", "Credit"}, new int[] {1, 1, 500000}),
            new Sacrifice(new String[] {"Crisma Toroid", "Credit"}, new int[] {1, 1000000})
        };
    }

    private static Resource[] getVoxSolarisResourceRecords() {
        return new Resource[] {
            new Resource("Vega Toroid", 1000),
            new Resource("Calda Toroid", 1000),
            new Resource("Sola Toroid", 1000),
            new Resource("Narmer Isoplast", 2000),
            new Resource("Crisma Toroid", 6000),
            new Resource("Lazulite Toroid", 12000)
        };
    }

    private static String getVentkidsSyndicateName() {
        return Syndicate.VENTKIDS.getSyndicate();
    }

    private static Rank[] getVentkidsRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Operative"),
            new Rank(2, "Agent"),
            new Rank(3, "Hand"),
            new Rank(4, "Instrument"),
            new Rank(5, "Shadow")
        };
    }

    private static Sacrifice[] getVentkidsSacrificeRecords() {
        return new Sacrifice[] {
            // No sacrifices for Ventkids
        };
    }

    private static Resource[] getVentkidsResourceRecords() {
        return new Resource[] {
            // No resources for Ventkids
        };
    }

    private static String getEntratiSyndicateName() {
        return Syndicate.ENTRATI.getSyndicate();
    }

    private static Rank[] getEntratiRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Stranger"),
            new Rank(2, "Acquaintance"),
            new Rank(3, "Associate"),
            new Rank(4, "Friend"),
            new Rank(5, "Family")
        };
    }

    private static Sacrifice[] getEntratiSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Spinal Core Section"}, new int[] {3}),
            new Sacrifice(new String[] {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"}, new int[] {1, 1, 1, 1}),
            new Sacrifice(new String[] {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"}, new int[] {5, 1, 1, 1}),
            new Sacrifice(new String[] {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"}, new int[] {1, 1, 1, 1}),
            new Sacrifice(new String[] {"Seriglass Shard", "Mother Token", "Father Token"}, new int[] {1, 1, 1})
        };
    }

    private static Resource[] getEntratiResourceRecords() {
        return new Resource[] {
            new Resource("Mother Token", 100),
            new Resource("Father Token", 100),
            new Resource("Daughter Token", 100),
            new Resource("Son Token", 500),
            new Resource("Otak Token", 100),
            new Resource("Grandmother Token", 1500)
        };
    }

    private static String getNecraloidSyndicateName() {
        return Syndicate.NECRALOID.getSyndicate();
    }

    private static Rank[] getNecraloidRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Clearance: Agnesis"),
            new Rank(2, "Clearance: Modus"),
            new Rank(3, "Clearance: Odima")
        };
    }

    private static Sacrifice[] getNecraloidSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"}, new int[] {10, 150, 1, 20}),
            new Sacrifice(new String[] {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"}, new int[] {15, 250, 1, 20}),
            new Sacrifice(new String[] {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}, new int[] {15, 350, 1, 20})
        };
    }

    private static Resource[] getNecraloidResourceRecords() {
        return new Resource[] {
            new Resource("Orokin Orientation Matrix", 1000),
            new Resource("Orokin Ballistics Matrix", 2500),
            new Resource("Orokin Animus Matrix", 5000)
        };
    }

    private static String getTheHoldfastsSyndicateName() {
        return Syndicate.THE_HOLDFASTS.getSyndicate();
    }

    private static Rank[] getTheHoldfastsRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Fallen"),
            new Rank(2, "Watcher"),
            new Rank(3, "Guardian"),
            new Rank(4, "Seraph"),
            new Rank(5, "Angel")
        };
    }

    private static Sacrifice[] getTheHoldfastsSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, new int[] {5, 2000, 2000, 10000}),
            new Sacrifice(new String[] {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, new int[] {10, 10, 5000, 25000}),
            new Sacrifice(new String[] {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, new int[] {10, 10, 5000, 50000}),
            new Sacrifice(new String[] {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, new int[] {15, 60, 40, 100000}),
            new Sacrifice(new String[] {"Voidplume Pinion", "Thrax Plasm", "Entrati Lanthorn", "Credit"}, new int[] {5, 90, 20, 200000})
        };
    }

    private static Resource[] getTheHoldfastsResourceRecords() {
        return new Resource[] {
            new Resource("Voidplume Down", 500),
            new Resource("Voidplume Vane", 1000),
            new Resource("Voidplume Crest", 2000),
            new Resource("Voidplume Quill", 2500),
            new Resource("Voidplume Pinion", 5000)
        };
    }

    private static String getCaviaSyndicateName() {
        return Syndicate.CAVIA.getSyndicate();
    }

    private static Rank[] getCaviaRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Assistant"),
            new Rank(2, "Researcher"),
            new Rank(3, "Colleague"),
            new Rank(4, "Scholar"),
            new Rank(5, "Illuminate")
        };
    }

    private static Sacrifice[] getCaviaSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Shrill Voca", "Entrati Obol", "Rubedo", "Credit"}, new int[] {3, 300, 11000, 10000}),
            new Sacrifice(new String[] {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"}, new int[] {5, 60, 12, 8, 25000}),
            new Sacrifice(new String[] {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"}, new int[] {2, 8, 15, 16, 50000}),
            new Sacrifice(new String[] {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"}, new int[] {1, 10, 1500, 5, 100000}),
            new Sacrifice(new String[] {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}, new int[] {10, 25, 10, 32, 200000})
        };
    }

    private static Resource[] getCaviaResourceRecords() {
        return new Resource[] {
            new Resource("Shrill Voca", 500),
            new Resource("Bellow Voca", 1000),
            new Resource("Echo Voca", 2000)
        };
    }


    private static String getTheHexSyndicateName() {
        return Syndicate.THE_HEX.getSyndicate();
    }

    private static Rank[] getTheHexRankRecords() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Leftovers"),
            new Rank(2, "Fresh Slice"),
            new Rank(3, "2-For-1"),
            new Rank(4, "Hot & Fresh"),
            new Rank(5, "Pizza Party")
        };
    }

    private static Sacrifice[] getTheHexSacrificeRecords() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Efervon Sample", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {15, 5, 10000}),
            new Sacrifice(new String[] {"Experimental Arc-Relay", "Entrati Obol", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {5, 12, 25, 25000}),
            new Sacrifice(new String[] {"The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {1, 1, 1, 1, 1, 1, 50000}),
            new Sacrifice(new String[] {"Techrot Chitin", "Necracoil", "Efervon Sample", "Hollar"}, new int[] {25, 25, 40, 100000}),
            new Sacrifice(new String[] {"Techrot Motherboard", "The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {5, 1, 1, 1, 1, 1, 1, 200000})
        };
    }

    private static Resource[] getTheHexResourceRecords() {
        return new Resource[] {
            new Resource("The Countessa Comic", 750),
            new Resource("On-lyne CD", 750),
            new Resource("Chuggin' Along Sixpack", 750),
            new Resource("Mood Crystal", 750),
            new Resource("Cheddar Crowns Cereal", 750),
            new Resource("35mm Film", 750),
            new Resource("Argon Burger Meal", 1500),
            new Resource("Big Bytes Pizza", 2500)
        };
    }

}