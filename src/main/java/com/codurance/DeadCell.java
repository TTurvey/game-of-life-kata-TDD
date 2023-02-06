package com.codurance;

public class DeadCell implements Cell {

    public static final Cell INSTANCE = new DeadCell();

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public Cell nextState(int aliveNeighbours) {
        if (aliveNeighbours == 3) {
            return new LiveCell();
        }
        return this;
    }
}
