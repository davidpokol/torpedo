package hu.nye.torpedo.service.command.commands;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.model.UserMapVO;
import hu.nye.torpedo.persistance.jdbc.JdbcGameManager;
import hu.nye.torpedo.persistance.jdbc.JdbcGameSavesRepository;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.util.MapToStringUtil;
import hu.nye.torpedo.service.util.MapUnWrapperUtil;
import hu.nye.torpedo.service.util.MapUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoadCommandTest {

    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final MapUtil mapUtil = new MapUtil();
    private final MapToStringUtil mapToStringUtil = new MapToStringUtil(mapUtil);
    private final Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    private final JdbcGameManager jdbcGameManager = new JdbcGameManager(connection, mapToStringUtil);
    private final MapUnWrapperUtil mapUnWrapperUtil = new MapUnWrapperUtil();
    private final JdbcGameSavesRepository jdbcGameSavesRepository = new JdbcGameSavesRepository(connection, jdbcGameManager, mapUnWrapperUtil);

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

    BufferedInputStream is = new BufferedInputStream(System.in);
    DataReader dataReader = new DataReader(new BufferedReader(new InputStreamReader(is)));
    private final LoadCommand underTest = new LoadCommand
            (jdbcGameSavesRepository, jdbcGameManager, gameState, dataReader);

    public LoadCommandTest() throws SQLException {
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenTheInputIsSave() {
        // Given
        String input = "load";

        // When
        boolean actual = underTest.canProcess(input);

        // Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheInputIsNotSave() {
        // Given
        String input = "save";

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

    @Test
    public void testProcessShouldShowAWarningMessageWhenUserHasNoSaveToLoad() {
        // Given
        System.setOut(new PrintStream(outContent));
        String expected = "You don't have any saved games yet.";

        // When
        underTest.process("");

        // Then
        Assertions.assertEquals(expected.toString(), outContent.toString().trim());
    }
}
