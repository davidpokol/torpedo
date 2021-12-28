package hu.nye.torpedo.service.util;

import hu.nye.torpedo.model.MapVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointValidatorUtilTest {

    PointValidatorUtil underTest = new PointValidatorUtil();
    private static final String[][] MAP = new String[][] {
            {"0","0","x","0"},
            {"-","0","0","x"},
            {"-","0","0","x"},
            {"0","0","0","x"}
    };
    public static final MapVO MAPVO = new MapVO(MAP, null);

    @Test
    public void testIsContinueShouldReturnTrueWhenTheInputCoordinateExistingAndUntouched() {

        //Given
        int[] coordinate = {0, 0};

        //When
        boolean actual = underTest.isContinue(coordinate, MAPVO);

        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testIsContinueShouldReturnFalseWhenTheInputCoordinateIsNotExisting() {

        //Given
        int[] coordinate = {-1, -1};

        //When
        boolean actual = underTest.isContinue(coordinate, MAPVO);

        //Then
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsContinueShouldReturnFalseWhenTheInputCoordinateIsAlreadyShot() {

        //Given
        int[] coordinate = {0, 2};

        //When
        boolean actual = underTest.isContinue(coordinate, MAPVO);

        //Then
        Assertions.assertFalse(actual);
    }
}
