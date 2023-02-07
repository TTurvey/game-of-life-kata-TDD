package com.codurance;

import java.util.Arrays;
import java.util.List;

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

    public Grid nextGen() {
        Grid nextGenGrid = new Grid(cells.length);

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                Cell cell = cells[x][y];
                List<Coordinate> neighbours = new Coordinate(x, y).getNeighboursList(this);
                int aliveNeighbours = getAliveCountFor(neighbours);
                Cell nextGenCell = cell.nextState(aliveNeighbours);
                nextGenGrid.putCell(nextGenCell, x, y);
            }
        }
        return nextGenGrid;
    }

    public int getAliveCountFor(List<Coordinate> coordinates){
        int aliveCount = 0;
        for ( Coordinate coordinate : coordinates) {
            if(cells[coordinate.getX()][coordinate.getY()].isAlive()){
                aliveCount ++;
            }
        }
        return aliveCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Grid grid = (Grid) obj;
        return Arrays.deepEquals(this.cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    stringBuffer.append(" + ");
                } else {
                    stringBuffer.append(" - ");
                }
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

}
