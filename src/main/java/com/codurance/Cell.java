package com.codurance;

public interface Cell {

    boolean isAlive();

    Cell nextState(int liveNeighbours);

}