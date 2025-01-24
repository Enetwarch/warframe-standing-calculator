package data;

public class VoxSolaris {
 
    public static final Syndicate SYNDICATE_NAME = Syndicate.VOX_SOLARIS;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Operative"),
        new Rank(2, "Agent"),
        new Rank(3, "Hand"),
        new Rank(4, "Instrument"),
        new Rank(5, "Shadow")        
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Calda Toroid", "Vega Toroid", "Sola Toroid", "Credit"}, new int[] {1, 1, 1, 50000}),
        new Sacrifice(new String[] {"Gyromag System", "Vega Toroid", "Credit"}, new int[] {1, 1, 100000}),
        new Sacrifice(new String[] {"Atmo System", "Calda Toroid", "Credit"}, new int[] {1, 1, 250000}),
        new Sacrifice(new String[] {"Repeller System", "Sola Toroid", "Credit"}, new int[] {1, 1, 500000}),
        new Sacrifice(new String[] {"Crisma Toroid", "Credit"}, new int[] {1, 1000000})
    };

    public static final Resource[] RESOURCE_RECORD = {
        new Resource("Vega Toroid", 1000),
        new Resource("Calda Toroid", 1000),
        new Resource("Sola Toroid", 1000),
        new Resource("Narmer Isoplast", 2000),
        new Resource("Crisma Toroid", 6000),
        new Resource("Lazulite Toroid", 12000)
    };

}