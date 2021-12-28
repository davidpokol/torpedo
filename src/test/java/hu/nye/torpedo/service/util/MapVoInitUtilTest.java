package hu.nye.torpedo.service.util;

import java.io.*;

import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.input.MapReader;
import hu.nye.torpedo.service.ship.ShipGenerator;
import hu.nye.torpedo.service.ship.ShipPlacer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapVoInitUtilTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final MapReader mapReader = new MapReader();
    private final FileDataValidatorUtil fileDataValidatorUtil = new FileDataValidatorUtil();
    private final FileManagerUtil fileManagerUtil = new FileManagerUtil();
    private final MapUtil mapUtil = new MapUtil();
    private final BufferedInputStream is = new BufferedInputStream(System.in);
    private final DataReader dataReader = new DataReader(new BufferedReader(new InputStreamReader(is)));
    private final ShipGenerator shipGenerator = new ShipGenerator();
    private final ShipPlacer shipPlacer = new ShipPlacer();
    private final MapVoInitUtil underTest = new MapVoInitUtil
            (mapReader,fileDataValidatorUtil,fileManagerUtil, mapUtil, dataReader, shipGenerator, shipPlacer);

    @Test
    public void testMapVoInitShouldReturnWithNotNullMapVo() {

        //Given

        //When
        MapVO actual = underTest.mapVoInit();

        //Then
        Assertions.assertNotNull(actual);
    }

    @Test
    public void testMapVoInitShouldReturnWithNotEmptyMapVo() {

        //Given

        //When
        MapVO actual = underTest.mapVoInit();

        //Then
        Assertions.assertNotEquals(0, actual.getMap().length);
        Assertions.assertNotEquals(0, actual.getShipMap().length);
    }

    @Test
    public void testUserMapVoInitShouldReturnAsaBigMapAsCpuMap() {

        /*//Given
        ByteArrayInputStream in = new ByteArrayInputStream("name".getBytes());
        int expected = 5;

        //When
        int actual = underTest.userMapVoInit(expected).getMapSize();
        System.setIn(in);

        //Then
        Assertions.assertEquals(expected, actual);*/
    }
}
