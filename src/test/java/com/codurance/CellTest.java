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
}