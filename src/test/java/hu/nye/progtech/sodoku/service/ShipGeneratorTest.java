package hu.nye.progtech.sodoku.service;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sevice.ShipGenerator;

public class ShipGeneratorTest {

    private final ShipGenerator underTest = new ShipGenerator();
    private final static int LENGTH = 5;

    @Test
    public void testGetShipShouldReturnATwoDimensionalArrayInTheRightScope(){

        //Given
        int[][] result = underTest.getShip(LENGTH);

        //When
        boolean expected = Arrays.stream(result).flatMapToInt(Arrays::stream).allMatch(a->a<LENGTH);

        //Then
        Assertions.assertTrue(expected);

    }
}
