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


}