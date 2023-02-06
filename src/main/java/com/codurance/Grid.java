package com.codurance;

public class Grid {

    private Cell[][] cells;

    public Grid(int i) {
        cells = new LiveCell[i][i];
    }

    public void putCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    public int getAliveCount() {
        int aliveCount = 0;

//        for (String[] gridRow : getState()){
//            for (String str : gridRow) {
//                if (str.equals("ALIVE")){
//                    aliveCount ++;
//                }
//            }
//        }

        return aliveCount;
    }


    public int a(){
        int size = 0;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    size++;
                }
            }
        }
        return size;
    }

    public int getSize(){
        return cells.length;
    }
}
