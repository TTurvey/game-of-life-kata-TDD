package com.codurance;

public class Grid {

    private String[][] state;

    public Grid(String[][] input) {
        this.state = input;
    }

    public String[][] getState() {
        return state;
    }

    public int getAliveCount() {
        return 1;
    }
}
