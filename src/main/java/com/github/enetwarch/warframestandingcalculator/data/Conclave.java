package com.github.enetwarch.warframestandingcalculator.data;

public class Conclave {
    
    public static final Syndicate SYNDICATE_NAME = Syndicate.CONCLAVE;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Mistral"),
        new Rank(2, "Whirlwind"),
        new Rank(3, "Tempest"),
        new Rank(4, "Hurricane"),
        new Rank(5, "Typhoon")
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Neurode", "Credit"}, new int[] {2, 30000}),
        new Sacrifice(new String[] {"Forma", "Credit"}, new int[] {1, 50000}),
        new Sacrifice(new String[] {"Orokin Reactor", "Credit"}, new int[] {1, 100000}),
        new Sacrifice(new String[] {"Orokin Catalyst", "Credit"}, new int[] {1, 250000}),
        new Sacrifice(new String[] {"Orokin Ducat", "Credit"}, new int[] {100, 500000})
    };

    public static final Resource[] RESOURCE_RECORD = {
        // No resources for Conclave
    }; 

}