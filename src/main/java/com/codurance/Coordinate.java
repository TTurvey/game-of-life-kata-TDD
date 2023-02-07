package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public List<Coordinate> getNeighboursList(Grid grid) {
        int lastIndex = grid.getSize() - 1;
        List<Coordinate> neighbours = new ArrayList<Coordinate>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > lastIndex || j > lastIndex || (i == x && j ==y)) {
                    continue;
                }
                neighbours.add(new Coordinate(i, j));
            }
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinate that = (Coordinate) obj;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

}
