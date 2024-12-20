package data;
import calculator.Faction;
import calculator.OneRank;
import calculator.Standard;

public class Syndicates {
    
    public static int masteryRank = -1;
    public static int standingCap = 16000;
    public static Faction steelMeridian;
    public static Faction arbitersOfHexis;
    public static Faction cephalonSuda;
    public static Faction thePerrinSequence;
    public static Faction redVeil;
    public static Faction newLoka;
    public static Standard conclave;
    public static OneRank cephalonSimaris;
    public static Standard ostron;
    public static Standard theQuills;
    public static Standard solarisUnited;
    public static Standard voxSolaris;
    public static Standard ventkids;
    public static Standard entrati;
    public static Standard necraloid;
    public static Standard theHoldfasts;
    public static Standard cavia;
    // Initializes all calculation classes when making objects.


    /////////////////////////////////////


    // Important user input method
    public static void getMasteryRank() {
        masteryRank = Format.getUserInput("Enter your mastery rank", 0, 34);
        standingCap += masteryRank * 500;
    } // Asks the user their mastery rank which is important to calculate their standing cap.
    




    /////////////////////////////////////


    // Initialization method for Standard and OneRank syndicates.
    public static void makeSyndicates() {
        // Made to take into account the updated value of standing cap.
        // Gets called after the getMasteryRank() method.

        // These will be the format for each object.

        // calculator.Standard
        /* syndicateName = new Standard(
         *      String syndicateName
         *      new String[] rankTitles
         *      new String[][] rankSacrificeNames
         *      new int[][] rankSacrificeAmount
         *      new String[] resourceNames
         *      new int[] resourceStanding
         * );
         */

        // calculator.OneRank
        /* syndicateName = new OneRank(
         *      String syndicateName
         *      int maxStanding
         * );
         */
        

        ////////////////////////


        conclave = new Standard(
            "Conclave", // syndicateName
            new String[]{"Neutral", "Mistral", "Whirlwind", "Tempest", "Hurricane", "Typhoon"}, // rankTitles
            new String[][]{{"Neurode", "Credit"}, {"Forma", "Credit"}, {"Orokin Reactor", "Credit"}, {"Orokin Catalyst", "Credit"}, {"Orokin Ducat", "Credit"}}, // rankSacrificeNames
            new int[][]{{2, 30000}, {1, 50000}, {1, 100000}, {1, 250000}, {100, 500000}}, // rankSacrificeAmount
            new String[]{}, // resourceNames  
            new int[]{} // rsourceStanding
        ); // Empty variables or arrays mean there are none of those particular types of data involved in said syndicate.
        // Nobody plays this gamemode...

        
        //////////////////////////////
        

        cephalonSimaris = new OneRank(
            "Cephalon Simaris", //syndicateName
            125000 // maxStanding
        ); // Best way to gain standing is to go with a stealth frame on a rescue steel path mission, and scan everyone.
        // Alternatively, if you do void cascade, do not forget to scan the levelcap mobs. They count for +5,000 standing each.


        //////////////////////


        ostron = new Standard(
            "Ostron", // syndicateName
            new String[]{"Neutral", "Offworlder", "Visitor", "Trusted", "Surah", "Kin"}, // rankTitles
            new String[][]{{"Nistlepod", "Iradite", "Grokdrul", "Credit"}, {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, {"Cetus Wisp", "Maprico", "Credit"}, {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}}, // rankSacrificeNames
            new int[][]{{25, 25, 25, 10000}, {10, 40, 60, 25000}, {1, 5, 50000}, {10, 40, 5, 100000}, {1, 1, 1, 1, 200000}}, // rankSacrificeAmount
            new String[]{"Azurite", "Devar", "Veridos", "Crimzian", "Sentirum", "Nyth"}, // resourceNames
            new int[]{50, 50, 75, 100, 400, 400} // resourceStanding
        ); // Best stockpiled standing resources for Ostron are ores, do not bother turning in fish.
        // One of the best ways to earn standing here is conservation.


        /////////////////////////
        

        theQuills = new Standard(
            "The Quills", // syndicateName
            new String[]{"Neutral", "Mote", "Observer", "Adherent", "Instrument", "Architect"}, // rankTitles
            new String[][]{{"Intact Sentient Core", "Credit"}, {"Intact Sentient Core", "Credit"}, {"Eidolon Shard", "Credit"}, {"Eidolon Shard", "Credit"}, {"Eidolon Shard", "Credit"}}, // rankSacrificeNames
            new int[][]{{10, 30000}, {20, 50000}, {10, 100000}, {20, 250000}, {30, 500000}}, // rankSacrificeAmount
            new String[]{"Intact Sentient Core", "Exceptional Sentient Core", "Flawless Sentient Core", "Narmer Isoplast"}, // resourceNames
            new int[]{250, 750, 1500, 2000} // resourceStanding
        ); // Early game, hunting vomes at night or farming Voruna at Lua conjunction survival can make you passively gain sentient cores.
        // Best way to gain standing is through tridolon hunts. 3x3 is easy achieve with a good build while 5x3 and 6x3 requires skill and good hardware.


        /////////////////////////////


        solarisUnited = new Standard(
            "Solaris United", // syndicateName
            new String[]{"Neutral", "Outworlder", "Rapscallion", "Doer", "Cove", "Old Mate"}, // rankTitles
            new String[][]{{"Training Debt-Bond", "Credit"}, {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"}, {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}}, // rankSacrificeNames
            new int[][]{{2, 10000}, {3, 2, 25000}, {4, 3, 2, 50000}, {5, 4, 3, 100000}, {5, 5, 3, 200000}}, // rankSacrificeAmount    
            new String[]{"Training Debt-Bond", "Shelter Debt-Bond", "Medical Debt-Bond", "Advances Debt-Bond", "Familial Debt-Bond"}, // resourceNames
            new int[]{100, 200, 300, 400, 500} // resourceStanding
        ); // A good way for solo players for standing is also by doing conservation. If you have a rank 5 Solaris United friend, farm Exploiter Orb with them and turn in the gems.
        // Best way to earn standing here is through farming Profit-Taker. It also lets you farm credits and standing resources for the next syndicate.


        //////////////////////////
        

        voxSolaris = new Standard(
            "Vox Solaris", // syndicateName
            new String[]{"Neutral", "Operative", "Agent", "Hand", "Instrument", "Shadow"}, // rankTitles
            new String[][]{{"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"}, {"Gyromag System", "Vega Toroid", "Credit"}, {"Atmo System", "Calda Toroid", "Credit"}, {"Repeller System", "Sola Toroid", "Credit"}, {"Crisma Toroid", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 1, 1, 50000}, {1, 1, 100000}, {1, 1, 250000}, {1, 1, 500000}, {1, 1000000}}, // rankSacrificeAmount    
            new String[]{"Vega Toroid", "Calda Toroid", "Sola Toroid", "Narmer Isoplast", "Crisma Toroid", "Lazulite Toroid"}, // resourceNames
            new int[]{1000, 1000, 1000, 2000, 6000, 12000} // resourceStanding
        ); // Just like mentioned earlier, the only good ways to earn standing here is to fight either of the 2 boss orbs.
        // Best way to earn standing is also through Profit-Taker. 3 minutes can be obtained with a good build while sub-1m30s requires skill and good hardware.


        ////////////////////////


        ventkids = new Standard(
            "Ventkids", // syndicateName
            new String[]{"Neutral", "Operative", "Agent", "Hand", "Instrument", "Shadow"}, // rankTitles
            new String[][]{}, //rankSacrificeNames
            new int[][]{}, // rankSacrificeAmount
            new String[]{}, // resourceNames
            new int[]{} // resourceStanding
        ); // There aren't any available standing materials or sacrifices needed for ventkids.
        // You can either farm races, or farm tricks. Either one works, just choose whichever one you like doing more.


        ///////////////////////


        entrati = new Standard(
            "Entrati", // syndicateName
            new String[]{"Neutral", "Stranger", "Acquaintance", "Associate", "Friend", "Family"}, // rankTitles
            new String[][]{{"Spinal Core Section"},{"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"}, {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"}, {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"}, {"Seriglass Shard", "Mother Token", "Father Token"}}, // rankSacrificeNames
            new int[][]{{3}, {1, 1, 1, 1}, {5, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1}}, // rankSacrificeAmount
            new String[]{"Mother Token", "Father Token", "Daughter Token", "Son Token", "Otak Token", "Grandmother Token"}, // resourceNames 
            new int[]{100, 100, 100, 500, 100, 1500} // resourceStanding 
        ); // Different tokens will be needed when ranking up, especially at rank 5 which requires 20 grandmother tokens to buy a seriglass shard.
        // Best way to gain standing is by doing bounties and farming mother tokens. These tokens can also be used in the Nights of Naberus event, occuring every year in October.


        /////////////////////////


        necraloid = new Standard(
            "Necraloid", // syndicateName
            new String[]{"Neutral", "Clearance: Agnesis", "Clearance: Modus", "Clearance: Odima"}, // rankTitles
            new String[][]{{"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"}, {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"}, {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}}, // rankSacrificeNames
            new int[][]{{10, 150, 1, 20}, {15, 250, 1, 20}, {15, 350, 1, 20}, {}, {}}, // rankSacrificeAmount
            new String[]{"Orokin Orientation Matrix", "Orokin Ballistics Matrix", "Orokin Animus Matrix"}, // resourceNames
            new int[]{1000, 2500, 5000} // resourceStanding
        ); // Necraloid only has 3 ranks. Each resource can be obtained in separate tiers, with the higher tiers giving the higher standing resources.
        // Tier 3 bounties are the best way to farm standing. You will have to repeat Tier 1 and 2 first in order to get enough sacrifice resources to rank up.


        ////////////////////////////


        theHoldfasts = new Standard(
            "The Holdfasts", // syndicateName
            new String[]{"Neutral", "Fallen", "Watcher", "Guardian", "Seraph", "Angel"}, // rankTitles
            new String[][]{{"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, {"Voidplume Pinion", "Thrax PLasm", "Entrati Lanthorn", "Credit"}}, // rankSacrificeNames
            new int[][]{{5, 2000, 2000, 10000}, {10, 10, 5000, 25000}, {10, 10, 5000, 50000}, {15, 60, 40, 100000}, {5, 90, 20, 200000}}, // rankSacrificeAmount
            new String[]{"Voidplume Down", "Voidplume Vane", "Voidplume Crest", "Voidplume Quill", "Voidplume Pinion"}, // resourceNames
            new int[]{500, 1000, 2000, 2500, 5000} // resourceStanding
        ); // Every Voidplume is spread around the entire mission. You can get up to 8 and get a Pinion by finding and killing a Void Angel.
        // Best way to farm standing is through bounties, specifically steel path tier 5 bounties as it gives 8 Voidplume Quills each.


        /////////////////////


        cavia = new Standard(
            "Cavia", // syndicateName
            new String[]{"Neutral", "Assistant", "Researcher", "Colleague", "Scholar", "Illuminate"}, //rankTitles
            new String[][]{{"Shrill Voca", "Entrati Obols", "Rubedo", "Credit"}, {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"}, {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"}, {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"}, {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}}, // rankSacrificeNames
            new int[][]{{3, 300, 11000, 10000}, {5, 60, 12, 8, 25000}, {2, 8, 15, 16, 50000}, {1, 10, 1500, 5, 100000}, {10, 25, 10, 32, 200000}}, // rankSacrificeAmount
            new String[]{"Shrill Voca", "Bellow Voca", "Echo Voca"}, // resourceNames
            new int[]{500, 1000, 2000} // resourceStanding
        ); // Voca will be required to rank up in this syndicate. Just like Voidplumes, there are 8 of them spread throughout every mission.
        // Bounties are the best way to gain standing. Weeklies like Netracells and Elite Deep Archimedea also give standing.

    }


    ///////////////////////////////////


    // Initialization method for Faction syndicates.
    public static void makeFactions() {
        // Made to take into account the updated value of userFaction.
        // Gets called after the getFaction() method.

        // calculator.Faction
        /* syndicateName = new Faction(
         *      String syndicateName,
         *      String[] rankTitles,
         *      String[][] rankSacrificeNames,
         *      int[][] rankSacrificeAmount,
         *      String[] resourceNames,
         * );
         */


        ////////////////////////////


        steelMeridian = new Faction(
            "Steel Meridian", // syndicateName
            new String[]{"Enemy", "Outcast", "Neutral", "Initiation", "Brave", "Valiant", "Defender", "Protector", "General"}, // rankTitles
            new String[][]{{"Orokin Catalyst", "Credit"}, {"Forma", "Credit"}, {"Salvage", "Credit"}, {"Morphic", "Credit"}, {"Forma", "Credit"}, {"Orokin Catalyst", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {1000, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Insignia", "Defender Insignia", "General Insignia"} // resourceNames
        );


        //////////////////////////////


        arbitersOfHexis = new Faction(
            "Arbiters of Hexis", // syndicateName
            new String[]{"Fraud", "Deceiver", "Neutral", "Initiation", "Principled", "Authentic", "Lawful", "Crusader", "Maxim"}, // rankTitles
            new String[][]{{"Orokin Reactor", "Credit"}, {"Forma", "Credit"}, {"Alloy Plate", "Credit"}, {"Gallium", "Credit"}, {"Forma", "Credit"}, {"Orokin Reactor", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {500, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Medallion", "Lawful Medallion", "Maxim Medallion"} // resourceNames
        );


        ///////////////////////////


        cephalonSuda = new Faction(
            "Cephalon Suda", // syndicateName
            new String[]{"Waste", "Debris", "Neutral", "Initiation", "Competent", "Intriguing", "Intelligent", "Wise", "Genius"}, // rankTitles
            new String[][]{{"Orokin Catalyst", "Credit"}, {"Forma", "Credit"}, {"Circuit", "Credit"}, {"Control Module", "Credit"}, {"Forma", "Credit"}, {"Orokin Catalyst", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {500, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Datum", "Intriguin Datum", "Genius Datum"} // resourceNames
        );


        ////////////////////////////////


        thePerrinSequence = new Faction(
            "The Perrin Sequence", // syndicateName
            new String[]{"Write-Off", "Liability", "Neutral", "Initiation", "Associate", "Senior Associate", "Executive", "Senior Executive", "Partner"}, // rankTitles
            new String[][]{{"Orokin Reactor", "Credit"}, {"Forma", "Credit"}, {"Polymer Bundle", "Credit"}, {"Detonite Ampule", "Credit"}, {"Forma", "Credit"}, {"Orokin Reactor", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {100, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Quittance", "Executive Quittance", "Partner Quittance"} // resourceNames
        );
        

        //////////////////////


        redVeil = new Faction(
            "Red Veil", // syndicateName
            new String[]{"Corrupt", "Suspect", "Neutral", "Initiation", "Respected", "Honored", "Esteemed", "Revered", "Exalted"}, // rankTitles
            new String[][]{{"Orokin Catalyst", "Credit"}, {"Forma", "Credit"}, {"Alloy Plate", "Credit"}, {"Gallium", "Credit"}, {"Forma", "Credit"}, {"Orokin Catalyst", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {500, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Mark", "Honored Mark", "Exalted Mark"} // resourceNames
        );
        

        //////////////////////


        newLoka = new Faction(
            "New Loka", // syndicateName
            new String[]{"Exiled", "Condemned", "Neutral", "Initiation", "Humane", "Bountiful", "Benevolent", "Pure", "Flawless"}, // rankTitles
            new String[][]{{"Orokin Reactor", "Credit"}, {"Forma", "Credit"}, {"Ferrite", "Credit"}, {"Fieldron Sample", "Credit"}, {"Forma", "Credit"}, {"Orokin Reactor", "Credit"}, {"Aya", "Credit"}, {"Aya", "Credit"}}, // rankSacrificeNames
            new int[][]{{1, 100000}, {1, 50000}, {1000, 10000}, {2, 30000}, {1, 50000}, {1, 100000}, {2, 250000}, {3, 500000}}, // rankSacrificeAmount
            new String[]{"Seed", "Bountiful Seed", "Flawless Seed"} // resourceNames
        );

    }

}