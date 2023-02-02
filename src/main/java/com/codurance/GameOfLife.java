package com.codurance;

public class GameOfLife {

    private boolean[][] board;

    public GameOfLife(boolean[][] board) {
        this.board = board;
    }

    public void nextGen() {
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean cellStateAt(int i, int i1) {
        return false;
    }
}
