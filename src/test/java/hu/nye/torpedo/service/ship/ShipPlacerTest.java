package hu.nye.torpedo.service.ship;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShipPlacerTest {

    ShipPlacer underTest = new ShipPlacer();

    public static final int[][] VERTICAL_SHIP = {{0,0},{2,0}};
    public static final int[][] HORIZONTAL_SHIP = {{0,0},{0,2}};

    @Test
    public void testPlaceShouldReturnAMapWithVerticalShip() {

        //Given
        boolean[][] map = {{false, false, false},
                           {false, false, false},
                           {false, false, false}};

        boolean[][] expected = {{true, false, false},
                                {true, false, false},
                                {true, false, false}};

        //When
        boolean[][] actual = underTest.place(VERTICAL_SHIP, map);

        //Then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void testPlaceShouldReturnAMapWithHorizontalShip() {

        //Given
        boolean[][] map = {{false, false, false},
                           {false, false, false},
                           {false, false, false}};

        boolean[][] expected = {{true, true, true},
                                {false, false, false},
                                {false, false, false}};

        //When
        boolean[][] actual = underTest.place(HORIZONTAL_SHIP, map);

        //Then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
}
