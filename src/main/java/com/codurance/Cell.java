package com.codurance;

public class Cell {

    private String state;

    public Cell(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setNextState(int numberOfAliveNeighbours){
        if (numberOfAliveNeighbours < 2) {
            state = "DEAD";
        }
        if (numberOfAliveNeighbours > 3) {
            state = "DEAD";
        }
        if (numberOfAliveNeighbours == 3 && state == "DEAD") {
            state = "ALIVE";
        }
    }
}

