package hu.nye.torpedo.service.util;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapUnWrapperUtilTest {

    MapUnWrapperUtil underTest = new MapUnWrapperUtil();
    public static final String INPUT = "0010\n1001\n1001\n0001\n";

    @Test
    public void testConvertStringToMapShouldReturnWithCorrectMap() {

        //given
        String[][] expected =  {
                {"0","0","1","0"},
                {"1","0","0","1"},
                {"1","0","0","1"},
                {"0","0","0","1"}
        };

        //when
        String[][] actual = underTest.convertStringToMap(INPUT);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual,expected));

    }

    @Test
    public void testConvertStringToShipMapShouldReturnWithCorrectShipMap() {

        //given
        boolean[][] expected = {
                {false,false,true,false},
                {true,false,false,true},
                {true,false,false,true},
                {false,false,false,true}
        };

        //when
        boolean[][] actual = underTest.convertStringToShipMap(INPUT);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual,expected));
    }
}
