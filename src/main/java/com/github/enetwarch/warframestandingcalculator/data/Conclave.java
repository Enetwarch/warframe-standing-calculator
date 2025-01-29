package com.github.enetwarch.warframestandingcalculator.data;

public class Conclave implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.CONCLAVE.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Mistral"),
            new Rank(2, "Whirlwind"),
            new Rank(3, "Tempest"),
            new Rank(4, "Hurricane"),
            new Rank(5, "Typhoon")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Neurode", "Credit"}, new int[] {2, 30000}),
            new Sacrifice(new String[] {"Forma", "Credit"}, new int[] {1, 50000}),
            new Sacrifice(new String[] {"Orokin Reactor", "Credit"}, new int[] {1, 100000}),
            new Sacrifice(new String[] {"Orokin Catalyst", "Credit"}, new int[] {1, 250000}),
            new Sacrifice(new String[] {"Orokin Ducat", "Credit"}, new int[] {100, 500000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            // No resources for Conclave
        };
    }

}