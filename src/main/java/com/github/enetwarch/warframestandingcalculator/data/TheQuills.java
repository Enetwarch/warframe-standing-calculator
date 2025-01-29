package com.github.enetwarch.warframestandingcalculator.data;

public class TheQuills implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.THE_QUILLS.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[]  {
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
            new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {10, 30000}),
            new Sacrifice(new String[] {"Intact Sentient Core", "Credit"}, new int[] {20, 50000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {10, 100000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {20, 250000}),
            new Sacrifice(new String[] {"Eidolon Shard", "Credit"}, new int[] {30, 500000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            new Resource("Intact Sentient Core", 250),
            new Resource("Exceptional Sentient Core", 750),
            new Resource("Flawless Sentient Core", 1500),
            new Resource("Narmer Isoplast", 2000)
        };
    }

}