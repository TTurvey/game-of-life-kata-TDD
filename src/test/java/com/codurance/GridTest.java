package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private Grid inputGrid;
    private Grid expectedGrid;

    @BeforeEach
    public void setup() {
        inputGrid = new Grid(3);
        expectedGrid = new Grid(3);
    }

    @Test
    public void initialize_with_input_size() {
        assertEquals(3, inputGrid.getSize());
    }

    @Test
    public void initialize_with_dead_cells() {
        assertEquals(0, inputGrid.getAliveCount());
    }

    @Test
    public void should_count_live_cells(){
        inputGrid.putCell(LiveCell.INSTANCE, 0, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 0, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 0, 2);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 2);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 2);

        assertEquals(9, inputGrid.getAliveCount());
    }

    @Test
    public void should_get_next_generation_with_all_dead_cells() {
        assertEquals(expectedGrid, inputGrid.nextGen());
    }

    @Test
    public void should_get_next_generation_with_all_live_cells() {
        inputGrid.putCell(LiveCell.INSTANCE, 0, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 0, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 0, 2);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 2);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 2, 2);

        Grid gridGen1 = inputGrid.nextGen();

        expectedGrid.putCell(LiveCell.INSTANCE, 0, 0);
        expectedGrid.putCell(LiveCell.INSTANCE, 2, 0);
        expectedGrid.putCell(LiveCell.INSTANCE, 0, 2);
        expectedGrid.putCell(LiveCell.INSTANCE, 2, 2);

        assertEquals(expectedGrid, gridGen1);
    }

    @Test
    public void should_get_next_gen_with_special_case_blinker()  {
        inputGrid.putCell(LiveCell.INSTANCE, 1, 0);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 1);
        inputGrid.putCell(LiveCell.INSTANCE, 1, 2);

        Grid gridGen1 = inputGrid.nextGen();

        expectedGrid.putCell(LiveCell.INSTANCE, 0, 1);
        expectedGrid.putCell(LiveCell.INSTANCE, 1, 1);
        expectedGrid.putCell(LiveCell.INSTANCE, 2, 1);

        Grid gridGen2 = gridGen1.nextGen();

        assertEquals(expectedGrid, gridGen1);
        assertEquals(inputGrid, gridGen2);
    }

}
