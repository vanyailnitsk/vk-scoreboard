package com.vanyailnitsk.scoreboard.models;

public class GlobalRank {
    private int testRank;
    private int algorithmRank;
    private int cyberSecurityRank;

    public GlobalRank() {
    }

    public GlobalRank(int testRank, int algorithmRank, int cyberSecurityRank) {
        this.testRank = testRank;
        this.algorithmRank = algorithmRank;
        this.cyberSecurityRank = cyberSecurityRank;
    }

    public int getTestRank() {
        return testRank;
    }

    public void setTestRank(int testRank) {
        this.testRank = testRank;
    }

    public int getAlgorithmRank() {
        return algorithmRank;
    }

    public void setAlgorithmRank(int algorithmRank) {
        this.algorithmRank = algorithmRank;
    }

    public int getCyberSecurityRank() {
        return cyberSecurityRank;
    }

    public void setCyberSecurityRank(int cyberSecurityRank) {
        this.cyberSecurityRank = cyberSecurityRank;
    }
}
