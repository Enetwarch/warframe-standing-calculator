package com.github.enetwarch.warframestandingcalculator.data;

public enum Syndicate {

    CONCLAVE("Conclave"),
    OSTRON("Ostron"),
    THE_QUILLS("The Quills"),
    SOLARIS_UNITED("Solaris United"),
    VOX_SOLARIS("Vox Solaris"),
    VENTKIDS("Ventkids"),
    ENTRATI("Entrati"),
    NECRALOID("Necraloid"),
    THE_HOLDFASTS("The Holdfasts"),
    CAVIA("Cavia"),
    THE_HEX("The Hex");

    private final String syndicateName;

    private Syndicate(String syndicateName) {
        this.syndicateName = syndicateName;
    }

    public String getSyndicate() {
        return syndicateName;
    }

}