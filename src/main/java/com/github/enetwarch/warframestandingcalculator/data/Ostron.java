package com.github.enetwarch.warframestandingcalculator.data;

public class Ostron implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.OSTRON.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Offworlder"),
            new Rank(2, "Visitor"),
            new Rank(3, "Trusted"),
            new Rank(4, "Surah"),
            new Rank(5, "Kin")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Nistlepod", "Iradite", "Grokdrul", "Credit"}, new int[] {25, 25, 25, 10000}),
            new Sacrifice(new String[] {"Tear Azurite", "Pyrol", "Fish Scale", "Credit"}, new int[] {10, 40, 60, 25000}),
            new Sacrifice(new String[] {"Cetus Wisp", "Maprico", "Credit"}, new int[] {1, 5, 50000}),
            new Sacrifice(new String[] {"Maprico", "Fersteel Alloy", "Murkray Liver", "Credit"}, new int[] {10, 40, 5, 100000}),
            new Sacrifice(new String[] {"Nyth", "Sentirum", "Norg Brain", "Cuthol Tendril", "Credit"}, new int[] {1, 1, 1, 1, 200000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            new Resource("Azurite", 50),
            new Resource("Devar", 50),
            new Resource("Veridos", 75),
            new Resource("Crimzian", 100),
            new Resource("Sentirum", 400),
            new Resource("Nyth", 400)
        };
    }

}