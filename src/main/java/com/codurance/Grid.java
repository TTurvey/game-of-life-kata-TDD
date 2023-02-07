package com.codurance;

import java.util.Arrays;
import java.util.List;

public class Grid {

    private final Cell[][] cells;
    private final int dimension;

    public Grid(int dimension) {
        this.dimension = dimension;
        cells = new Cell[dimension][dimension];

        for (Cell[] row : cells) {
            Arrays.fill(row, DeadCell.INSTANCE);
        }
    }

    public void putCell(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    public int getAliveCount(){
        int aliveCount = 0;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    aliveCount++;
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
        for (Coordinate coordinate : coordinates) {
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
        StringBuffer strBuffer = new StringBuffer();

        String horizontalBorder = " " + "---".repeat(dimension);
        strBuffer.append(horizontalBorder);
        strBuffer.append("\n");

        for (Cell[] row : cells) {
            strBuffer.append("|");
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    strBuffer.append(" X ");
                } else {
                    strBuffer.append(" . ");
                }
            }
            strBuffer.append("|\n");
        }
        strBuffer.append(horizontalBorder).append("\n");
        return strBuffer.toString();
    }

}
