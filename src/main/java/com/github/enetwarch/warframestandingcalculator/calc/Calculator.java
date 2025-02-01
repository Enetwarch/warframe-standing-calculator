package com.github.enetwarch.warframestandingcalculator.calc;
import com.github.enetwarch.warframestandingcalculator.data.Sacrifice;
import com.github.enetwarch.warframestandingcalculator.data.Resource;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.data.Rank;
import com.github.enetwarch.warframestandingcalculator.data.Data;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {

    private final String syndicateName;
    private final Rank[] rankRecords;
    private final Sacrifice[] sacrificeRecords;
    private final Resource[] resourceRecords;
    private final StringBuilder calculatorOutput;
    private int userRank;
    private int userStanding;
    private int[] userResources;

    public Calculator(Data syndicateData) {
        this.syndicateName = syndicateData.getSyndicateName();
        this.rankRecords = syndicateData.getRankRecord();
        this.sacrificeRecords = syndicateData.getSacrificeRecord();
        this.resourceRecords = syndicateData.getResourceRecord();
        this.calculatorOutput = new StringBuilder();
        this.userRank = 0;
        this.userStanding = 0;
        this.userResources = new int[resourceRecords.length];
    }

    private static int masteryRank = -1;
    private static int standingCap = 16000;
    private static final int[][] STANDING_PER_RANK = {{0, 5000}, {0, 22000}, {0, 44000}, {0, 70000}, {0, 99000}, {0, 132000}};

    public static void setMasteryRank() {
        final int masteryRankMin = 0;
        final int masteryRankMax = 34;
        masteryRank = Input.getUserInputInt("Enter your mastery rank", masteryRankMin, masteryRankMax);
        standingCap += masteryRank * 500;
        Output.printSpace();
    }

    public void logToConsole() {
        getRank();
        getStanding();
        getResources();
        buildCalculatorOutputHeader();
        buildCalculatorOutputRank();
        buildCalculatorOutputSacrifices();
        buildCalculatorOutputResources();
        System.out.print(calculatorOutput);
    }

    private void getRank() {
        final int rankMin = Rank.getRankNumberMin(rankRecords);
        final int rankMax = Rank.getRankNumberMax(rankRecords);
        Rank.printRankRecords(rankRecords);
        userRank = Input.getUserInputInt("Enter your rank", rankMin, rankMax);
        Output.printSpace();
    }

    private void getStanding() {
        final String rankTitle = rankRecords[userRank].rankTitle();
        final int validStandingMin = STANDING_PER_RANK[userRank][0];
        final int validStandingMax = STANDING_PER_RANK[userRank][1];
        System.out.printf("Rank %d %s: %,d to %,d standing%n", userRank, rankTitle, validStandingMin, validStandingMax);
        userStanding = Input.getUserInputInt("Enter your standing", validStandingMin, validStandingMax);
        Output.printSpace();
    }

    public void getResources() {
        if (!proceedToGetResourcesOrNot()) {
            Output.printSpace();
            return;
        }
        final int resourceMin = 0;
        final int resourceMax = Integer.MAX_VALUE;
        for (int index = 0; index < resourceRecords.length; index++) {
            final String inputPrompt = getResourcesInputPrompt(index);
            userResources[index] = Input.getUserInputInt(inputPrompt, resourceMin, resourceMax);
        }
        Output.printSpace();
    }

    private boolean proceedToGetResourcesOrNot() {
        if (userResources.length == 0) {
            return false;
        }
        return Input.getUserInputBoolean("Input standing resources");
    }

    private String getResourcesInputPrompt(int index) {
        final String resourceName = resourceRecords[index].resourceName();
        final int resourceStanding = resourceRecords[index].resourceStanding();
        return String.format("%s owned (%,d standing)", resourceName, resourceStanding);
    }

    public void buildCalculatorOutputHeader() {
        calculatorOutput.append(String.format("USER INFO%n"));
        calculatorOutput.append(String.format("Mastery Rank: %d%n", masteryRank));
        calculatorOutput.append(String.format("Daily Standing Cap: %,d%n", standingCap));
        calculatorOutput.append(String.format("%n"));
    }

    public void buildCalculatorOutputRank() {
        final int userRankMaxStanding = STANDING_PER_RANK[userRank][1];
        final int maxRank = rankRecords.length - 1;
        buildCalculatorOutputRankHeader();
        buildCalculatorOutputRankBody(userRankMaxStanding);
        if (!proceedToBuildCalculatorOutputRankOrNot(maxRank, userRankMaxStanding)) {
            calculatorOutput.append(String.format("%n"));
            return;
        }
        buildCalculatorOutputRankFooter(userRankMaxStanding, maxRank);
        calculatorOutput.append(String.format("%n"));
    }

    private void buildCalculatorOutputRankHeader() {
        calculatorOutput.append(String.format("%s%n", syndicateName.toUpperCase()));
    }

    private void buildCalculatorOutputRankBody(int userRankMaxStanding) {
        calculatorOutput.append(String.format("Rank: %d %s%n", userRank, rankRecords[userRank].rankTitle()));
        calculatorOutput.append(String.format("Standing: %,d out of %,d%n", userStanding, userRankMaxStanding));
    }

    private boolean proceedToBuildCalculatorOutputRankOrNot(int maxRank, int userRankMaxStanding) {
        if (isAlreadyMaxRank(maxRank)) {
            calculatorOutput.append(String.format("Already max rank.%n"));
            return false;
        } else if (isEligibleForMaxRank(maxRank, userRankMaxStanding)) {
            calculatorOutput.append(String.format("Eligible for max rank.%n"));
            return false;
        } else {
            return true;
        }
    }

    private boolean isAlreadyMaxRank(int maxRank) {
        return userRank == maxRank;
    }

    private boolean isEligibleForMaxRank(int maxRank, int userRankMaxStanding) {
        return userRank == maxRank - 1 && userStanding == userRankMaxStanding;
    }

    private void buildCalculatorOutputRankFooter(int userRankMaxStanding, int maxRank) {
        int daysToMaxRank = 0;
        int standingToMaxRank = userRankMaxStanding - userStanding;
        while(true) {
            if (userStanding < userRankMaxStanding) {
                userStanding += standingCap;
            } else {
                userRank += 1;
                if (userRank == maxRank) {
                    final String pluralizedDay = Output.pluralizeNoun(daysToMaxRank);
                    calculatorOutput.append(String.format("%,d day%s with %,d standing to max.%n", daysToMaxRank, pluralizedDay, standingToMaxRank));
                    return;
                }
                userStanding += standingCap - userRankMaxStanding;
                userRankMaxStanding = STANDING_PER_RANK[userRank][1];
                standingToMaxRank += userRankMaxStanding;
            }
            daysToMaxRank += 1;
        }
    }

    public void buildCalculatorOutputResources() {
        if (!proceedToBuildCalculatorOutputResourcesOrNot()) {
            return;
        }
        buildCalculatorOutputResourcesHeader();
        final int resourceStandingTotal = buildCalculatorOutputResourcesBody();
        buildCalculatorOutputResourcesFooter(resourceStandingTotal);
        calculatorOutput.append(String.format("%n"));
    }

    private boolean proceedToBuildCalculatorOutputResourcesOrNot() {
        return !(noSyndicateOrUserResource());
    }

    private boolean noSyndicateOrUserResource() {
        return IntStream.of(userResources).sum() == 0;
    }

    private void buildCalculatorOutputResourcesHeader() {
        calculatorOutput.append(String.format("STANDING RESOURCES%n"));
    }

    private int buildCalculatorOutputResourcesBody() {
        int resourceStandingTotal = 0;
        for (int index = 0; index < resourceRecords.length; index++) {
            final String resourceName = resourceRecords[index].resourceName();
            final int resourceOwned = userResources[index];
            final int resourceStanding = resourceRecords[index].resourceStanding() * resourceOwned;
            calculatorOutput.append(String.format("%s: %,d owned (%,d standing)%n", resourceName, resourceOwned, resourceStanding));
            resourceStandingTotal += resourceStanding;
        }
        return resourceStandingTotal;
    }

    private void buildCalculatorOutputResourcesFooter(int resourceStandingTotal) {
        final int days = resourceStandingTotal / standingCap;
        if (days > 1) {
            final String pluralizedDay = Output.pluralizeNoun(days);
            calculatorOutput.append(String.format("Total: %,d standing (%,d day%s)%n", resourceStandingTotal, days, pluralizedDay));
        } else {
            calculatorOutput.append(String.format("Total: %,d standing%n", resourceStandingTotal));
        }
    }

    public void buildCalculatorOutputSacrifices() {
        if (!proceedToBuildCalculatorOutputSacrificesOrNot()) {
            return;
        }
        final ArrayList<HashMap.Entry<String, Integer>> sacrificesList = listSacrifices();
        buildCalculatorOutputSacrificesHeader(sacrificesList);
        buildCalculatorOutputSacrificesBody(sacrificesList);
        calculatorOutput.append(String.format("%n"));
    }

    private boolean proceedToBuildCalculatorOutputSacrificesOrNot() {
        return !(noSyndicateSacrifices() || isAlreadyMaxRankSacrifices());
    }

    private boolean noSyndicateSacrifices() {
        return sacrificeRecords.length == 0;
    }

    private boolean isAlreadyMaxRankSacrifices() {
        return userRank == sacrificeRecords.length;
    }

    private ArrayList<HashMap.Entry<String, Integer>> listSacrifices() {
        HashMap<String, Integer> sacrificesMap = new HashMap<>();
        while(userRank < sacrificeRecords.length) {
            final int[] sacrificeAmountArray = sacrificeRecords[userRank].sacrificeAmount();
            final String[] sacrificeNameArray = sacrificeRecords[userRank].sacrificeName();
            for (int index = 0; index < sacrificeNameArray.length; index++) {
                int sacrificeAmount = sacrificeAmountArray[index];
                final String sacrificeName = sacrificeNameArray[index];
                if (sacrificesMap.containsKey(sacrificeName)) {
                    sacrificeAmount = sacrificesMap.get(sacrificeName) + sacrificeAmount;
                }
                sacrificesMap.put(sacrificeName, sacrificeAmount);
            }
            userRank++;
        }
        ArrayList<HashMap.Entry<String, Integer>> sacrificesList = new ArrayList<>(sacrificesMap.entrySet());
        sacrificesList.sort(Comparator.comparingInt(HashMap.Entry::getValue));
        return sacrificesList;
    }

    private void buildCalculatorOutputSacrificesHeader(ArrayList<HashMap.Entry<String, Integer>> sacrificesList) {
        final String pluralizedSacrifice = Output.pluralizeNoun(sacrificesList.size()).toUpperCase();
        calculatorOutput.append(String.format("REQUIRED SACRIFICE%s%n", pluralizedSacrifice));
    }

    private void buildCalculatorOutputSacrificesBody(ArrayList<HashMap.Entry<String, Integer>> sacrificesList) {
        for (HashMap.Entry<String, Integer> sacrificesMapEntry : sacrificesList) {
            final int sacrificeAmount = sacrificesMapEntry.getValue();
            final String sacrificeName = sacrificesMapEntry.getKey();
            final String pluralizedSacrificeName = Output.pluralizeNoun(sacrificeAmount);
            calculatorOutput.append(String.format("%,d %s%s%n", sacrificeAmount, sacrificeName, pluralizedSacrificeName));
        }
    }

}