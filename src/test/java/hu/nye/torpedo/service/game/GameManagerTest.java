package hu.nye.torpedo.service.game;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

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

    GameState gameState = new GameState(new MapVO(MAP, SHIP_MAP), new UserMapVO(MAP, SHIP_MAP, "name"),
            false);

    GameManager underTest = new GameManager(gameState);

    @Test
    public void testFireAtPointShouldReturnTrueWhenShotHits() {

        //Given
        int[] coordinates = {0, 2};

        //When
        boolean actual = underTest.fireAtPoint(coordinates);

        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testFireAtPointShouldReturnFalseWhenNotShotHits() {

        //Given
        int[] coordinates = {0, 0};

        //When
        boolean actual = underTest.fireAtPoint(coordinates);

        //Then
        Assertions.assertFalse(actual);
    }

    @Test
    public void testCpuShootShouldReturnReturnTrueWhenShotHits() {

        int[] coordinates = {0, 2};

        //When
        boolean actual = underTest.cpuShoot(coordinates);

        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCpuShootShouldReturnReturnFalseWhenNotShotHits() {

        //Given
        int[] coordinates = {0, 0};

        //When
        boolean actual = underTest.cpuShoot(coordinates);

        //Then
        Assertions.assertFalse(actual);
    }
}
