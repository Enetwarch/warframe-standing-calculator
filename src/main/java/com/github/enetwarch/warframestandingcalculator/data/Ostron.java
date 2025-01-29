package com.github.enetwarch.warframestandingcalculator.data;

public class Ostron {
    
    public static final Syndicate SYNDICATE_NAME = Syndicate.OSTRON;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Offworlder"),
        new Rank(2, "Visitor"),
        new Rank(3, "Trusted"),
        new Rank(4, "Surah"),
        new Rank(5, "Kin")        
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Nistlepod", "Iradite", "Grokdrul", "Credit"}, new int[] {25, 25, 25, 10000}),
        new Sacrifice(new String[] {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, new int[] {10, 40, 60, 25000}),
        new Sacrifice(new String[] {"Cetus Wisp", "Maprico", "Credit"}, new int[] {1, 5, 50000}),
        new Sacrifice(new String[] {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, new int[] {10, 40, 5, 100000}),
        new Sacrifice(new String[] {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}, new int[] {1, 1, 1, 1, 200000})
    };

    public static final Resource[] RESOURCE_RECORD = {
        new Resource("Azurite", 50),
        new Resource("Devar", 50),
        new Resource("Veridos", 75),
        new Resource("Crimzian", 100),
        new Resource("Sentirum", 400),
        new Resource("Nyth", 400)
    };

}