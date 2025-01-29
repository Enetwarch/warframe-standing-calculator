package com.github.enetwarch.warframestandingcalculator.input;
import com.github.enetwarch.warframestandingcalculator.util.Input;
import com.github.enetwarch.warframestandingcalculator.util.Output;

public class InputUser {

    public static int getMasteryRank() {
        final int masteryRankMin = 0;
        final int masteryRankMax = 34;
        int userInput = Input.getUserInputInt("Enter your mastery rank", masteryRankMin, masteryRankMax);
        Output.printSpace();
        return userInput;
    }

}