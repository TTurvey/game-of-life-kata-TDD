package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        String[][] inputA = new String[][]{
                {"DEAD", "DEAD"},
                {"DEAD", "DEAD"}
        };
        String[][] inputB = new String[][]{
                {"ALIVE", "ALIVE"},
                {"ALIVE", "ALIVE"}
        };

        Grid gridA = new Grid(inputA);
        Grid gridB = new Grid(inputB);
        int expectedAliveCellsA = 0;
        int expectedAliveCellsB = 4;
        int actualAliveCellsA = gridA.getAliveCount();
        int actualAliveCellsB = gridB.getAliveCount();

        assertEquals(expectedAliveCellsA, actualAliveCellsA);
        assertEquals(expectedAliveCellsB, actualAliveCellsB);

    }
}