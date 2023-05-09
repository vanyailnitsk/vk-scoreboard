package com.vanyailnitsk.scoreboard.models;

public class GlobalRank {
    private int testRank;
    private int algorithmRank;

    public GlobalRank() {
    }

    public GlobalRank(int testRank, int algorithmRank) {
        this.testRank = testRank;
        this.algorithmRank = algorithmRank;
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
}
