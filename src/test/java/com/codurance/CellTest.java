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


    //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    @Test
    public void should_be_DEAD_by_underpopulation_when_cell_has_less_than_two_ALIVE_neighbours() {
        Cell cell = new Cell("ALIVE");
        int numberOfAliveNeighbours = 1;
        cell.setNextState(numberOfAliveNeighbours);
        assertEquals("DEAD", cell.getState());
    }

    @Test
    public void should_stay_ALIVE_when_cell_has_two_ALIVE_neighbours() {
        Cell cell = new Cell("ALIVE");
        int numberOfAliveNeighbours = 2;
        cell.setNextState(numberOfAliveNeighbours);
        assertEquals("ALIVE", cell.getState());
    }

    @Test
    public void should_stay_ALIVE_when_cell_has_more_than_two_ALIVE_neighbours() {
        Cell cell = new Cell("ALIVE");
        int numberOfAliveNeighbours = 3;
        cell.setNextState(numberOfAliveNeighbours);
        assertEquals("ALIVE", cell.getState());
    }

}