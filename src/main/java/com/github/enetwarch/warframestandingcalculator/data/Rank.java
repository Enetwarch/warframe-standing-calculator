package com.github.enetwarch.warframestandingcalculator.data;

public record Rank(int rankNumber, String rankTitle) {

    public Rank {
        if (rankNumber < 0) {
            throw new IllegalArgumentException("Invalid rank number.");
        }
    }

    public static int getRankNumberMin(Rank[] rankRecords) {
        int rankNumberMin = rankRecords[0].rankNumber;
        for (Rank rankRecord : rankRecords) {
            final int rankNumber = rankRecord.rankNumber;
            if (rankNumber < rankNumberMin) {
                rankNumberMin = rankNumber;
            }
        }
        return rankNumberMin;
    }

    public static int getRankNumberMax(Rank[] rankRecords) {
        int rankNumberMax = rankRecords[0].rankNumber;
        for (Rank rankRecord : rankRecords) {
            final int rankNumber = rankRecord.rankNumber;
            if (rankNumber > rankNumberMax) {
                rankNumberMax = rankNumber;
            }
        }
        return rankNumberMax;
    }

    public static void printRankRecords(Rank[] rankRecords) {
        final StringBuilder printRankRecords = new StringBuilder();
        for (Rank rankRecord : rankRecords) {
            final int rankNumber = rankRecord.rankNumber();
            final String rankTitle = rankRecord.rankTitle();
            printRankRecords.append(String.format("%d %s%n", rankNumber, rankTitle));
        }
        System.out.print(printRankRecords);
    }

}