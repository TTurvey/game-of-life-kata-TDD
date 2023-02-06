package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadCellTest {

//    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    @Test
    public void should_be_dead() {
        assertFalse(DeadCell.INSTANCE.isAlive());
    }

    @Test
    public void should_stay_dead_when_cell_has_two_alive_neighbours() {
        Cell cell = DeadCell.INSTANCE.nextState(2);
        assertFalse(cell.isAlive());
    }

    @Test
    public void should_live_by_reproduction_when_three_live_neighbours() {
        Cell cell = DeadCell.INSTANCE.nextState(3);
        assertTrue(cell.isAlive());
    }

    @Test
    public void should_stay_dead_when_cell_has_four_alive_neighbours() {
        Cell cell = DeadCell.INSTANCE.nextState(4);
        assertFalse(cell.isAlive());
    }

}
