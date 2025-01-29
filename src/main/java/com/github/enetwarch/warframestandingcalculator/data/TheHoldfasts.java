package com.github.enetwarch.warframestandingcalculator.data;

public class TheHoldfasts implements Data {

    @Override
    public String getSyndicateName() {
        return Syndicate.THE_HOLDFASTS.getSyndicate();
    }

    @Override
    public Rank[] getRankRecord() {
        return new Rank[] {
            new Rank(0, "Neutral"),
            new Rank(1, "Fallen"),
            new Rank(2, "Watcher"),
            new Rank(3, "Guardian"),
            new Rank(4, "Seraph"),
            new Rank(5, "Angel")
        };
    }

    @Override
    public Sacrifice[] getSacrificeRecord() {
        return new Sacrifice[] {
            new Sacrifice(new String[] {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, new int[] {5, 2000, 2000, 10000}),
            new Sacrifice(new String[] {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, new int[] {10, 10, 5000, 25000}),
            new Sacrifice(new String[] {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, new int[] {10, 10, 5000, 50000}),
            new Sacrifice(new String[] {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, new int[] {15, 60, 40, 100000}),
            new Sacrifice(new String[] {"Voidplume Pinion", "Thrax Plasm", "Entrati Lanthorn", "Credit"}, new int[] {5, 90, 20, 200000})
        };
    }

    @Override
    public Resource[] getResourceRecord() {
        return new Resource[] {
            new Resource("Voidplume Down", 500),
            new Resource("Voidplume Vane", 1000),
            new Resource("Voidplume Crest", 2000),
            new Resource("Voidplume Quill", 2500),
            new Resource("Voidplume Pinion", 5000)
        };
    }

}