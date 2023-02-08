package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DeadCellTest {

//    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    private Cell dC;

    @BeforeEach
    public void setup() {
        dC = DeadCell.INSTANCE;
    }

    @Test
    public void should_be_dead() {
        assertFalse(dC.isAlive());
    }

    @DisplayName("Should stay dead when not exactly three live neighbours")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 4, 5, 6, 7, 8})
    public void should_stay_dead_when_not_exactly_three_live_neighbours(int liveNeighbours) {
        assertFalse(dC.nextState(liveNeighbours).isAlive());
    }

    @Test
    public void should_live_by_reproduction_when_three_live_neighbours() {
        assertTrue(dC.nextState(3).isAlive());
    }

}
