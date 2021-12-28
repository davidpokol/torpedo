package hu.nye.torpedo.service.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapUtilTest {

    MapUtil underTest = new MapUtil();
    public static final int MAP_SIZE = 4;
    public static final int BAD_MAP_SIZE = 15;

    @Test
    public void testGetMapShouldReturnAStringMapFilledUpWithOnlyZeroValues() {

        //given
        String [][] expected = {
                {"0","0","0","0"},
                {"0","0","0","0"},
                {"0","0","0","0"},
                {"0","0","0","0"}
        };

        //when
        String[][] actual = underTest.getMap(MAP_SIZE);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));

    }
    @Test
    public void testGetShipMapShouldReturnABooleanMapFilledUpWithOnlyZeroValues() {

        //given
        boolean [][] expected = {
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}
        };

        //when
        boolean[][] actual = underTest.getShipMap(MAP_SIZE);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void testGetShipMapShouldReturnEmptyTwoDimensionalArrayInCaseOfBadInput() {

        //given
        boolean [][] expected = new boolean[BAD_MAP_SIZE][BAD_MAP_SIZE];

        //when
        boolean[][] actual = underTest.getShipMap(BAD_MAP_SIZE);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void testGetRowOfMapShouldReturnALineFromAMap() {

        //Given
        String[][] map = {
                {"0","0","0","0"},
                {"0","0","0","0"},
                {"1","0","1","0"},
                {"0 ","0","0","0"}
        };

        List<String> expected =  List.of("1","0","1","0");

        //When
        List<String> actual = underTest.getRowOfMap(map, 2);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRowOfShipMapShouldReturnALineFromAShipMap() {

        //Given
        boolean[][] shipMap = {
                {false,false,false,false},
                {false,false,false,false},
                {true,false,true,true},
                {false,false,false,false}
        };

        List<Boolean> expected =  List.of(true,false,true,true);

        //When
        List<Boolean> actual = underTest.getRowOfShipMap(shipMap, 2);

        //Then
        Assertions.assertEquals(expected, actual);
    }

}
