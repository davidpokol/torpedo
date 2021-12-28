package hu.nye.torpedo.service.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapToStringUtilTest {

    private static final String[][] MAP = new String[][] {
            {"0","0","1","0"},
            {"1","0","0","1"},
            {"1","0","0","1"},
            {"0","0","0","1"}
    };

    private static final boolean[][] SHIP_MAP = new boolean[][] {
            {false,false,true,false},
            {true,false,false,true},
            {true,false,false,true},
            {false,false,false,true}
    };

    MapUtil mapUtil = new MapUtil();
    MapToStringUtil underTest = new MapToStringUtil(mapUtil);

    @Test
    public void testConvertMapToStringShouldReturnWithCorrectString() {

        // Given
        String expected = "0010\n1001\n1001\n0001\n";

        // When
        String actual = underTest.convertMapToString(MAP);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testConvertShipMapToStringShouldReturnWithCorrectString() {

        // Given
        String expected = "0010\n1001\n1001\n0001\n";

        // When
        String actual = underTest.convertShipMapToString(SHIP_MAP);

        // Then
        Assertions.assertEquals(expected, actual);
    }
}
