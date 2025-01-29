package com.github.enetwarch.warframestandingcalculator.data;

public class Ventkids implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.VENTKIDS.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Operative"),
            new Rank(2, "Agent"),
            new Rank(3, "Hand"),
            new Rank(4, "Instrument"),
            new Rank(5, "Shadow")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            // No sacrifices for Ventkids
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            // No resources for Ventkids
        };
    }

}