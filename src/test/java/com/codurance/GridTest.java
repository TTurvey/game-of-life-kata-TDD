package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void initialize_with_input_size() {
        Grid grid = new Grid(10);
        assertEquals(10, grid.getSize());
    }

    @Test
    public void should_count_live_cells(){
        Grid grid = new Grid(2);
        grid.putCell(LiveCell.INSTANCE, 0, 0);
        grid.putCell(LiveCell.INSTANCE, 0, 1);
        grid.putCell(LiveCell.INSTANCE, 1, 0);
        grid.putCell(LiveCell.INSTANCE, 1, 1);
        assertEquals(4, grid.getAliveCount());
    }

    @Test
    public void should_dead_cells(){
        Grid grid = new Grid(2);
        grid.putCell(DeadCell.INSTANCE, 0, 0);
        grid.putCell(DeadCell.INSTANCE, 0, 1);
        grid.putCell(DeadCell.INSTANCE, 1, 0);
        grid.putCell(DeadCell.INSTANCE, 1, 1);
        assertEquals(0, grid.getAliveCount());
    }

}
