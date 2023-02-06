package com.codurance;

public class Grid {

    private Cell[][] cells;

    public Grid(int i) {
        cells = new Cell[i][i];
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = DeadCell.INSTANCE;
            }
        }
    }

    public void putCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    public int getAliveCount(){
        int aliveCount = 0;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    aliveCount ++;
                }
            }
        }
        return aliveCount;
    }

    public int getSize(){
        return cells.length;
    }
}
