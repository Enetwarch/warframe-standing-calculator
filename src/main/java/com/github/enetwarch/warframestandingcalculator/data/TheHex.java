package com.github.enetwarch.warframestandingcalculator.data;

public class TheHex implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.THE_HEX.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Leftovers"),
            new Rank(2, "Fresh Slice"),
            new Rank(3, "2-For-1"),
            new Rank(4, "Hot & Fresh"),
            new Rank(5, "Pizza Party")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Efervon Sample", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {15, 5, 10000}),
            new Sacrifice(new String[] {"Experimental Arc-Relay", "Entrati Obol", "Hollvanian Pitchweave Fragment", "Hollar"}, new int[] {5, 12, 25, 25000}),
            new Sacrifice(new String[] {"The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {1, 1, 1, 1, 1, 1, 50000}),
            new Sacrifice(new String[] {"Techrot Chitin", "Necracoil", "Efervon Sample", "Hollar"}, new int[] {25, 25, 40, 100000}),
            new Sacrifice(new String[] {"Techrot Motherboard", "The Countessa Comic", "On-lyne CD", "Chuggin' Along Sixpack", "Mood Crystal", "Cheddar Crowns Cereal", "35mm Film", "Hollar"}, new int[] {5, 1, 1, 1, 1, 1, 1, 200000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
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