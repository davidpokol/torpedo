package hu.nye.progtech.sodoku.service;


import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sevice.MapInitializer;
import sevice.exeption.MapReadException;


public class MapInitializerTest {

    private MapInitializer underTest = new MapInitializer();

    @Test
    public void testGetMapShouldReturnWithATwoDimensionalArrayFilledUpWithOnlyZeroValues() throws MapReadException {

        //Given
        int[][] expected = {{0,0},{0,0}};
        int input = 2;

        //When
        int[][] result = underTest.getMap(input);
        boolean isTheSameContent = Arrays.deepEquals(result,expected);

        //Then
        Assertions.assertTrue(isTheSameContent);
    }
    @Test
    public void testGetMapShouldReturnWithNullWhenTheInputIsGreaterThanNine() {

        //Given
        boolean thrown = false;
        int[][] result = null;

        //When
        try {
            result = underTest.getMap(10);
        } catch (MapReadException e) {
            thrown = true;
        }

        //Then
        Assertions.assertTrue(thrown);
        Assertions.assertNull(result);
    }
}
