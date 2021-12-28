package hu.nye.torpedo.service.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShipReferenceUtilTest {

    private final ShipReferenceUtil underTest = new ShipReferenceUtil();

    @Test
    public void testFormatOptionShouldReturnTheProperCoordinateInStringWhenTheFirstCharacterInInputIsLowerCase() {

        //Given
        String input = "d1";
        int[] expected = {3, 0};

        //When
        int[] actual = underTest.formatOption(input);

        //Then
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFormatOptionShouldReturnNullWhenOptionReadExceptionOccurs() {

        //Given
        String badInput = "11";
        int[] expected = {-1, -1};

        //When
        int[] actual = underTest.formatOption(badInput);

        //Then
        Assertions.assertArrayEquals(expected, actual);
    }
}
