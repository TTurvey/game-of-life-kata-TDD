package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    public void should_have_state_ALIVE_when_alive() {
        Cell cell = new Cell("ALIVE");
        assertEquals("ALIVE", cell.getState());
    }

    @Test
    public void should_have_state_DEAD_when_dead() {
        Cell cell = new Cell("DEAD");
        assertEquals("DEAD", cell.getState());
    }

    @Test
    //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    public void should_be_DEAD_by_underpopulation_when_cell_has_less_than_two_alive_neighbours() {
        Cell cell = new Cell("ALIVE");
        int numberOfAliveNeighbours = 1;
        cell.setNextState(numberOfAliveNeighbours);
        assertEquals("DEAD", cell.getState());
    }


}