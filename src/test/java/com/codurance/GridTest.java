package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void initialize_with__input_size() {
        Grid grid = new Grid(10);
        assertEquals(grid.getSize(), 10);
    }

}
