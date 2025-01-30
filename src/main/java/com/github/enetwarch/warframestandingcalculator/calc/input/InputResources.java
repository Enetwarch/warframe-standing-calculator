package com.github.enetwarch.warframestandingcalculator.calc.input;
import com.github.enetwarch.warframestandingcalculator.data.Resource;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class InputResources {

    private final Resource[] resourceRecords;

    public InputResources(Resource[] resourceRecords) {
        this.resourceRecords = resourceRecords;
    }

    private boolean proceedOrNot(int[] userResource) {
        if (userResource.length == 0) {
            return false;
        }
        return Input.getUserInputBoolean("Input standing resources");
    }

    private String getMessage(int index) {
        final String resourceName = resourceRecords[index].resourceName();
        final int resourceStanding = resourceRecords[index].resourceStanding();
        return String.format("%s owned (%,d standing)", resourceName, resourceStanding);
    }

    public int[] getResources() {
        int[] userResource = new int[resourceRecords.length];
        if (!proceedOrNot(userResource)) {
            Output.printSpace();
            return null;
        }
        final int resourceMin = 0;
        final int resourceMax = Integer.MAX_VALUE;
        for (int index = 0; index < resourceRecords.length; index++) {
            final String message = getMessage(index);
            userResource[index] = Input.getUserInputInt(message, resourceMin, resourceMax);
        }
        Output.printSpace();
        return userResource;
    }

}