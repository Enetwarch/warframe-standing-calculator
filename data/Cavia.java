package data;

public class Cavia {

    public static final Syndicate SYNDICATE_NAME = Syndicate.CAVIA;

    public static final Rank[] RANK_RECORD = {
        new Rank(0, "Neutral"),
        new Rank(1, "Assistant"),
        new Rank(2, "Researcher"),
        new Rank(3, "Colleague"),
        new Rank(4, "Scholar"),
        new Rank(5, "Illuminate")        
    };

    public static final Sacrifice[] SACRIFICE_RECORD = {
        new Sacrifice(new String[] {"Shrill Voca", "Entrati Obol", "Rubedo", "Credit"}, new int[] {3, 300, 11000, 10000}),
        new Sacrifice(new String[] {"Shrill Voca", "Voidgel Orb", "Necracoil", "Stela", "Credit"}, new int[] {5, 60, 12, 8, 25000}),
        new Sacrifice(new String[] {"Bellow Voca", "Shrill Voca", "Necracoil", "Stela", "Credit"}, new int[] {2, 8, 15, 16, 50000}),
        new Sacrifice(new String[] {"Echo Voca", "Bellow Voca", "Entrati Obol", "Entrati Lanthorn", "Credit"}, new int[] {1, 10, 1500, 5, 100000}),
        new Sacrifice(new String[] {"Echo Voca", "Necracoil", "Entrati Lanthorn", "Stela", "Credit"}, new int[] {10, 25, 10, 32, 200000})
    };

    public static final Resource[] RESOURCE_RECORD = {
        new Resource("Shrill Voca", 500),
        new Resource("Bellow Voca", 1000),
        new Resource("Echo Voca", 2000)
    };

}