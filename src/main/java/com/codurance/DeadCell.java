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

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        DeadCell cell = (DeadCell) obj;
        return isAlive() == cell.isAlive();
    }
}
