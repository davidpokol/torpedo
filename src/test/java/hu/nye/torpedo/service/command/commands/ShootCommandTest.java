package hu.nye.torpedo.service.command.commands;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.service.game.GameCycle;
import hu.nye.torpedo.service.game.GameManager;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.util.CpuPointGeneratorUtil;
import hu.nye.torpedo.service.util.PointValidatorUtil;
import hu.nye.torpedo.service.util.ShipReferenceUtil;
import hu.nye.torpedo.ui.MapDisplayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShootCommandTest {

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

    GameState gameState = new GameState
            (new MapVO(MAP, SHIP_MAP), new UserMapVO(MAP, SHIP_MAP, "name"), false);

    GameManager gameManager = new GameManager(gameState);
    BufferedInputStream is = new BufferedInputStream(System.in);
    DataReader dataReader = new DataReader(new BufferedReader(new InputStreamReader(is)));
    ShipReferenceUtil shipReferenceUtil = new ShipReferenceUtil();
    CpuPointGeneratorUtil cpuPointGeneratorUtil = new CpuPointGeneratorUtil(gameState);
    PointValidatorUtil pointValidatorUtil = new PointValidatorUtil();

    MapDisplayer mapDisplayer = new MapDisplayer(gameState);
    ShowCommand showCommand = new ShowCommand(mapDisplayer);
    GameCycle gameCycle = new GameCycle(gameState, null, null);


    ShootCommand underTest = new ShootCommand(gameState,gameManager,dataReader,shipReferenceUtil,cpuPointGeneratorUtil,
            pointValidatorUtil, gameCycle, showCommand);

    @Test
    public void testCanProcessShouldReturnTrueWhenTheInputIsSave() {

        // Given
        String input = "shoot";

        // When
        boolean actual = underTest.canProcess(input);

        // Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheInputIsNotSave() {

        // Given
        String input = "not-shoot";

        // When
        boolean actual = underTest.canProcess(input);

        // Then
        Assertions.assertFalse(actual);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheInputIsNull() {

        // Given
        String input = null;

        // When
        boolean actual = underTest.canProcess(input);

        // Then
        Assertions.assertFalse(actual);
    }
}
