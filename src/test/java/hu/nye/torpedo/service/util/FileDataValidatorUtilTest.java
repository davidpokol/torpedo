package hu.nye.torpedo.service.util;

import java.util.List;

import hu.nye.torpedo.service.exception.FileDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileDataValidatorUtilTest {

    private final FileDataValidatorUtil underTest = new FileDataValidatorUtil();
    public static final List<String> GOOD_MAP_LINES = List.of("0010","1001","1001","0001");

    @Test
    public void testIsValidMapShouldReturnWhenMapIsValid() throws FileDataException {

        //Given
        boolean actual;

        //When
        actual = underTest.isValidMap(GOOD_MAP_LINES);

        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testIsValidMapShouldThrowFileDataExceptionWhenMapSizeIsNotBetweenFourAndNine() {

        //Given
        List<String> input = List.of("000","000","000");

        //When-Then
        FileDataException thrown = Assertions.assertThrows(FileDataException.class, () -> {
            underTest.isValidMap(input);
        });

        Assertions.assertEquals("The CPU's map size must be between 4 and 9", thrown.getMessage());
    }

    @Test
    public void testIsValidMapShouldThrowFileDataExceptionWhenMapIsNotSquared() {

        //Given
        List<String> input = List.of("0000","0000","0000","0000","0");

        //When-Then
        FileDataException thrown = Assertions.assertThrows(FileDataException.class, () -> {
            underTest.isValidMap(input);
        });

        Assertions.assertEquals("The CPU's map must be squared!", thrown.getMessage());
    }

    @Test
    public void testIsValidMapShouldThrowFileDataExceptionWhenMapIsNotFilledUpWithOnlyZeroAndOneValues() {

        //Given
        List<String> input = List.of("1000","0000","0000","2000");

        //When-Then
        FileDataException thrown = Assertions.assertThrows(FileDataException.class, () -> {
            underTest.isValidMap(input);
        });

        Assertions.assertEquals("The CPU's map must be filled up with only 0 and 1 values!", thrown.
                getMessage());
    }

    @Test
    public void testIsValidMapShouldThrowFileDataExceptionWhenMapHasMoreShipsThenExpected() {

        //Given
        List<String> input = List.of("1000","1100","1110","1111");

        //When-Then
        FileDataException thrown = Assertions.assertThrows(FileDataException.class, () -> {
            underTest.isValidMap(input);
        });

        Assertions.assertEquals("The CPU's map must has proper number of ships!", thrown.
                getMessage());
    }
}
