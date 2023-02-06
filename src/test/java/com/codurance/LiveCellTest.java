package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiveCellTest {

//    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
//    Any live cell with two or three live neighbours lives on to the next generation.
//    Any live cell with more than three live neighbours dies, as if by overpopulation.

    @Test
    public void should_be_alive() {
        assertTrue(LiveCell.INSTANCE.isAlive());
    }

    @Test
    public void should_die_by_underpopulation_when_one_live_neighbours() {
        Cell cell = LiveCell.INSTANCE.nextState(1);
        assertFalse(cell.isAlive());
    }

    @Test
    public void should_stay_alive_when_two_live_neighbours() {
        Cell cell = LiveCell.INSTANCE.nextState(2);
        assertTrue(cell.isAlive());
    }

    @Test
    public void should_stay_alive_when_three_live_neighbours() {
        Cell cell = LiveCell.INSTANCE.nextState(3);
        assertTrue(cell.isAlive());
    }

    @Test
    public void should_die_by_overpopulation_when_four_live_neighbours() {
        Cell cell = LiveCell.INSTANCE.nextState(4);
        assertFalse(cell.isAlive());
    }

}
