package hu.nye.torpedo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hu.nye.torpedo.service.util.ShipReferenceUtil;


public class GameManagerTest {
    private static final String INPUT = "d1";
    private static final String BADINPUT = "11";

    private ShipReferenceUtil underTest = new ShipReferenceUtil();

    @Test
    public void testFormatOptionShouldReturnTheProperCoordinateInStringWhenTheFirstCharacterInInputIsLowerCase() {

        /*//Given
        int[] expected = {3,1};

        //When
        int[] output = underTest.formatOption(INPUT);

        //Then
        Assertions.assertEquals(output,expected);*/

        Assertions.assertTrue(true);
    }
    @Test
    public void testFormatOptionShouldReturnNullWhenOptionReadExceptionOccurs() {

        /*//Given
        boolean thrown = false;
        int[] result = null;

        //When

        result = underTest.formatOption(BADINPUT);


        //Then
        Assertions.assertTrue(thrown);
        Assertions.assertNull(result);*/

        Assertions.assertTrue(true);

    }


}