package data;
import calculator.OneRank;
import calculator.Standard;

public class Syndicates {
    
    public static int masteryRank = -1;
    public static int standingCap = 16000;
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


    /////////////////////////////////////


    public static void getMasteryRank() {
        masteryRank = Format.getUserInput(
            "Enter your mastery rank",
            0,
            34
        );
        standingCap += masteryRank * 500;
    }
    

    /////////////////////////////////////


    public static void makeSyndicates() {

        conclave = new Standard(
            "Conclave",
            new String[]{
                "Neutral", 
                "Mistral", 
                "Whirlwind", 
                "Tempest", 
                "Hurricane", 
                "Typhoon"
            },
            new String[][]{
                {"Neurode", "Credit"}, 
                {"Forma", "Credit"}, 
                {"Orokin Reactor", "Credit"}, 
                {"Orokin Catalyst", "Credit"}, 
                {"Orokin Ducat", "Credit"}
            },  
            new int[][]{
                {2, 30000},
                {1, 50000}, 
                {1, 100000},
                {1, 250000},
                {100, 500000}
            }, 
            new String[]{

            }, 
            new int[]{

            }  
        ); 

        
        //////////////////////////////
        

        cephalonSimaris = new OneRank(
            "Cephalon Simaris",
            125000
        );


        //////////////////////


        ostron = new Standard(
            "Ostron",
            new String[]{
                "Neutral", 
                "Offworlder",
                "Visitor",
                "Trusted",
                "Surah",
                "Kin"
            },
            new String[][]{
                {"Nistlepod", "Iradite", "Grokdrul", "Credit"},
                {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"},
                {"Cetus Wisp", "Maprico", "Credit"},
                {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"},
                {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}
            },
            new int[][]{
                {25, 25, 25, 10000},
                {10, 40, 60, 25000},
                {1, 5, 50000},
                {10, 40, 5, 100000},
                {1, 1, 1, 1, 200000}
            },
            new String[]{
                "Azurite",
                "Devar", 
                "Veridos", 
                "Crimzian", 
                "Sentirum", 
                "Nyth"
            },
            new int[]{
                50, 
                50, 
                75, 
                100, 
                400, 
                400
            }
        );


        /////////////////////////
        

        theQuills = new Standard(
            "The Quills",
            new String[]{
                "Neutral", 
                "Mote", 
                "Observer", 
                "Adherent", 
                "Instrument", 
                "Architect"
            },
            new String[][]{
                {"Intact Sentient Core", "Credit"},
                {"Intact Sentient Core", "Credit"},
                {"Eidolon Shard", "Credit"},
                {"Eidolon Shard", "Credit"},
                {"Eidolon Shard", "Credit"}
            },
            new int[][]{
                {10, 30000},
                {20, 50000},
                {10, 100000},
                {20, 250000},
                {30, 500000}
            },
            new String[]{
                "Intact Sentient Core", 
                "Exceptional Sentient Core", 
                "Flawless Sentient Core", 
                "Narmer Isoplast"
            },
            new int[]{
                250, 
                750, 
                1500, 
                2000
            }
        );


        /////////////////////////////


        solarisUnited = new Standard(
            "Solaris United",
            new String[]{
                "Neutral", 
                "Outworlder",
                "Rapscallion",
                "Doer",
                "Cove",
                "Old Mate"
            },
            new String[][]{
                {"Training Debt-Bond", "Credit"},
                {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"},
                {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"},
                {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"},
                {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}
            },
            new int[][]{
                {2, 10000},
                {3, 2, 25000},
                {4, 3, 2, 50000},
                {5, 4, 3, 100000},
                {5, 5, 3, 200000}
            },    
            new String[]{
                "Training Debt-Bond",
                "Shelter Debt-Bond",
                "Medical Debt-Bond",
                "Advances Debt-Bond",
                "Familial Debt-Bond"
            },
            new int[]{
                100, 
                200, 
                300, 
                400, 
                500
            }
        );


        //////////////////////////
        

        voxSolaris = new Standard(
            "Vox Solaris",
            new String[]{
                "Neutral", 
                "Operative", 
                "Agent", 
                "Hand", 
                "Instrument", 
                "Shadow"
            },
            new String[][]{
                {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"},
                {"Gyromag System", "Vega Toroid", "Credit"},
                {"Atmo System", "Calda Toroid", "Credit"},
                {"Repeller System", "Sola Toroid", "Credit"},
                {"Crisma Toroid", "Credit"}
            },
            new int[][]{
                {1, 1, 1, 50000},
                {1, 1, 100000}, 
                {1, 1, 250000}, 
                {1, 1, 500000}, 
                {1, 1000000}
            },    
            new String[]{
                "Vega Toroid", 
                "Calda Toroid", 
                "Sola Toroid", 
                "Narmer Isoplast", 
                "Crisma Toroid", 
                "Lazulite Toroid"
            },
            new int[]{
                1000, 
                1000, 
                1000, 
                2000, 
                6000, 
                12000
            }
        );


        ////////////////////////


        ventkids = new Standard(
            "Ventkids",
            new String[]{
                "Neutral", 
                "Operative", 
                "Agent", 
                "Hand", 
                "Instrument", 
                "Shadow"
            },
            new String[][]{},
            new int[][]{},    
            new String[]{},
            new int[]{}
        );


        ///////////////////////


        entrati = new Standard(
            "Entrati",
            new String[]{
                "Neutral", 
                "Stranger", 
                "Acquaintance", 
                "Associate", 
                "Friend", 
                "Family"
            },
            new String[][]{
                {"Spinal Core Section"},
                {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"},
                {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"},
                {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"},
                {"Seriglass Shard", "Mother Token", "Father Token"}
            },
            new int[][]{
                {3},
                {1, 1, 1, 1},
                {5, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1}
            },
            new String[]{
                "Mother Token", 
                "Father Token", 
                "Daughter Token", 
                "Son Token", 
                "Otak Token", 
                "Grandmother Token"
            }, 
            new int[]{
                100, 
                100, 
                100, 
                500, 
                100, 
                1500
            } 
        );


        /////////////////////////


        necraloid = new Standard(
            "Necraloid",
            new String[]{
                "Neutral", 
                "Clearance: Agnesis",
                "Clearance: Modus",
                "Clearance: Odima"
            },
            new String[][]{
                {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"},
                {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"},
                {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}
            },
            new int[][]{
                {},
                {},
                {10, 150, 1, 20},
                {15, 250, 1, 20},
                {15, 350, 1, 20}
            },
            new String[]{
                "Orokin Orientation Matrix",
                "Orokin Ballistics Matrix",
                "Orokin Animus Matrix"
            },
            new int[]{
                1000, 
                2500, 
                5000
            }
        );


        ////////////////////////////


        theHoldfasts = new Standard(
            "The Holdfasts",
            new String[]{
                "Neutral", 
                "Fallen",
                "Watcher",
                "Guardian",
                "Seraph",
                "Angel"
            },
            new String[][]{
                {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"},
                {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"},
                {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"},
                {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"},
                {"Voidplume Pinion", "Thrax PLasm", "Entrati Lanthorn", "Credit"}
            },
            new int[][]{
                {5, 2000, 2000, 10000},
                {10, 10, 5000, 25000}, 
                {10, 10, 5000, 50000}, 
                {15, 60, 40, 100000}, 
                {5, 90, 20, 200000}
            },
            new String[]{
                "Voidplume Down", 
                "Voidplume Vane",
                "Voidplume Crest",
                "Voidplume Quill",
                "Voidplume Pinion"
            },
            new int[]{
                500, 
                1000, 
                2000, 
                2500, 
                5000
            }
        );
            

        /////////////////////


        cavia = new Standard(
            "Cavia",
            new String[]{
                "Neutral", 
                "Assistant",
                "Researcher",
                "Colleague",
                "Scholar",
                "Illuminate"
            },
            new String[][]{
                {"Shrill Voca", "Entrati Obols", "Rubedo", "Credit"},
                {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"},
                {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"},
                {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"},
                {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}
            },
            new int[][]{
                {3, 300, 11000, 10000},
                {5, 60, 12, 8, 25000},
                {2, 8, 15, 16, 50000}, 
                {1, 10, 1500, 5, 100000}, 
                {10, 25, 10, 32, 200000}
            }, 
            new String[]{
                "Shrill Voca",
                "Bellow Voca",
                "Echo Voca"
            },
            new int[]{
                500, 
                1000, 
                2000
            }
        );

    }

}