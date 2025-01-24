package data;

public record Rank(int rankNumber, String rankTitle) {

    public Rank {
        if (rankNumber < 0) {
            throw new IllegalArgumentException("Invalid rank number.");
        }
    }

}