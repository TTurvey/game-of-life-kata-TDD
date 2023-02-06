package com.codurance;

public class LiveCell implements Cell {

    public static final Cell INSTANCE = new LiveCell();

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public Cell nextState(int aliveNeighbours) {
        if (aliveNeighbours < 2) {
            return new DeadCell();
        }
        if (aliveNeighbours > 3) {
            return new DeadCell();
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        LiveCell cell = (LiveCell) obj;
        return isAlive() == cell.isAlive();
    }
}

