package data;
import java.util.stream.IntStream;

public record Sacrifice(String[] sacrificeName, int[] sacrificeAmount) {

    public Sacrifice {
        if (IntStream.of(sacrificeAmount).sum() < 0) {
            throw new IllegalArgumentException("Invalid sacrifice amount.");
        }
    }

}