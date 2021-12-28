package hu.nye.torpedo.service.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileManagerUtilTest {

    FileManagerUtil underTest = new FileManagerUtil();

    @Test
    public void testGetPreparedMapShouldReturnAShipMapConvertedByTheInputList() {

        //given
        boolean[][] actual;
        boolean[][] expected = {{false,false,true,false},{true,false,false,true},
                                {true,false,false,true},{false,false,false,true}};
        List<String> lines = List.of("0010","1001","1001","0001");

        //when
        actual = underTest.getPreparedMap(lines);

        //then
        Assertions.assertTrue(Arrays.deepEquals(actual, expected));
    }
}
