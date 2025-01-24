package data;

public class Entrati {
 
    public static final Syndicate SYNDICATE_NAME = Syndicate.ENTRATI;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Stranger"),
        new Rank(2, "Acquaintance"),
        new Rank(3, "Associate"),
        new Rank(4, "Friend"),
        new Rank(5, "Family")        
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Spinal Core Section"}, new int[] {3}),
        new Sacrifice(new String[] {"Keratinos Blades Blueprint", "Keratinos Gauntlet Blueprint", "Father Token", "Daughter Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Common Avichaea Tag", "Medjay Predasite Tag", "Mother Token", "Son Token"}, new int[] {5, 1, 1, 1}),
        new Sacrifice(new String[] {"Zarim Mutagen", "Arioli Mutagen", "Father Token", "Son Token"}, new int[] {1, 1, 1, 1}),
        new Sacrifice(new String[] {"Seriglass Shard", "Mother Token", "Father Token"}, new int[] {1, 1, 1})
    };

    public static final Resource[] RESOURCE_RECORD = {
        new Resource("Mother Token", 100),
        new Resource("Father Token", 100),
        new Resource("Daughter Token", 100),
        new Resource("Son Token", 500),
        new Resource("Otak Token", 100),
        new Resource("Grandmother Token", 1500)
    };

}