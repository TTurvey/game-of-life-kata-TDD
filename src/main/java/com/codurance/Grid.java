package com.codurance;

import java.util.Collections;

public class Grid {

    private String[][] state;

    public Grid(String[][] input) {
        this.state = input;
    }

    public String[][] getState() {
        return state;
    }

    public int getAliveCount() {
        int aliveCount = 0;

        for (String[] gridRow : getState()){
            for (String str : gridRow) {
                if (str.equals("ALIVE")){
                    aliveCount ++;
                }
            }
        }

        return aliveCount;
    }
}
