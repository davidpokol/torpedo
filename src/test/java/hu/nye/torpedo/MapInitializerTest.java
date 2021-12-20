package hu.nye.torpedo;


import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hu.nye.torpedo.service.util.MapUtil;
import hu.nye.torpedo.service.exeption.FileReadException;


public class MapInitializerTest {

    private MapUtil underTest = new MapUtil();

    @Test
    public void testGetMapShouldReturnWithATwoDimensionalArrayFilledUpWithOnlyZeroValues() throws FileReadException {

        //Given
        String[][] expected = {{"0","0"},{"0","0"}};
        int input = 2;

        //When
        String[][] result = underTest.getMap(input);
        boolean isTheSameContent = Arrays.deepEquals(result,expected);

        //Then
        Assertions.assertTrue(isTheSameContent);
    }
}
