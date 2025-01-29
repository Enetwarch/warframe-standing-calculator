package com.github.enetwarch.warframestandingcalculator.data;

public class Necraloid implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.NECRALOID.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Clearance: Agnesis"),
            new Rank(2, "Clearance: Modus"),
            new Rank(3, "Clearance: Odima")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Orokin Orientation Matrix", "Void Trace", "Zymos Barrel Blueprint", "Father Token"}, new int[] {10, 150, 1, 20}),
            new Sacrifice(new String[] {"Orokin Ballistics Matrix", "Void Trace", "Sepulcrum Barrel Blueprint", "Father Token"}, new int[] {15, 250, 1, 20}),
            new Sacrifice(new String[] {"Orokin Animus Matrix", "Void Trace", "Trumna Barrel Blueprint", "Father Token"}, new int[] {15, 350, 1, 20})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            new Resource("Orokin Orientation Matrix", 1000),
            new Resource("Orokin Ballistics Matrix", 2500),
            new Resource("Orokin Animus Matrix", 5000)
        };
    }

}