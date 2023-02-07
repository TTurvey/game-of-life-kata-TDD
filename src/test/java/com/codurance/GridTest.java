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
    public void initialize_with_dead_cells() {
        Grid grid = new Grid(10);
        assertEquals(0, grid.getAliveCount());
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
    public void should_get_next_generation_with_all_dead_cells() {
        Grid grid = new Grid(3);
        Grid grid2 = grid.nextGen();
        Grid expectedGrid = new Grid(3);

        assertEquals(expectedGrid, grid2);
    }

    @Test
    public void should_get_next_generation_with_all_live_cells() {
        Grid grid = new Grid(3);
        grid.putCell(LiveCell.INSTANCE, 0, 0);
        grid.putCell(LiveCell.INSTANCE, 0, 1);
        grid.putCell(LiveCell.INSTANCE, 0, 2);
        grid.putCell(LiveCell.INSTANCE, 1, 0);
        grid.putCell(LiveCell.INSTANCE, 1, 1);
        grid.putCell(LiveCell.INSTANCE, 1, 2);
        grid.putCell(LiveCell.INSTANCE, 2, 0);
        grid.putCell(LiveCell.INSTANCE, 2, 1);
        grid.putCell(LiveCell.INSTANCE, 2, 2);

        Grid nextGenGrid = grid.nextGen();

        Grid expectedGrid = new Grid(3);
        expectedGrid.putCell(LiveCell.INSTANCE, 0, 0);
        expectedGrid.putCell(LiveCell.INSTANCE, 2, 0);
        expectedGrid.putCell(LiveCell.INSTANCE, 0, 2);
        expectedGrid.putCell(LiveCell.INSTANCE, 2, 2);

        System.out.println(grid);
        System.out.println(expectedGrid);
        System.out.println(nextGenGrid);

        assertEquals(expectedGrid, nextGenGrid);
    }

}
