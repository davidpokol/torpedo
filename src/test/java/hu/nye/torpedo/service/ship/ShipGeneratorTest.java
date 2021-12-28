package hu.nye.torpedo.service.ship;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShipGeneratorTest {

    private final ShipGenerator underTest = new ShipGenerator();
    private final static int MAP_SIZE = 5;

    @Test
    public void testGetShipShouldReturnATwoDimensionalArrayInTheRightScope() {

        //Given
        int length = 4;

        //When
        int[][] actual = underTest.getShip(length, MAP_SIZE);

        //Then
        Assertions.assertTrue(Arrays.stream(actual).flatMapToInt(Arrays::stream).allMatch(a -> a < length));

    }

    @Test
    public void testGetShipShouldReturnAPointWhenLengthIsOne() {
        //Given
        int length = 1;

        //When
        int[][] actual = underTest.getShip(length, MAP_SIZE);

        //Then
        Assertions.assertEquals(actual[0][0], actual[1][0]);
        Assertions.assertEquals(actual[0][1], actual[1][1]);
    }
}
