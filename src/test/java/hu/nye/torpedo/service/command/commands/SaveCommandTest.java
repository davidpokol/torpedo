package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.model.MapVO;
import hu.nye.torpedo.persistance.jdbc.JdbcGameManager;
import hu.nye.torpedo.persistance.jdbc.JdbcGameSavesRepository;
import hu.nye.torpedo.service.input.DataReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SaveCommandTest {
    private SaveCommand underTest;

    private JdbcGameSavesRepository jdbcGameSavesRepository;
    private GameState gameState;
    private DataReader dataReader;

    @BeforeEach
    public void init() {
        jdbcGameSavesRepository = Mockito.mock(JdbcGameSavesRepository.class);
        gameState = Mockito.mock(GameState.class);
        dataReader = Mockito.mock(DataReader.class);
        underTest = new SaveCommand(jdbcGameSavesRepository, gameState, dataReader);
    }

    @Test
    public void testCanProcessShouldReturnTrueWhenTheInputIsSave() {
        // Given
        String input = "save";

        // When
        boolean actual = underTest.canProcess(input);

        // Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCanProcessShouldReturnFalseWhenTheInputIsNotSave() {
        // Given
        String input = "load";

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
