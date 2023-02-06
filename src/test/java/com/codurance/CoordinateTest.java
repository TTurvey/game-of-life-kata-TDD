package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    public void should_get_neighbouring_coordinates_when_first_coordinate() {
        List<Coordinate> coordinates = new Coordinate(0, 0).getNeighboursList(new Grid(10));
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(0, 1),
                new Coordinate(1, 0),
                new Coordinate(1, 1)
        );

        for (Coordinate c : coordinates) {
            System.out.println("" + c.getX() + ", " + c.getY());
        }

        assertEquals(expected, coordinates);
    }

    @Test
    public void should_get_neighbouring_coordinates_when_last_coordinate_in_first_row() {
        List<Coordinate> coordinates = new Coordinate(0, 9).getNeighboursList(new Grid(10));
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(0, 8),
                new Coordinate(1, 8),
                new Coordinate(1, 9)
        );

        assertEquals(expected, coordinates);
    }

    @Test
    public void should_get_neighbouring_coordinates_when_last_coordinate_in_grid() {
        List<Coordinate> coordinates = new Coordinate(9, 9).getNeighboursList(new Grid(10));
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(8, 8),
                new Coordinate(8, 9),
                new Coordinate(9, 8)
        );

        assertEquals(expected, coordinates);
    }


}