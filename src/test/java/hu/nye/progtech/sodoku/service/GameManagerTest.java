package hu.nye.progtech.sodoku.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sevice.GameManager;
import sevice.exeption.OptionReadException;


public class GameManagerTest {
    private static final String INPUT = "d1";
    private static final String BADINPUT = "11";

    private GameManager underTest = new GameManager();

    @Test
    public void testFormatOptionShouldReturnTheProperCoordinateInStringWhenTheFirstCharacterInInputIsLowerCase() throws OptionReadException {

        //Given
        String expected ="31";

        //When
        String output = underTest.formatOption(INPUT);

        //Then
        Assertions.assertEquals(output,expected);

    }
    @Test
    public void testFormatOptionShouldReturnNullWhenOptionReadExceptionOccurs(){

        //Given
        boolean thrown = false;
        String result = null;

        //When
        try {
            result = underTest.formatOption(BADINPUT);
        } catch (OptionReadException e) {
            thrown = true;
        }

        //Then
        Assertions.assertTrue(thrown);
        Assertions.assertNull(result);

    }


}
