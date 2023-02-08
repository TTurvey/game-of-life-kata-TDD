package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LiveCellTest {

//    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
//    Any live cell with two or three live neighbours lives on to the next generation.
//    Any live cell with more than three live neighbours dies, as if by overpopulation.

    private Cell lC;

    @BeforeEach
    public void setup() {
        lC = LiveCell.INSTANCE;
    }

    @Test
    public void should_be_alive() {
        assertTrue(lC.isAlive());
    }

    @Test
    public void should_die_by_underpopulation_when_one_live_neighbours() {
        assertFalse(lC.nextState(1).isAlive());
    }

    @DisplayName("Should stay alive when two or three live neighbours")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    public void should_stay_alive_when_two_or_three_live_neighbours(int liveNeighbours) {
        assertTrue(lC.nextState(liveNeighbours).isAlive());
    }

    @DisplayName("Should die by overpopulation when more than three live neighbours")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    public void should_die_by_overpopulation_when_more_than_three_live_neighbours(int liveNeighbours) {
        assertFalse(lC.nextState(liveNeighbours).isAlive());
    }
}
