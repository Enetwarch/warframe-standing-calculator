package com.github.enetwarch.warframestandingcalculator.output;
import com.github.enetwarch.warframestandingcalculator.data.Sacrifice;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import com.github.enetwarch.warframestandingcalculator.util.Output;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;

public class OutputSacrifices {

    private final Sacrifice[] sacrificeRecords;
    private int userRank;

    public OutputSacrifices(Sacrifice[] sacrificeRecords, int userRank) {
        this.sacrificeRecords = sacrificeRecords;
        this.userRank = userRank;
    }

    private boolean proceedOrNot() {
        final boolean noSacrifices = sacrificeRecords.length == 0;
        final boolean isAlreadyMax = userRank == sacrificeRecords.length;
        return !(noSacrifices || isAlreadyMax);
    }

    private List<Map.Entry<String, Integer>> listSacrifices() {
        Map<String, Integer> sacrificesMap = new HashMap<>();
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
        List<Map.Entry<String, Integer>> sacrificesList = new ArrayList<>(sacrificesMap.entrySet());
        sacrificesList.sort(Comparator.comparingInt(Map.Entry::getValue));
        return sacrificesList;
    }

    private void buildHeader(List<Map.Entry<String, Integer>> sacrificesList) {
        final String pluralizedSacrifice = Output.pluralizeNoun(sacrificesList.size()).toUpperCase();
        Calculator.calculatorOutput.append(String.format("REQUIRED SACRIFICE%s%n", pluralizedSacrifice));

    }

    private void buildBody(List<Map.Entry<String, Integer>> sacrificesList) {
        for (Map.Entry<String, Integer> sacrificesMapEntry : sacrificesList) {
            final int sacrificeAmount = sacrificesMapEntry.getValue();
            final String sacrificeName = sacrificesMapEntry.getKey();
            final String pluralizedSacrificeName = Output.pluralizeNoun(sacrificeAmount);
            Calculator.calculatorOutput.append(String.format("%,d %s%s%n", sacrificeAmount, sacrificeName, pluralizedSacrificeName));
        }
    }

    public void buildOutputSacrifices() {
        if (!proceedOrNot()) {
            return;
        }
        final List<Map.Entry<String, Integer>> sacrificesList = listSacrifices();
        buildHeader(sacrificesList);
        buildBody(sacrificesList);
        Calculator.calculatorOutput.append(String.format("%n"));
    }

}