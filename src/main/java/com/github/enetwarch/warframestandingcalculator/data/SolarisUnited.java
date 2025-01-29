package com.github.enetwarch.warframestandingcalculator.data;

public class SolarisUnited implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.SOLARIS_UNITED.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Outworlder"),
            new Rank(2, "Rapscallion"),
            new Rank(3, "Doer"),
            new Rank(4, "Cove"),
            new Rank(5, "Old Mate")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Training Debt-Bond", "Credit"}, new int[] {2, 10000}),
            new Sacrifice(new String[] {"Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {3, 2, 25000}),
            new Sacrifice(new String[] {"Medical Debt-Bond", "Shelter Debt-Bond", "Training Debt-Bond", "Credit"}, new int[] {4, 3, 2, 50000}),
            new Sacrifice(new String[] {"Advances Debt-Bond", "Medical Debt-Bond", "Shelter Debt-Bond", "Credit"}, new int[] {5, 4, 3, 100000}),
            new Sacrifice(new String[] {"Familial Debt-Bond", "Advances Debt-Bond", "Medical Debt-Bond", "Credit"}, new int[] {5, 5, 3, 200000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            new Resource("Training Debt-Bond", 100),
            new Resource("Shelter Debt-Bond", 200),
            new Resource("Medical Debt-Bond", 300),
            new Resource("Advances Debt-Bond", 400),
            new Resource("Familial Debt-Bond", 500)
        };
    }

}