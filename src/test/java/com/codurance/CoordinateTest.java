package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    private Grid inputGrid;

    @BeforeEach
    public void setup() {
        inputGrid = new Grid(3);
    }

    @DisplayName("Should get neighbouring coordinates of a corner coordinate")
    @ParameterizedTest
    @CsvSource({
//            Top left corner
            "0, 0, 0, 1, 1, 0, 1, 1",
//            Top right corner
            "0, 2, 0, 1, 1, 1, 1, 2",
//            Bottom left corner
            "2, 0, 1, 0, 1, 1, 2, 1",
//            Bottom right corner
            "2, 2, 1, 1, 1, 2, 2, 1"
    })
    public void should_get_neighbouring_coordinates_of_corners(int inputX, int inputY, int n1X, int n1Y, int n2X, int n2Y, int n3X, int n3Y) {

        List<Coordinate> coordinates = new Coordinate(inputX, inputY).getNeighboursList(inputGrid);

        List<Coordinate> expected = Arrays.asList(
                new Coordinate(n1X, n1Y),
                new Coordinate(n2X, n2Y),
                new Coordinate(n3X, n3Y));

        assertEquals(expected, coordinates);
    }


    @DisplayName("Should get neighbouring coordinates of a middle edge coordinate")
    @ParameterizedTest
    @CsvSource({
//            Top middle
            "0, 1, 0, 0, 0, 2, 1, 0, 1, 1, 1, 2",
//            Left middle
            "1, 0, 0, 0, 0, 1, 1, 1, 2, 0, 2, 1",
//            Right middle
            "1, 2, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2",
//            Bottom middle
            "2, 1, 1, 0, 1, 1, 1, 2, 2, 0, 2, 2"
    })
    public void should_get_neighbouring_coordinates_of_middle_edges(int inputX, int inputY, int n1X, int n1Y, int n2X, int n2Y, int n3X, int n3Y, int n4X, int n4Y, int n5X, int n5Y) {

        List<Coordinate> coordinates = new Coordinate(inputX, inputY).getNeighboursList(inputGrid);

        List<Coordinate> expected = Arrays.asList(
                new Coordinate(n1X, n1Y),
                new Coordinate(n2X, n2Y),
                new Coordinate(n3X, n3Y),
                new Coordinate(n4X, n4Y),
                new Coordinate(n5X, n5Y));

        assertEquals(expected, coordinates);
    }

    @Test
    public void should_get_neighbouring_coordinates_of_a_middle_coordinate() {
        List<Coordinate> coordinates = new Coordinate(1, 1).getNeighboursList(inputGrid);
        List<Coordinate> expected = Arrays.asList(
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(1, 0),
                new Coordinate(1, 2),
                new Coordinate(2, 0),
                new Coordinate(2, 1),
                new Coordinate(2, 2));

        assertEquals(expected, coordinates);
    }

}