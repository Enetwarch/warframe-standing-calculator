package com.github.enetwarch.warframestandingcalculator.output;
import com.github.enetwarch.warframestandingcalculator.data.Resource;
import com.github.enetwarch.warframestandingcalculator.calc.Calculator;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class OutputResources {

    private final Resource[] resourceRecords;
    private final int[] userResources;
    private final int standingCap;

    public OutputResources(Resource[] resourceRecords, int[] userResources, int standingCap) {
        this.resourceRecords = resourceRecords;
        this.userResources = userResources;
        this.standingCap = standingCap;
    }

    private boolean proceedOrNot() {
        final boolean noResource = userResources == null;
        return !(noResource);
    }

    private void buildHeader() {
        Calculator.calculatorOutput.append(String.format("STANDING RESOURCES%n"));

    }

    private int buildBody() {
        int resourceStandingTotal = 0;
        for (int index = 0; index < resourceRecords.length; index++) {
            final String resourceName = resourceRecords[index].resourceName();
            final int resourceOwned = userResources[index];
            final int resourceStanding = resourceRecords[index].resourceStanding() * resourceOwned;
            Calculator.calculatorOutput.append(String.format("%s: %,d owned (%,d standing)%n", resourceName, resourceOwned, resourceStanding));
            resourceStandingTotal += resourceStanding;
        }
        return resourceStandingTotal;
    }

    private void buildFooter(int resourceStandingTotal) {
        final int days = resourceStandingTotal / standingCap;
        if (days > 1) {
            final String pluralizedDay = Output.pluralizeNoun(days);
            Calculator.calculatorOutput.append(String.format("Total: %,d standing (%,d day%s)%n", resourceStandingTotal, days, pluralizedDay));
        } else {
            Calculator.calculatorOutput.append(String.format("Total: %,d standing%n", resourceStandingTotal));
        }
    }

    public void buildOutputResources() {
        if (!proceedOrNot()) {
            return;
        }
        buildHeader();
        final int resourceStandingTotal = buildBody();
        buildFooter(resourceStandingTotal);
        Calculator.calculatorOutput.append(String.format("%n"));
    }

}