package com.codurance;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(7);

//        Blinker pattern 1
        grid.putCell(LiveCell.INSTANCE, 0, 1);
        grid.putCell(LiveCell.INSTANCE, 1, 1);
        grid.putCell(LiveCell.INSTANCE, 2, 1);

//        Blinker pattern 2
        grid.putCell(LiveCell.INSTANCE, 1, 4);
        grid.putCell(LiveCell.INSTANCE, 1, 5);
        grid.putCell(LiveCell.INSTANCE, 1, 6);

//        Blinker pattern 3
        grid.putCell(LiveCell.INSTANCE, 4, 5);
        grid.putCell(LiveCell.INSTANCE, 5, 5);
        grid.putCell(LiveCell.INSTANCE, 6, 5);

//        Blinker pattern 4
        grid.putCell(LiveCell.INSTANCE, 5, 0);
        grid.putCell(LiveCell.INSTANCE, 5, 1);
        grid.putCell(LiveCell.INSTANCE, 5, 2);

        new GameOfLife(grid,4);
    }

}