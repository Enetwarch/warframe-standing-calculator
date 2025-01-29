package com.github.enetwarch.warframestandingcalculator.data;

public record Resource(String resourceName, int resourceStanding) {

    public Resource {
        if (resourceStanding < 0) {
            throw new IllegalArgumentException("Invalid resource standing.");
        }
    }

}