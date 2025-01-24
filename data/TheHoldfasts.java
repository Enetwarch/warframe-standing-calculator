package data;

public class TheHoldfasts {

    public static final Syndicate SYNDICATE_NAME = Syndicate.THE_HOLDFASTS;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Fallen"),
        new Rank(2, "Watcher"),
        new Rank(3, "Guardian"),
        new Rank(4, "Seraph"),
        new Rank(5, "Angel")        
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Voidplume Down", "Ferrite", "Alloy Plate", "Credit"}, new int[] {5, 2000, 2000, 10000}),
        new Sacrifice(new String[] {"Voidplume Vane", "Voidgel Orb", "Alloy Plate", "Credit"}, new int[] {10, 10, 5000, 25000}),
        new Sacrifice(new String[] {"Voidplume Crest", "Entrati Lanthorn", "Ferrite", "Credit"}, new int[] {10, 10, 5000, 50000}),
        new Sacrifice(new String[] {"Voidplume Quill", "Thrax Plasm", "Voidgel Orb", "Credit"}, new int[] {15, 60, 40, 100000}),
        new Sacrifice(new String[] {"Voidplume Pinion", "Thrax Plasm", "Entrati Lanthorn", "Credit"}, new int[] {5, 90, 20, 200000})
    };

    public static final Resource[] RESOURCE_RECORD = {
        new Resource("Voidplume Down", 500),
        new Resource("Voidplume Vane", 1000),
        new Resource("Voidplume Crest", 2000),
        new Resource("Voidplume Quill", 2500),
        new Resource("Voidplume Pinion", 5000)
    };

}