package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void should_have_an_initial_state() {
        String[][] input = new String[][]{
                {"DEAD", "DEAD", "DEAD"},
                {"DEAD", "ALIVE", "DEAD"},
                {"DEAD", "DEAD", "DEAD"}
        };
        Grid grid = new Grid(input);
        String[][] state = grid.getState();
        assertArrayEquals(input, state);
    }

    @Test
    public void should_count_ALIVE_cells() {
        String[][] input = new String[][]{
                {"DEAD", "DEAD", "DEAD"},
                {"DEAD", "ALIVE", "DEAD"},
                {"DEAD", "DEAD", "DEAD"}
        };
        Grid grid = new Grid(input);
        int expectedNumberOfAliveCells = 1;
        int actualAliveCells = grid.getAliveCount();
        assertEquals(expectedNumberOfAliveCells, actualAliveCells);
    }

}